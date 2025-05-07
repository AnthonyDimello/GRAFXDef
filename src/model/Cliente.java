package model;

/**
 * Classe que representa um Cliente do sistema.
 * Contém os atributos: nome, telefone, CPF, email e endereço.
 * Fornece construtores, getters e setters para manipulação dos dados.
 * 
 * Essa classe é utilizada para cadastro e gerenciamento de clientes.
 * 
 * @author Anthony
 */
public class Cliente {
    private String nome, telefone, cpf, email, endereco;

    /**
     * Construtor completo que inicializa todos os atributos do cliente.
     *
     * @param nome Nome do cliente.
     * @param telefone Telefone do cliente.
     * @param cpf CPF do cliente.
     * @param email Email do cliente.
     * @param endereco Endereço do cliente.
     */
    public Cliente(String nome, String telefone, String cpf, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    /**
     * Construtor padrão vazio.
     */
    public Cliente() {
    }

    /**
     * Retorna o nome do cliente.
     * @return nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * @param nome Nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone do cliente.
     * @return telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     * @param telefone Telefone a ser definido.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o CPF do cliente.
     * @return CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     * @param cpf CPF a ser definido.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o email do cliente.
     * @return email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente.
     * @param email Email a ser definido.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o endereço do cliente.
     * @return endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     * @param endereco Endereço a ser definido.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}


