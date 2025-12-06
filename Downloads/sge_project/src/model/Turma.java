package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    // Métodos para adicionar/remover alunos
    public void adicionarAluno(Aluno aluno) {
        if (!listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + codigo);
        } else {
            System.out.println("Aluno " + aluno.getNome() + " já está matriculado nesta turma.");
        }
    }

    public void removerAluno(Aluno aluno) {
        if (listaAlunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + codigo);
        } else {
            System.out.println("Aluno " + aluno.getNome() + " não encontrado nesta turma.");
        }
    }

    // Método para mostrar resumo da turma
    public String mostrarResumo() {
        return String.format(
            "Resumo da Turma %s:\n" +
            "  Curso: %s\n" +
            "  Professor: %s\n" +
            "  Alunos Matriculados: %d",
            codigo,
            curso.getNome(),
            professor.getNome(),
            listaAlunos.size()
        );
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
}
