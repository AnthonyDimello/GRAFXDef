package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Venda;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Classe responsável pelas operações de persistência relacionadas à entidade Venda.
 * Utiliza JDBC para inserir registros de venda no banco de dados.
 * 
 * @author Anthony
 */


public class VendaDAO {
    
    /**
     * Insere uma nova venda na tabela "venda" do banco de dados.
     * Realiza a conversão da data do formato brasileiro (dd/MM/yyyy) para o formato MySQL (yyyy-MM-dd).
     *
     * @param venda Objeto do tipo Venda contendo todos os dados da venda a ser cadastrada.
     * @return true se a venda for cadastrada com sucesso, false em caso de falha.
     */
    
    
    
    public boolean cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO venda (descricao_produto, nome_cliente, cpf_cliente, data_venda, quantidade, forma_pagamento, valor_unitario, valor_total, nome_atendente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Converter data
            String dataFormatada;
            try {
                SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
                Date data = formatoBr.parse(venda.getDataVenda());

                SimpleDateFormat formatoMySQL = new SimpleDateFormat("yyyy-MM-dd");
                dataFormatada = formatoMySQL.format(data);
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao converter data: " + ex.getMessage());
            }

            stmt.setString(1, venda.getDescricao());
            stmt.setString(2, venda.getClienteNome());
            stmt.setString(3, venda.getCpf());
            stmt.setString(4, venda.getDataVendaFormatadaParaMySQL()); // data já convertida para o formato correto
            stmt.setInt(5, venda.getQuantidade());
            stmt.setString(6, venda.getFormaPagamento());
            stmt.setDouble(7, venda.getValorUnitario());
            stmt.setDouble(8, venda.getValorTotal());
            stmt.setString(9, venda.getAtendente());

             int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}

