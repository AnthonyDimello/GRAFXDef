package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.Produto;

/**
 * Classe responsável pelas operações de banco de dados relacionadas aos produtos.
 * Inclui métodos para cadastro, consulta, busca por descrição e atualização de estoque.
 * 
 * @author Anthony
 */
public class ProdutoDAO {

    /**
     * Cadastra um novo produto no banco de dados, verificando se já existe um produto
     * com a mesma descrição antes de inserir.
     *
     * @param produto o objeto Produto com os dados a serem inseridos
     * @return {@code true} se o produto for cadastrado com sucesso, {@code false} caso contrário
     */
    public boolean cadastrarProduto(Produto produto) {
        String verificarSql = "SELECT COUNT(*) FROM produto WHERE descricao = ?";
        String inserirSql = "INSERT INTO produto (descricao, quantidade, valor_unitario) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement verificarStmt = conn.prepareStatement(verificarSql)) {

            verificarStmt.setString(1, produto.getDescricao());
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Produto já cadastrado com esta descrição!");
                return false;
            }

            try (PreparedStatement inserirStmt = conn.prepareStatement(inserirSql)) {
                inserirStmt.setString(1, produto.getDescricao());
                inserirStmt.setInt(2, produto.getQuantidade());
                inserirStmt.setDouble(3, produto.getValorUnitario());

                int linhasAfetadas = inserirStmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar o produto.");
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retorna uma lista com todos os produtos cadastrados no banco de dados.
     *
     * @return lista de objetos Produto
     */
    public List<Produto> buscarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValorUnitario(rs.getDouble("valor_unitario"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Busca produtos com base em um texto que deve estar contido na descrição.
     *
     * @param texto termo a ser buscado na descrição dos produtos
     * @return lista de produtos que contêm o termo na descrição
     */
    public List<Produto> buscarPorDescricao(String texto) {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE descricao LIKE ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + texto + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setValorUnitario(rs.getDouble("valor_unitario"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Atualiza a quantidade em estoque de um produto específico com base no ID.
     *
     * @param idProduto o ID do produto a ser atualizado
     * @param novaQuantidade nova quantidade a ser definida no estoque
     * @return {@code true} se a atualização foi bem-sucedida, {@code false} caso contrário
     */
    public boolean atualizarEstoque(int idProduto, int novaQuantidade) {
        String sql = "UPDATE produto SET quantidade = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, idProduto);

            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

