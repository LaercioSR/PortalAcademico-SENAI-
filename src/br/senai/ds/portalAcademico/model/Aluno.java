package br.senai.ds.portalAcademico.model;

public class Aluno {
    private int matricula;
    private String nome;
    private String telefone;



    public Aluno(String nome, String telefone) {
       this.nome = nome;
       this.telefone = telefone;
    }
    
    public Aluno(){
        
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
    
    @Override
    public String toString() {
	return "Matricula: " + this.matricula + " Nome: " + this.nome + " Telefone: " + this.telefone;
    }
}
