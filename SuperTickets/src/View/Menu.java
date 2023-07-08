package View;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void show(){
        System.out.println("Bem vindo ao SuperTickets!");
        System.out.println("Já possui um cadastro? (s/n)");
        String opcao = scanner.nextLine();
        switch(opcao){
            case "s":
                this.login();
                break;
            case "n":
                this.cadastrar();
                break;
        }
    }

    public void login(){

    }

    public void cadastrarUsuario(){
        System.out.println("Preencha seus dados:");
        System.out.println("Nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
    }

    public void cadastrar(){
        System.out.println("Qual o seu objetivo com o SuperTickets?");
        System.out.println("Digite o valor correspondente: ");
        System.out.println("[1] Comprar Tickets para eventos\n[2] Organizar eventos");
        int opcao = scanner.nextInt();
        switch(opcao){
            case 1:
                this.cadastrarComprador();
                break;
            case 2:
                this.cadastrarOrganizador();
                break;
        }
    }

    public void cadastrarComprador(){
        this.cadastrarUsuario();
        System.out.println("cpf (apenas números): ");
        int cpf = scanner.nextInt();
    }

    public void cadastrarOrganizador(){
        this.cadastrarUsuario();
        System.out.println("cnpj (apenas números): ");
        int cpf = scanner.nextInt();
    }
}
