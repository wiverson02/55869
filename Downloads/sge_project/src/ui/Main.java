package ui;

import model.*;
import repository.RepositorioGeral;
import service.ServicoAcademico;
import java.util.Scanner;

public class Main {
    private static RepositorioGeral repositorio = new RepositorioGeral();
    private static ServicoAcademico servico = new ServicoAcademico(repositorio);
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  Sistema de Gestão Educacional (SGE) - Java ");
        System.out.println("=============================================");

        while (usuarioLogado == null) {
            exibirMenuLogin();
        }

        System.out.println("\nLogin realizado com sucesso! Bem-vindo(a), " + usuarioLogado.getNome() + " (" + usuarioLogado.getTipoUsuario() + ").");

        while (true) {
            exibirMenuPrincipal();
        }
    }

    private static void exibirMenuLogin() {
        System.out.println("\n--- Autenticação ---");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        usuarioLogado = servico.autenticarUsuario(login, senha);

        if (usuarioLogado == null) {
            System.out.println("Erro: Login ou senha inválidos. Tente novamente.");
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Cadastros");
        System.out.println("2. Turmas e Matrículas");
        System.out.println("3. Registrar Avaliação");
        System.out.println("4. Gerar Relatórios");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    menuCadastros();
                    break;
                case 2:
                    menuTurmas();
                    break;
                case 3:
                    menuRegistrarAvaliacao();
                    break;
                case 4:
                    servico.gerarRelatorioGeral();
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
        }
    }

    private static void menuCadastros() {
        if (!(usuarioLogado instanceof Administrador)) {
            System.out.println("Acesso negado. Apenas Administradores podem realizar cadastros.");
            return;
        }

        System.out.println("\n--- Menu de Cadastros ---");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Professor");
        System.out.println("3. Cadastrar Curso (Presencial/EAD)");
        System.out.println("4. Voltar");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    private static void cadastrarAluno() {
        System.out.println("\n--- Cadastro de Aluno ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Código do Curso: ");
        String codCurso = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Curso curso = repositorio.buscarCursoPorCodigo(codCurso);
        if (curso == null) {
            System.out.println("Erro: Curso não encontrado.");
            return;
        }

        Aluno novoAluno = new Aluno(nome, matricula, curso, login, senha);
        servico.cadastrarAluno(novoAluno);
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- Cadastro de Professor ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Registro: ");
        String registro = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Professor novoProfessor = new Professor(nome, especialidade, registro, login, senha);
        servico.cadastrarProfessor(novoProfessor);
    }

    private static void cadastrarCurso() {
        System.out.println("\n--- Cadastro de Curso ---");
        System.out.print("Tipo (1-Presencial, 2-EAD): ");
        String tipo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = lerInteiro();

        Curso novoCurso = null;
        if (tipo.equals("1")) {
            System.out.print("Sala de Aula: ");
            String sala = scanner.nextLine();
            novoCurso = new CursoPresencial(nome, codigo, cargaHoraria, sala);
        } else if (tipo.equals("2")) {
            System.out.print("Plataforma Virtual: ");
            String plataforma = scanner.nextLine();
            novoCurso = new CursoEAD(nome, codigo, cargaHoraria, plataforma);
        } else {
            System.out.println("Tipo de curso inválido.");
            return;
        }

        servico.cadastrarCurso(novoCurso);
    }

    private static void menuTurmas() {
        System.out.println("\n--- Menu de Turmas ---");
        System.out.println("1. Criar Turma");
        System.out.println("2. Matricular Aluno em Turma");
        System.out.println("3. Voltar");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    criarTurma();
                    break;
                case 2:
                    matricularAluno();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    private static void criarTurma() {
        if (!(usuarioLogado instanceof Administrador)) {
            System.out.println("Acesso negado. Apenas Administradores podem criar turmas.");
            return;
        }
        
        System.out.println("\n--- Criação de Turma ---");
        System.out.print("Código da Turma: ");
        String codigo = scanner.nextLine();
        System.out.print("Registro do Professor: ");
        String regProfessor = scanner.nextLine();
        System.out.print("Código do Curso: ");
        String codCurso = scanner.nextLine();

        Professor professor = repositorio.buscarProfessorPorRegistro(regProfessor);
        Curso curso = repositorio.buscarCursoPorCodigo(codCurso);

        if (professor == null || curso == null) {
            System.out.println("Erro: Professor ou Curso não encontrados.");
            return;
        }

        Turma novaTurma = new Turma(codigo, professor, curso);
        servico.criarTurma(novaTurma);
    }

    private static void matricularAluno() {
        System.out.println("\n--- Matrícula de Aluno ---");
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        servico.matricularAlunoEmTurma(matricula, codigoTurma);
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, digite um número inteiro: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, digite um número decimal (ex: 7.5): ");
            }
        }
    }

    private static void menuRegistrarAvaliacao() {
        if (!(usuarioLogado instanceof Professor)) {
            System.out.println("Acesso negado. Apenas Professores podem registrar avaliações.");
            return;
        }
        
        System.out.println("\n--- Registro de Avaliação ---");
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();
        System.out.print("Descrição da Avaliação: ");
        String descricao = scanner.nextLine();
        System.out.print("Nota (0.0 a 10.0): ");
        
        try {
            double nota = lerDouble();
            servico.registrarAvaliacao(matricula, codigoTurma, descricao, nota);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para a nota.");
        }
    }
}
