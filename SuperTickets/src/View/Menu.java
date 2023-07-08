package View;

import Controller.UsuarioController;
import Entity.Comprador;
import Entity.Organizador;
import Entity.Usuario;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UsuarioController controller = new UsuarioController();
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

    public int getIdUsuario(Usuario usuario){
        Usuario usuarioCriado = controller.getUsuarioByEmail(usuario.getEmail());
        return usuarioCriado.getId();
    }

    public int cadastrarUsuario(){
        System.out.println("Preencha seus dados:");

        System.out.println("Nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email, senha, 0);

        controller.cadastrarUsuario(usuario);

        //pega o id que foi cadastrado no banco
        return this.getIdUsuario(usuario);


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
        int id = this.cadastrarUsuario();

        System.out.println("cpf (apenas números): ");
        int cpf = scanner.nextInt();

        Comprador comprador = new Comprador(id, cpf);

        controller.cadastrarComprador(comprador);
    }

    public void cadastrarOrganizador(){
        int id = this.cadastrarUsuario();

        System.out.println("cnpj (apenas números): ");
        int cnpj = scanner.nextInt();

        Organizador organizador = new Organizador(id, cnpj);

        controller.cadastrarOrganizador(organizador);
    }
}
