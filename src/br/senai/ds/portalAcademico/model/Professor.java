package br.senai.ds.portalAcademico.model;

public class Professor {
    private int matricula;
    private String nome;
    private String email;
    private String telefone;

    
    public Professor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Professor(){
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString(){
        return "Matrícula " + this.matricula + " | Nome: " + this.nome + " | Email: " + this.email + " | Telefone: " + this.telefone;
    }
}
