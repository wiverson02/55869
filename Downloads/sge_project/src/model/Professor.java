package model;

public class Professor extends Usuario {
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro, String login, String senha) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    // Getters

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    // Setters

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String getTipoUsuario() {
        return "Professor";
    }

    public String gerarRelatorio() {
        return String.format("Relatório do Professor:\nRegistro: %s\nNome: %s\nEspecialidade: %s",
                registro, nome, especialidade);
    }
}
