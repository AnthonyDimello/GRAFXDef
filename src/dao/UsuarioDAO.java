package dao;

import java.sql.*;
import model.Usuario;
import conexao.Conexao;

/**
 * Classe responsável pelas operações de acesso ao banco de dados
 * relacionadas ao usuário, como autenticação.
 * 
 * Fornece método para login do usuário com base em credenciais informadas.
 * 
 * {@author Anthony}
 */
public class UsuarioDAO {

    /**
     * Realiza a autenticação do usuário no sistema com base no login e senha.
     *
     * @param login o nome de login informado pelo usuário
     * @param senha a senha informada pelo usuário
     * @return um objeto {@code Usuario} se as credenciais forem válidas; {@code null} caso contrário
     * @throws RuntimeException se ocorrer algum erro ao acessar o banco de dados
     */
    public Usuario fazerLogin(String login, String senha) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                return usuario;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro no login: " + e.getMessage());
        }

        return null;
    }
}

