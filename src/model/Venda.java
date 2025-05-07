package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa uma venda realizada no sistema.
 * Contém informações sobre o produto vendido, cliente, data, valores e atendente.
 * 
 * Fornece métodos para manipulação e formatação de dados, especialmente a data.
 * 
 * @author Anthony
 */
public class Venda {
    private String descricao;        // Descrição do produto
    private String clienteNome;      // Nome do cliente
    private String cpf;              // CPF do cliente
    private String dataVenda;        // Data da venda (formato dd/MM/yyyy)
    private String formaPagamento;   // Forma de pagamento utilizada
    private String atendente;        // Nome do atendente responsável
    private int quantidade;          // Quantidade de produtos vendidos
    private double valorUnitario;    // Valor unitário do produto
    private double valorTotal;       // Valor total da venda

    /**
     * Construtor com parâmetros para inicializar todos os campos da venda.
     * 
     * @param descricao Descrição do produto
     * @param clienteNome Nome do cliente
     * @param cpf CPF do cliente
     * @param dataVenda Data da venda (formato dd/MM/yyyy)
     * @param quantidade Quantidade de itens
     * @param formaPagamento Forma de pagamento
     * @param valorUnitario Valor unitário do produto
     * @param valorTotal Valor total da venda
     * @param atendente Nome do atendente
     */
    public Venda(String descricao, String clienteNome, String cpf, String dataVenda, int quantidade,
                 String formaPagamento, double valorUnitario, double valorTotal, String atendente) {
        this.descricao = descricao;
        this.clienteNome = clienteNome;
        this.cpf = cpf;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.formaPagamento = formaPagamento;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.atendente = atendente;
    }

    /**
     * Construtor vazio da classe Venda.
     */
    public Venda() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Converte a data da venda do formato brasileiro (dd/MM/yyyy)
     * para o formato aceito pelo MySQL (yyyy-MM-dd).
     * 
     * @return String com a data no formato MySQL ou null se ocorrer erro de conversão.
     */
    public String getDataVendaFormatadaParaMySQL() {
        try {
            SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatoBr.parse(dataVenda);
            SimpleDateFormat formatoMySQL = new SimpleDateFormat("yyyy-MM-dd");
            return formatoMySQL.format(data);
        } catch (ParseException e) {
            return null;
        }
    }
}

