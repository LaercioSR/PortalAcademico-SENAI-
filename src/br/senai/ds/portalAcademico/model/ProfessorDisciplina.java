package br.senai.ds.portalAcademico.model;

public class ProfessorDisciplina {
    private int idDisciplina;
    private int idProfessor;

    
    public ProfessorDisciplina(int idDisciplina, int idProfessor) {
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
    }
    

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
