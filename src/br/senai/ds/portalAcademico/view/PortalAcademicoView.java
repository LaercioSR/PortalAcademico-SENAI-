package br.senai.ds.portalAcademico.view;

import br.senai.ds.portalAcademico.controller.PortalAcademicoController;
import br.senai.ds.portalAcademico.util.Console;
import java.io.IOException;

public class PortalAcademicoView {
    static PortalAcademicoController controller;
    
    private static void menu() {
        System.out.println();
        System.out.println("\t======================================");
        System.out.println("\t||         Portal Acadêmico         ||");
        System.out.println("\t======================================");
        System.out.println("");
        
        System.out.println("  DIGITE A OPÇÃO DESEJADA:");
        System.out.println(" ");
        System.out.println(" 1 - Gerenciar Alunos");
        System.out.println(" 2 - Gerenciar Professores");
        System.out.println(" 3 - Gerenciar Disciplina");
        System.out.println(" 4 - Sair do Programa");
        System.out.print(">>>>>>   ");
    }

    private static void menuAlunos() throws IOException {
        int opcao;
        
        do {
            System.out.println("\n  DIGITE A OPÇÃO DESEJADA:");
            System.out.println(" 1 - Cadastrar Aluno");
            System.out.println(" 2 - Remover Aluno");
            System.out.println(" 3 - Listar ou Buscar Aluno(s)");
            System.out.println(" 4 - Cadastrar Aluno em Disciplina");
            System.out.println(" 5 - Voltar");
            System.out.print(">>>>>>   ");
            opcao = Console.readInt();
            
            switch(opcao){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    removerAluno();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    cadastrarAlunoDisciplina();
                    break;
                case 5:
                    break;
                default:
                    System.out.println();
                    System.out.println("Valor Digitado Invalido");
            }
        } while(opcao < 1 || opcao > 5);
    }

    private static void cadastrarAluno() throws IOException {
        String nome;
        String telefone;
        
        System.out.println("\n\n  Cadastrar Aluno");
        System.out.print("   Digite o nome do aluno: ");
        nome = Console.readString();
        System.out.print("   Digite o telefone do aluno: ");
        telefone = Console.readString();
        
        controller.cadastrarAluno(nome, telefone);
    }

    private static void removerAluno() throws IOException {
        int matricula;
        
        System.out.println("\n\n  Remover Aluno");
        System.out.print("   Digite a matricula do aluno: ");
        matricula = Console.readInt();
        
        controller.removerAluno(matricula);
    }

    private static void listarAlunos() throws IOException {
        int opcao;
        
        do {
            System.out.println("\n  DIGITE A OPÇÃO DESEJADA:");
            System.out.println(" 1 - Listar todos alunos");
            System.out.println(" 2 - Buscar aluno pela matrícula");
            System.out.println(" 3 - Buscar aluno por nome");
            System.out.println(" 4 - Listar disciplinas de um aluno");
            System.out.println(" 5 - Voltar");
            System.out.print(">>>>>>   ");
            opcao = Console.readInt();
            
            switch(opcao){
                case 1:
                    System.out.println(controller.listarAlunos());
                    break;
                case 2:
                    int matricula;
                    System.out.print("Digite a matrícula que deseja buscar: ");
                    matricula = Console.readInt();
                    System.out.println(controller.obterAlunoPorCodigo(matricula));
                    break;
                case 3:
                    String nome;
                    System.out.print("Digite o nome que deseja buscar: ");
                    nome = Console.readString();
                    System.out.println(controller.obterAlunoPorNome(nome));
                    
                    break;
                case 4:
                    System.out.print("Digite a matrícula do aluno: ");
                    matricula = Console.readInt();
                    System.out.println(controller.obterDisciplinasAluno(matricula));
                    break;
                case 5:
                    menuAlunos();
                    break;
                default:
                    System.out.println();
                    System.out.println("Valor Digitado Invalido");
            }
        } while(opcao < 1 || opcao > 5);
        
    }
    
