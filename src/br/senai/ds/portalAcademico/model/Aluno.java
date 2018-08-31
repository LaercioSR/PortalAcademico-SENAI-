package br.senai.ds.portalAcademico.model;

public class Aluno {
    private int matricula;
    private String nome;
    private String telefone;

    
    public Aluno(int matricula, String nome, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
    }

    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
