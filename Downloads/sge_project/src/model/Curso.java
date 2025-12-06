package model;

public class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String detalharCurso() {
        return String.format("Tipo: Geral\nCarga Horária: %d horas", cargaHoraria);
    }

    public String gerarRelatorio() {
        return String.format("Relatório do Curso:\nCódigo: %s\nNome: %s\nCarga Horária: %d horas",
                codigo, nome, cargaHoraria);
    }
}
