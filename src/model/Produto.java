package model;

/**
 * Classe que representa um Produto do sistema.
 * Contém os atributos: id, descrição, quantidade e valor unitário.
 * Fornece construtores, getters, setters e método toString para manipulação e exibição.
 * 
 * Essa classe é utilizada para cadastro e gerenciamento de produtos.
 * 
 * @author Anthony
 */
public class Produto {
    private int id; // Identificador do produto
    private String descricao; // Descrição do produto
    private int quantidade; // Quantidade em estoque
    private double valorUnitario; // Valor unitário do produto

    /**
     * Construtor padrão vazio.
     */
    public Produto() {
    }

    /**
     * Construtor completo que inicializa todos os atributos do produto.
     *
     * @param id Identificador do produto.
     * @param descricao Descrição do produto.
     * @param quantidade Quantidade do produto.
     * @param valorUnitario Valor unitário do produto.
     */
    public Produto(int id, String descricao, int quantidade, double valorUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    /**
     * Retorna o ID do produto.
     * @return ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     * @param id ID a ser definido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna a descrição do produto.
     * @return descrição do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     * @param descricao Descrição a ser definida.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a quantidade do produto.
     * @return quantidade do produto.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do produto.
     * @param quantidade Quantidade a ser definida.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor unitário do produto.
     * @return valor unitário do produto.
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Define o valor unitário do produto.
     * @param valorUnitario Valor unitário a ser definido.
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Retorna a descrição do produto como representação textual.
     * @return descrição do produto.
     */
    @Override
    public String toString() {
        return descricao;
    }
}
