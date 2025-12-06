package model;

public class Avaliacao {
    private double nota; // Atributo privado
    private String descricao; // Atributo privado

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1.0; // Valor inicial que indica que a nota ainda não foi atribuída
    }

    // Método para atribuir a nota com validação (Encapsulamento)
    public boolean atribuirNota(double valor) {
        if (valor >= 0.0 && valor <= 10.0) {
            this.nota = valor;
            return true;
        } else {
            System.out.println("Erro: A nota deve estar entre 0 e 10.");
            return false;
        }
    }

    // Getters públicos
    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setter para descricao (se necessário, mas nota é controlada)
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Avaliação: %s | Nota: %.1f", descricao, nota);
    }
}
