package service;

import model.*;
import repository.RepositorioGeral;

public class ServicoAcademico {
    private RepositorioGeral repositorio;

    public ServicoAcademico(RepositorioGeral repositorio) {
        this.repositorio = repositorio;
    }

    // Métodos de Cadastro
    public void cadastrarAluno(Aluno aluno) {
        if (repositorio.buscarAlunoPorMatricula(aluno.getMatricula()) == null) {
            repositorio.getAlunos().add(aluno);
            System.out.println("Aluno cadastrado com sucesso: " + aluno.getNome());
        } else {
            System.out.println("Erro: Matrícula já existe.");
        }
    }

    public void cadastrarProfessor(Professor professor) {
        if (repositorio.buscarProfessorPorRegistro(professor.getRegistro()) == null) {
            repositorio.getProfessores().add(professor);
            System.out.println("Professor cadastrado com sucesso: " + professor.getNome());
        } else {
            System.out.println("Erro: Registro já existe.");
        }
    }

    public void cadastrarCurso(Curso curso) {
        if (repositorio.buscarCursoPorCodigo(curso.getCodigo()) == null) {
            repositorio.getCursos().add(curso);
            System.out.println("Curso cadastrado com sucesso: " + curso.getNome());
        } else {
            System.out.println("Erro: Código do curso já existe.");
        }
    }

    public void criarTurma(Turma turma) {
        if (repositorio.buscarTurmaPorCodigo(turma.getCodigo()) == null) {
            repositorio.getTurmas().add(turma);
            System.out.println("Turma criada com sucesso: " + turma.getCodigo());
        } else {
            System.out.println("Erro: Código da turma já existe.");
        }
    }

    // Métodos de Operação
    public boolean matricularAlunoEmTurma(String matriculaAluno, String codigoTurma) {
        Aluno aluno = repositorio.buscarAlunoPorMatricula(matriculaAluno);
        Turma turma = repositorio.buscarTurmaPorCodigo(codigoTurma);

        if (aluno != null && turma != null) {
            turma.adicionarAluno(aluno);
            return true;
        } else {
            System.out.println("Erro: Aluno ou Turma não encontrados.");
            return false;
        }
    }

    public boolean registrarAvaliacao(String matriculaAluno, String codigoTurma, String descricao, double nota) {
        Aluno aluno = repositorio.buscarAlunoPorMatricula(matriculaAluno);
        Turma turma = repositorio.buscarTurmaPorCodigo(codigoTurma);

        if (aluno == null || turma == null) {
            System.out.println("Erro: Aluno ou Turma não encontrados.");
            return false;
        }

        // Verifica se o aluno está na turma (simplificação: assume que a avaliação é para o curso da turma)
        if (!turma.getListaAlunos().contains(aluno)) {
            System.out.println("Erro: Aluno não está matriculado nesta turma.");
            return false;
        }

        Avaliacao avaliacao = new Avaliacao(descricao);
        if (avaliacao.atribuirNota(nota)) {
            aluno.adicionarAvaliacao(avaliacao);
            System.out.println("Nota registrada com sucesso para o aluno " + aluno.getNome());
            return true;
        }
        return false;
    }

    // Métodos de Relatório (Fase 6 - Polimorfismo)
    public void gerarRelatorioGeral() {
        System.out.println("\n=======================================");
        System.out.println("       RELATÓRIO GERAL DO SISTEMA      ");
        System.out.println("=======================================");

        System.out.println("\n--- Relatórios de Cursos ---");
        for (Curso c : repositorio.getCursos()) {
            System.out.println(c.gerarRelatorio());
            System.out.println(c.detalharCurso());
            System.out.println("---------------------------------------");
        }

        System.out.println("\n--- Relatórios de Professores ---");
        for (Professor p : repositorio.getProfessores()) {
            System.out.println(p.gerarRelatorio());
            System.out.println("---------------------------------------");
        }

        System.out.println("\n--- Relatórios de Alunos ---");
        for (Aluno a : repositorio.getAlunos()) {
            System.out.println(a.gerarRelatorio());
            System.out.println("---------------------------------------");
        }

        System.out.println("\n--- Resumo de Turmas ---");
        for (Turma t : repositorio.getTurmas()) {
            System.out.println(t.mostrarResumo());
            System.out.println("---------------------------------------");
        }
    }
    
    // Método de Autenticação
    public Usuario autenticarUsuario(String login, String senha) {
        Usuario usuario = repositorio.buscarUsuarioPorLogin(login);
        if (usuario != null && usuario.autenticar(login, senha)) {
            return usuario;
        }
        return null;
    }
}
