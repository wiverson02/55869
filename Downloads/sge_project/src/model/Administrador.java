package model;

public class Administrador extends Usuario {
    private String setor;

    public Administrador(String nome, String setor, String login, String senha) {
        super(nome, login, senha);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
