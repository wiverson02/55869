package model;

public class CursoEAD extends Curso {
    private String plataformaVirtual;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }

    public void setPlataformaVirtual(String plataformaVirtual) {
        this.plataformaVirtual = plataformaVirtual;
    }

    // Sobrescrita do método (Polimorfismo)
    @Override
    public String detalharCurso() {
        return String.format("Tipo: EAD\nCarga Horária: %d horas\nPlataforma Virtual: %s",
                getCargaHoraria(), plataformaVirtual);
    }
}