    private static void cadastrarAlunoDisciplina() throws IOException {
        int matricula;
        int idDisciplina;
        
        System.out.println("\n\n  Cadastrar Aluno em Disciplina");
        System.out.print("   Digite a matrícula do aluno: ");
        matricula = Console.readInt();
        System.out.print("   Digite o código da disciplina: ");
        idDisciplina = Console.readInt();
        
        controller.cadastrarAlunoDisciplina(matricula, idDisciplina);
    }

    private static void menuProfessores() throws IOException {
        int opcao;
        
        do {
            System.out.println("\n  DIGITE A OPÇÃO DESEJADA:");
            System.out.println(" 1 - Cadastrar Professor");
            System.out.println(" 2 - Remover Professor");
            System.out.println(" 3 - Listar ou Buscar Professor(es)");
            System.out.println(" 4 - Cadastrar Professor em Disciplina");
            System.out.println(" 5 - Voltar");
            System.out.print(">>>>>>   ");
            opcao = Console.readInt();
            
            switch(opcao){
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    removerProfessor();
                    break;
                case 3:
                    listarProfessores();
                    break;
                case 4:
                    cadastrarProfessorDisciplina();
                    break;
                case 5:
                    break;
                default:
                    System.out.println();
                    System.out.println("Valor Digitado Invalido");
            }
        } while(opcao < 1 || opcao > 5);
    }
    
    private static void cadastrarProfessor() throws IOException {
        String nome;
        String telefone;
        String email;
        
        System.out.println("\n\n  Cadastrar Professor");
        System.out.print("   Digite o nome do professor: ");
        nome = Console.readString();
        System.out.print("   Digite o telefone do professor: ");
        telefone = Console.readString();
        System.out.print("   Digite o email do professor: ");
        email = Console.readString();
        
        controller.cadastrarProfessor(nome, telefone, email);
    }

    private static void removerProfessor() throws IOException {
        int matricula;
        
        System.out.println("\n\n  Remover Professor");
        System.out.print("   Digite a matricula do professor: ");
        matricula = Console.readInt();
        
        controller.removerProfessor(matricula);
    }


    private static void listarProfessores() throws IOException {
        int opcao;
        
        do {
            System.out.println("\n  DIGITE A OPÇÃO DESEJADA:");
            System.out.println(" 1 - Listar todos professores");
            System.out.println(" 2 - Buscar professor pela matrícula");
            System.out.println(" 3 - Buscar professor por nome");
            System.out.println(" 4 - Listar disciplinas de um professor");
            System.out.println(" 5 - Voltar");
            System.out.print(">>>>>>   ");
            opcao = Console.readInt();
            
            switch(opcao){
                case 1:
                    System.out.println(controller.listarProfessor());
                    break;
                case 2:
                    int matricula;
                    System.out.print("Digite a matricula que deseja buscar: ");
                    matricula = Console.readInt();
                    System.out.println(controller.obterProfessorPorCodigo(matricula));
                    break;
                case 3:
                    String nome;
                    System.out.print("Digite o nome que deseja buscar: ");
                    nome = Console.readString();
                    System.out.println(controller.obterProfessorPorNome(nome));
                    break;
                case 4:
                    System.out.print("Digite a matrícula do professor: ");
                    matricula = Console.readInt();
                    System.out.println(controller.obterDisciplinasProfessor(matricula));
                    break;
                case 5:
                    listarProfessores();
                    break;
                default:
                    System.out.println();
                    System.out.println("Valor Digitado Invalido");
            }
        } while(opcao < 1 || opcao > 5);
        
    }
    
    private static void cadastrarProfessorDisciplina() throws IOException {
        int matricula;
        int idDisciplina;
        
        System.out.println("\n\n  Cadastrar Professor em Disciplina");
        System.out.print("   Digite a matrícula do professor: ");
        matricula = Console.readInt();
        System.out.print("   Digite o código da disciplina: ");
        idDisciplina = Console.readInt();
        
        controller.cadastrarProfessorDisciplina(matricula, idDisciplina);
    }
    
