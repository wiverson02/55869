package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes;

    public Aluno(String nome, String matricula, Curso curso, String login, String senha) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoes = new ArrayList<>();
    }

    // Getters

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public double calcularMedia() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        double soma = 0;
        int count = 0;
        for (Avaliacao a : avaliacoes) {
            if (a.getNota() != -1.0) { // Considera apenas notas atribuídas
                soma += a.getNota();
                count++;
            }
        }
        return count > 0 ? soma / count : 0.0;
    }
    // Setters

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String getTipoUsuario() {
        return "Aluno";
    }

    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Relatório do Aluno:\nMatrícula: %s\nNome: %s\nCurso: %s\n",
                matricula, nome, curso.getNome()));
        sb.append("--- Avaliações ---\n");
        if (avaliacoes.isEmpty()) {
            sb.append("Nenhuma avaliação registrada.\n");
        } else {
            for (Avaliacao a : avaliacoes) {
                sb.append(a.toString()).append("\n");
            }
            sb.append(String.format("Média Final: %.2f\n", calcularMedia()));
        }
        return sb.toString();
    }
}
