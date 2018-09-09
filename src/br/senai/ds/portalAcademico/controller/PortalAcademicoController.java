package br.senai.ds.portalAcademico.controller;

import br.senai.ds.portalAcademico.model.Aluno;
import br.senai.ds.portalAcademico.model.Professor;
import br.senai.ds.portalAcademico.model.Disciplina;
import br.senai.ds.portalAcademico.model.dao.AlunoDAO;
import br.senai.ds.portalAcademico.model.dao.ConexaoJDBC;
import br.senai.ds.portalAcademico.model.dao.ProfessorDAO;
import br.senai.ds.portalAcademico.util.Console;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PortalAcademicoController {
    private final ConexaoJDBC database = new ConexaoJDBC();
    private final Connection connection = database.conectar();
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    
    public PortalAcademicoController() {
        this.alunoDAO.setConnection(connection);
        this.professorDAO.setConnection(connection);
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

}