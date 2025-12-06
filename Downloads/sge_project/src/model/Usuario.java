package model;

public abstract class Usuario implements Autenticacao {
    protected String login;
    protected String senha;
    protected String nome;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Implementação básica da interface Autenticacao
    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método abstrato para forçar subclasses a definir seu tipo
    public abstract String getTipoUsuario();
}
