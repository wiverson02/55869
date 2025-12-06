package model;

public class CursoPresencial extends Curso {
    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }

    public void setSalaDeAula(String salaDeAula) {
        this.salaDeAula = salaDeAula;
    }

    // Sobrescrita do método (Polimorfismo)
    @Override
    public String detalharCurso() {
        return String.format("Tipo: Presencial\nCarga Horária: %d horas\nSala de Aula: %s",
                getCargaHoraria(), salaDeAula);
    }
}