    private static void menuDisciplinas() throws IOException {
        int opcao;
        
        do {
            System.out.println("\n  DIGITE A OPÇÃO DESEJADA:");
            System.out.println(" 1 - Cadastrar Disciplina");
            System.out.println(" 2 - Remover Disciplina");
            System.out.println(" 3 - Listar ou Buscar Disciplina(s)");
            System.out.println(" 4 - Voltar");
            System.out.print(">>>>>>   ");
            opcao = Console.readInt();
            
            switch(opcao){
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    removerDisciplina();
                    break;
                case 3:
                    listarDisciplinas();
                    break;
                case 4:
                    break;
                default:
                    System.out.println();
                    System.out.println("Valor Digitado Invalido");
            }
        } while(opcao < 1 || opcao > 4);
    }
    
    private static void cadastrarDisciplina() throws IOException {
        String nome;
        int cargaHoraria;
        
        System.out.println("\n\n  Cadastrar Disciplina");
        System.out.print("   Digite o nome da disciplina: ");
        nome = Console.readString();
        System.out.print("   Digite a carga horária da disciplina: ");
        cargaHoraria = Console.readInt();
        
        controller.cadastrarDisciplina(nome, cargaHoraria);
    }

    private static void removerDisciplina() throws IOException {
        int codigo;
        
        System.out.println("\n\n  Remover Disciplina");
        System.out.print("   Digite o código da disciplina: ");
        codigo = Console.readInt();
        
        controller.removerDisciplina(codigo);
    }


    private static void listarDisciplinas() throws IOException {
        int opcao;
        
        do {
            System.out.println("\n  DIGITE A OPÇÃO DESEJADA:");
            System.out.println(" 1 - Listar todos disciplinas");
            System.out.println(" 2 - Buscar disciplina pela matrícula");
            System.out.println(" 3 - Buscar disciplina por nome");
            System.out.println(" 4 - Buscar professor de uma disciplina");
            System.out.println(" 5 - Listar alunos de uma disciplina");
            System.out.println(" 6 - Voltar");
            System.out.print(">>>>>>   ");
            opcao = Console.readInt();
            
            switch(opcao){
                case 1:
                    System.out.println(controller.listarDisciplina());
                    break;
                case 2:
                    int codigo;
                    System.out.print("Digite o código que deseja buscar: ");
                    codigo = Console.readInt();
                    System.out.println(controller.obterDisciplinaPorCodigo(codigo));
                    break;
                case 3:
                    String nome;
                    System.out.print("Digite o nome que deseja buscar: ");
                    nome = Console.readString();
                    System.out.println(controller.obterDisciplinaPorNome(nome));
                    break;
                case 4:
                    System.out.print("Digite o código da disciplina: ");
                    codigo = Console.readInt();
                    System.out.println(controller.obterProfessorDisciplina(codigo));
                    break;
                case 5:
                    System.out.print("Digite o código da disciplina: ");
                    codigo = Console.readInt();
                    System.out.println(controller.obterAlunosDisciplina(codigo));
                    break;
                case 6:
                    listarDisciplinas();
                    break;
                default:
                    System.out.println();
                    System.out.println("Valor Digitado Invalido");
            }
        } while(opcao < 1 || opcao > 6);
        
    }
    
    public static void main(String[] args) throws IOException {
        int opcaoMenu;
        controller = new PortalAcademicoController();
        
        do {
            menu();
            opcaoMenu = Console.readInt();
            System.out.println("");
            
            switch(opcaoMenu){
                case 1:
                    System.out.println(" MENU de ALUNOS:");
                    menuAlunos();
                    break;
                case 2:
                    System.out.println(" MENU de PROFESSORES:");
                    menuProfessores();
                    break;
                case 3:
                    System.out.println(" MENU de DISCIPLINAS:");
                    menuDisciplinas();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Valor Digitado Inválido");
                    System.out.println();
            }
            
        } while(opcaoMenu != 4);
    }
}
