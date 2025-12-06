package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGeral {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Curso> cursos;
    private List<Turma> turmas;
    private List<Administrador> administradores;

    public RepositorioGeral() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.administradores = new ArrayList<>();
        
        // Dados iniciais para teste
        Curso c1 = new CursoPresencial("Engenharia de Software", "ES001", 3600, "Sala B101");
        Curso c2 = new CursoEAD("Análise e Desenvolvimento de Sistemas", "ADS02", 2400, "Moodle");
        
        Professor p1 = new Professor("Dr. João Silva", "POO/Java", "P1001", "joao.silva", "123");
        Professor p2 = new Professor("Ms. Maria Oliveira", "Banco de Dados", "P1002", "maria.oliveira", "123");
        
        Aluno a1 = new Aluno("Carlos Souza", "A2023001", c1, "carlos.souza", "123");
        Aluno a2 = new Aluno("Ana Pereira", "A2023002", c1, "ana.pereira", "123");
        Aluno a3 = new Aluno("Pedro Lima", "A2023003", c2, "pedro.lima", "123");
        
        Administrador adm1 = new Administrador("Admin Geral", "Diretoria", "admin", "admin");

        cursos.add(c1);
        cursos.add(c2);
        professores.add(p1);
        professores.add(p2);
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        administradores.add(adm1);
        
        Turma t1 = new Turma("T001", p1, c1);
        t1.adicionarAluno(a1);
        t1.adicionarAluno(a2);
        turmas.add(t1);
    }

    // Métodos de acesso (Getters)
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    // Métodos de busca
    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                return a;
            }
        }
        return null;
    }
    
    public Professor buscarProfessorPorRegistro(String registro) {
        for (Professor p : professores) {
            if (p.getRegistro().equalsIgnoreCase(registro)) {
                return p;
            }
        }
        return null;
    }
    
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }
    
    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigo)) {
                return t;
            }
        }
        return null;
    }
    
    public Usuario buscarUsuarioPorLogin(String login) {
        for (Aluno a : alunos) {
            if (a.getLogin().equalsIgnoreCase(login)) return a;
        }
        for (Professor p : professores) {
            if (p.getLogin().equalsIgnoreCase(login)) return p;
        }
        for (Administrador adm : administradores) {
            if (adm.getLogin().equalsIgnoreCase(login)) return adm;
        }
        return null;
    }
}
