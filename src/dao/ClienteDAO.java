package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.*;
import model.Cliente;

/**
 * Classe responsável pelas operações de banco de dados relacionadas aos clientes.
 * Inclui métodos para cadastro, verificação de CPF e listagem de todos os clientes.
 * 
 * @author Anthony
 */
public class ClienteDAO {

    /**
     * Cadastra um novo cliente no banco de dados.
     * Antes de inserir, verifica se o CPF já está cadastrado.
     *
     * @param cliente o objeto Cliente contendo os dados a serem cadastrados
     * @throws RuntimeException se o CPF já estiver cadastrado ou ocorrer erro de SQL
     */
    public void cadastrarCliente(Cliente cliente) {
        if (cpfExiste(cliente.getCpf())) {
            throw new RuntimeException("Cliente já cadastrado com este CPF.");
        }

        String sql = "INSERT INTO cliente (nome, telefone, cpf, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    /**
     * Retorna uma lista com todos os clientes cadastrados no banco de dados.
     *
     * @return lista de objetos Cliente
     */
    public List<Cliente> buscarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    /**
     * Verifica se já existe um cliente com o CPF informado no banco de dados.
     *
     * @param cpf o CPF a ser verificado
     * @return {@code true} se o CPF já estiver cadastrado, {@code false} caso contrário
     */
    public boolean cpfExiste(String cpf) {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true se já existir um registro
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar CPF: " + e.getMessage());
        }
    }
}


