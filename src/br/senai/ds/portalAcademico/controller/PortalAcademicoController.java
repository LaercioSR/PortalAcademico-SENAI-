package br.senai.ds.portalAcademico.controller;

import br.senai.ds.portalAcademico.model.Aluno;
import br.senai.ds.portalAcademico.model.Professor;
import br.senai.ds.portalAcademico.model.Disciplina;
import br.senai.ds.portalAcademico.model.dao.AlunoDAO;
import br.senai.ds.portalAcademico.model.dao.ConexaoJDBC;
import java.sql.Connection;

public class PortalAcademicoController {
    private final ConexaoJDBC database = new ConexaoJDBC();
    private final Connection connection = database.conectar();
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private int matriculasAluno = 0;

    
    public PortalAcademicoController() {
        this.alunoDAO.setConnection(connection);
    }

    public void cadastrarAluno(String nome, String telefone) {
        Aluno aluno = new Aluno(++matriculasAluno, nome, telefone);
        alunoDAO.inserir(aluno);
    }
}