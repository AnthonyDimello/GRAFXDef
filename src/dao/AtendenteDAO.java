package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Atendente;

/**
 * Classe responsável pelas operações de banco de dados relacionadas aos atendentes.
 * Realiza cadastro, login e busca por nome.
 *
 * @author Anthony
 */
public class AtendenteDAO {

    /**
     * Cadastra um novo atendente no banco de dados.
     * Verifica se o CPF já está cadastrado para evitar duplicidade.
     * Também cria um registro na tabela de usuários com tipo "Atendente".
     *
     * @param atendente o objeto Atendente contendo os dados a serem cadastrados
     * @return {@code true} se o cadastro for bem-sucedido, {@code false} caso contrário
     */
    public boolean cadastrarAtendente(Atendente atendente) {
        String verificarSql = "SELECT COUNT(*) FROM atendentes WHERE cpf = ?";
        String inserirAtendenteSql = "INSERT INTO atendentes (nome, telefone, cpf, senha) VALUES (?, ?, ?, ?)";
        String inserirUsuarioSql = "INSERT INTO usuario (login, senha, tipo_usuario) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement verificarStmt = conn.prepareStatement(verificarSql)) {

            // Verifica se já existe atendente com o mesmo CPF
            verificarStmt.setString(1, atendente.getCpf());
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Atendente já cadastrado com este CPF!");
                return false;
            }

            conn.setAutoCommit(false); // Inicia transação

            try (PreparedStatement inserirAtendenteStmt = conn.prepareStatement(inserirAtendenteSql);
                 PreparedStatement inserirUsuarioStmt = conn.prepareStatement(inserirUsuarioSql)) {

                // Insere os dados do atendente
                inserirAtendenteStmt.setString(1, atendente.getNome());
                inserirAtendenteStmt.setString(2, atendente.getTelefone());
                inserirAtendenteStmt.setString(3, atendente.getCpf());
                inserirAtendenteStmt.setString(4, atendente.getSenha());
                inserirAtendenteStmt.executeUpdate();

                // Insere os dados do usuário
                inserirUsuarioStmt.setString(1, atendente.getNome()); // Login será o nome
                inserirUsuarioStmt.setString(2, atendente.getSenha());
                inserirUsuarioStmt.setString(3, "Atendente");
                inserirUsuarioStmt.executeUpdate();

                conn.commit(); // Confirma as inserções
                return true;

            } catch (SQLException ex) {
                conn.rollback(); // Desfaz alterações em caso de erro
                throw ex;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar atendente: " + e.getMessage());
            return false;
        }
    }

    /**
     * Realiza o login de um atendente a partir do CPF e da senha.
     *
     * @param login o CPF usado como login
     * @param senha a senha do atendente
     * @return um objeto Atendente se o login for bem-sucedido, {@code null} caso contrário
     */
    public Atendente fazerLogin(String login, String senha) {
        String sql = "SELECT * FROM atendentes WHERE cpf = ? AND senha = ?";
        Atendente atendente = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                atendente = new Atendente();
                atendente.setNome(rs.getString("nome"));
                atendente.setCpf(rs.getString("cpf"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro no login: " + e.getMessage());
        }

        return atendente;
    }

    /**
     * Busca nomes de atendentes que contenham o trecho informado.
     *
     * @param trecho parte do nome a ser buscado
     * @return uma lista com os nomes encontrados
     */
    public List<String> buscarNomesPorTrecho(String trecho) {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM atendentes WHERE nome LIKE ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + trecho + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nomes;
    }
}

