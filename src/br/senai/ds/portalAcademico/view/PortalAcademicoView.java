package br.senai.ds.portalAcademico.view;

import br.senai.ds.portalAcademico.controller.PortalAcademicoController;
import br.senai.ds.portalAcademico.util.Console;
import java.io.IOException;

public class PortalAcademicoView {
    static PortalAcademicoController controller;
    
    public static void menu() {
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
            System.out.println(" 3 - Alterar Dado de Aluno");
            System.out.println(" 4 - Listar Alunos");
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
                    alterarAluno();
                    break;
                case 4:
                    listarAlunos();
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

    private static void removerAluno() {
        
    }

    private static void alterarAluno() {
        
    }

    private static void listarAlunos() {
        
    }

    private static void menuProfessores() {
        
    }

    private static void menuDisciplinas() {
        
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
