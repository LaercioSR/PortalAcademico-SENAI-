package br.senai.ds.portalAcademico.controller;

import br.senai.ds.portalAcademico.model.Aluno;
import br.senai.ds.portalAcademico.model.Professor;
import br.senai.ds.portalAcademico.model.Disciplina;
import br.senai.ds.portalAcademico.model.dao.AlunoDAO;
import br.senai.ds.portalAcademico.model.dao.AlunoDisciplinaDAO;
import br.senai.ds.portalAcademico.model.dao.ConexaoJDBC;
import br.senai.ds.portalAcademico.model.dao.DisciplinaDAO;
import br.senai.ds.portalAcademico.model.dao.ProfessorDAO;
import br.senai.ds.portalAcademico.model.dao.ProfessorDisciplinaDAO;
import java.sql.Connection;
import java.util.List;

public class PortalAcademicoController {
    private final ConexaoJDBC database = new ConexaoJDBC();
    private final Connection connection = database.conectar();
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    private final DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    private final AlunoDisciplinaDAO alunoDisciplinaDAO = new AlunoDisciplinaDAO();
    private final ProfessorDisciplinaDAO professorDisciplinaDAO = new ProfessorDisciplinaDAO();

    
    public PortalAcademicoController() {
        
    }

    public void cadastrarAluno(String nome, String telefone) {
        Aluno aluno = new Aluno(nome, telefone);
        alunoDAO.inserir(aluno);
    }
    
    public void removerAluno(int matricula) {
        alunoDAO.remover(matricula);
    }
    
    public List<Aluno> listarAlunos(){
        return alunoDAO.listar();
    }

    public Aluno obterAlunoPorCodigo(int matricula) {
        return alunoDAO.obterAlunoPorMatricula(matricula);
    }

    public Aluno obterAlunoPorNome(String nome) {
        return alunoDAO.obterAlunoPorNome(nome);
    }
    
    public void cadastrarProfessor(String nome, String telefone, String email){
        Professor professor = new Professor(nome, email, telefone);
        professorDAO.inserir(professor);
    }
    
    public void removerProfessor(int matricula) {
        professorDAO.remover(matricula);
    }
    
    public List<Professor> listarProfessor(){
        return professorDAO.listar();
    }

    public Professor obterProfessorPorCodigo(int matricula) {
        return professorDAO.obterPorMatricula(matricula);
    }

    public Professor obterProfessorPorNome(String nome) {
        return professorDAO.obterPorNome(nome);
    }

    
    public void cadastrarDisciplina(String nome, int cargaHoraria){
        Disciplina disciplina = new Disciplina(nome, cargaHoraria);
        disciplinaDAO.inserir(disciplina);
    }
    
    public void removerDisciplina(int codigo) {
        disciplinaDAO.remover(codigo);
    }
    
    public List<Disciplina> listarDisciplina(){
        return disciplinaDAO.listar();
    }

    public Disciplina obterDisciplinaPorCodigo(int codigo) {
        return disciplinaDAO.obterPorMatricula(codigo);
    }

    public Disciplina obterDisciplinaPorNome(String nome) {
        return disciplinaDAO.obterPorNome(nome);
    }

    public List<Disciplina> obterDisciplinasAluno(int matricula) {
        return alunoDisciplinaDAO.buscarDisciplinasAluno(matricula);
    }

    public void cadastrarAlunoDisciplina(int matricula, int idDisciplina) {
        alunoDisciplinaDAO.iserir(matricula, idDisciplina);
    }

    public List<Disciplina> obterDisciplinasProfessor(int matricula) {
        return professorDisciplinaDAO.buscarDisciplinasProfessor(matricula);
    }

    public void cadastrarProfessorDisciplina(int matricula, int idDisciplina) {
        professorDisciplinaDAO.iserir(matricula, idDisciplina);
    }

    public Professor obterProfessorDisciplina(int codigo) {
        return professorDisciplinaDAO.buscarProfessorDisciplina(codigo);
    }

    public List<Aluno> obterAlunosDisciplina(int codigo) {
        return alunoDisciplinaDAO.buscarAlunosDisciplina(codigo);
    }
}