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
        String opcao = "";
        while(!opcao.equals("q") && !opcao.equals("s")){
            System.out.println("Bem vindo ao SuperTickets!");
            System.out.println("Já possui um cadastro? (s/n)");
            System.out.println("Sair? (q)");
            opcao = scanner.nextLine();
            switch(opcao){
                case "s":
                    this.login();
                    break;
                case "n":
                    this.cadastrar();
                    break;
            }
        }
        System.out.println("Volte sempre!");
    }

    public void login(){
        System.out.println("Preencha seus dados: ");
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(email, senha);
        if(controller.login(usuario)){
            usuario = controller.getUsuarioByEmail(usuario.getEmail());
            System.out.println("Bem vindo(a) " + usuario.getNome() + "!");
            if(controller.isComprador(usuario.getId())){
                this.menuComprador();
            }
            else if(controller.isOrganizador(usuario.getId())){
                this.menuOrganizador();
            }
        }
        else{
            System.out.println("Usuário não cadastrado!");
        }
    }


    public void menuComprador(){
        System.out.println("[1] Visualizar Eventos");
        System.out.println("[2] Sair");

        int opcao = scanner.nextInt();
        switch(opcao){
            case 1:
                //chamar funcao de exibir eventos
                break;
            case 2:
                System.exit(0);
                //termina o programa
                break;
        }
    }

    public void menuOrganizador(){
        System.out.println("[1] Visualizar Eventos");
        System.out.println("[2] Cadastrar Evento");
        System.out.println("[3] Visualizar Eventos Cadastrados");
        System.out.println("[4] Sair");

        int opcao = scanner.nextInt();
        switch(opcao){
            case 1:
                //chamar funcao de exibir eventos
                break;
            case 2:
                //chama funcao de cadastrar evento
                break;
            case 3:
                //chama funçao de exibir eventos cadastrados pelo usuario
                break;
            case 4:
                System.exit(0);
                //termina o programa
                break;
        }
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

        Usuario usuario = new Usuario(nome, email, senha);

        if(!controller.cadastrarUsuario(usuario)){
            System.out.println("Não foi possível concluir o cadastro.");
            return -1;
        }

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

        if(id < 0) return;

        System.out.println("cpf: ");
        String cpf = scanner.nextLine();

        Comprador comprador = new Comprador(id, cpf);

        if(controller.cadastrarComprador(comprador)){
            System.out.println("Usuário cadastrado com sucesso!");
        }
        else{
            System.out.println("Não foi possível concluir o cadastro.");
        }
    }

    public void cadastrarOrganizador(){
        int id = this.cadastrarUsuario();

        if(id < 0) return;

        System.out.println("cnpj: ");
        String cnpj = scanner.nextLine();

        Organizador organizador = new Organizador(id, cnpj);

        if(controller.cadastrarOrganizador(organizador)){
            System.out.println("Usuário cadastrado com sucesso!");
        }
        else{
            System.out.println("Não foi possível concluir o cadastro.");
        }
    }
}
