package model;

/**
 * Classe que representa um usuário do sistema.
 * Contém os atributos id, login, senha e tipo de usuário.
 * Fornece métodos getters e setters para manipulação dos dados.
 * 
 * Essa classe é usada para controle de acesso e permissões.
 * 
 * Tipos de usuário possíveis: "Administrador", "Atendente", etc.
 * 
 * @author Anthony
 */
public class Usuario {

    private int id; // Identificador único do usuário
    private String login; // Nome de login do usuário
    private String senha; // Senha de acesso
    private String tipoUsuario; // Tipo de usuário (permissão)

    /**
     * Retorna o ID do usuário.
     * @return ID do usuário.
     */
    public int getId() { return id; }

    /**
     * Define o ID do usuário.
     * @param id ID a ser definido.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Retorna o login do usuário.
     * @return login do usuário.
     */
    public String getLogin() { return login; }

    /**
     * Define o login do usuário.
     * @param login Login a ser definido.
     */
    public void setLogin(String login) { this.login = login; }

    /**
     * Retorna a senha do usuário.
     * @return senha do usuário.
     */
    public String getSenha() { return senha; }

    /**
     * Define a senha do usuário.
     * @param senha Senha a ser definida.
     */
    public void setSenha(String senha) { this.senha = senha; }

    /**
     * Retorna o tipo do usuário.
     * @return tipo do usuário.
     */
    public String getTipoUsuario() { return tipoUsuario; }

    /**
     * Define o tipo do usuário.
     * @param tipoUsuario Tipo a ser definido (ex: Administrador, Atendente).
     */
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}


