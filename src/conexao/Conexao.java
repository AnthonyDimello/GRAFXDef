package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por fornecer a conexão com o banco de dados MySQL.
 */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/grafx3";
    private static final String USUARIO = "root";
    private static final String SENHA = "121424@nthonY";

    /**
     * Estabelece uma conexão com o banco de dados.
     *
     * @return um objeto {@link Connection} se a conexão for bem-sucedida, ou {@code null} em caso de erro.
     */
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}


