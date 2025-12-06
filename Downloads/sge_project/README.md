# SGE - Sistema de Gerenciamento Educacional

**Instituição:** Unicesumar
**Aluno:** Daniel Wiverson Santos de Moura
**Curso:** ADS (Análise e Desenvolvimento de Sistemas)

## Descrição

Projeto acadêmico desenvolvido para a disciplina de programação / desenvolvimento na Unicesumar. É um sistema simples de gerenciamento educacional (SGE) com funcionalidades básicas para cadastro de usuários (alunos, professores, administradores), cursos, turmas e registro de avaliações.

## Estrutura do Projeto

- `src/` — código-fonte Java, organizado por pacotes:
  - `model/` — classes de domínio (Aluno, Professor, Curso, Turma, Usuario, etc.)
  - `repository/` — repositório em memória (`RepositorioGeral`)
  - `service/` — lógica de negócio (`ServicoAcademico`)
  - `ui/` — classe `Main` com interface de console
- `bin/` — saída da compilação (arquivos `.class`) (gerado após compilação)
- `.vscode/` — tarefas do VS Code (opcional)

## Requisitos

- Java JDK (11 ou superior recomendado)
- Git (para controle de versão)

## Como Compilar e Executar

No Windows (PowerShell), a partir da raiz do projeto execute:

```powershell
cd "c:\Users\55869\Downloads\sge_project\src"
javac -d ../bin model/*.java repository/*.java service/*.java ui/*.java
java -cp ../bin ui.Main
```

Alternativamente, você pode usar a tarefa do VS Code (já fornecida) pressionando `Ctrl+Shift+B` e escolhendo **Compilar e Executar**.

## Testes / Uso

O programa abre uma interface de console a partir de `ui.Main`. Siga as instruções apresentadas no terminal para cadastrar alunos, professores, cursos, criar turmas e registrar avaliações.

## Contribuição

Este é um projeto acadêmico. Para contribuições ou correções:

1. Faça um fork do repositório
2. Crie uma branch com sua feature (`git checkout -b feature/nome-da-feature`)
3. Faça commits atômicos e descritivos
4. Abra um Pull Request

## Observações

- Evite subir chaves ou segredos para o repositório (ex.: API Keys). Caso tenha subido algo acidentalmente, remova do histórico e regenere as credenciais.

## Autor

Daniel Wiverson Santos de Moura — Aluno Unicesumar (ADS)

---

