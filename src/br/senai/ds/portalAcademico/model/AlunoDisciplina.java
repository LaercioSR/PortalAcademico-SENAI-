package br.senai.ds.portalAcademico.model;

public class AlunoDisciplina {
    private int idDisciplina;
    private int idAluno;

    
    public AlunoDisciplina(int idDisciplina, int idAluno) {
        this.idDisciplina = idDisciplina;
        this.idAluno = idAluno;
    }


    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
}
