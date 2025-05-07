package model;

/**
 * Classe que representa um Atendente do sistema.
 * Contém os atributos: nome, telefone, CPF e senha.
 * Fornece construtores, getters e setters para manipulação dos dados.
 * 
 * Essa classe é usada para cadastrar e autenticar atendentes no sistema.
 * 
 * @author Anthony
 */
public class Atendente {
    private String nome;
    private String telefone;
    private String cpf;
    private String senha;

    /**
     * Construtor completo que inicializa todos os atributos do atendente.
     *
     * @param nome Nome do atendente.
     * @param telefone Telefone do atendente.
     * @param cpf CPF do atendente.
     * @param senha Senha de acesso do atendente.
     */
    public Atendente(String nome, String telefone, String cpf, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
    }

    /**
     * Construtor padrão vazio.
     */
    public Atendente() {
    }

    /**
     * Retorna o nome do atendente.
     * @return nome do atendente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do atendente.
     * @param nome Nome a ser definido.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone do atendente.
     * @return telefone do atendente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do atendente.
     * @param telefone Telefone a ser definido.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o CPF do atendente.
     * @return CPF do atendente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do atendente.
     * @param cpf CPF a ser definido.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna a senha do atendente.
     * @return senha do atendente.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do atendente.
     * @param senha Senha a ser definida.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}


