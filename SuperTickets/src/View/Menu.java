package View;

import Controller.EventoController;
import Controller.LocalController;
import Controller.UsuarioController;
import Entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UsuarioController usuarioController = new UsuarioController();

    EventoController eventoController = new EventoController();

    LocalController localController = new LocalController();
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
        if(usuarioController.login(usuario)){
            usuario = usuarioController.getUsuarioByEmail(usuario.getEmail());
            System.out.println("Bem vindo(a) " + usuario.getNome() + "!\n");
            if(usuarioController.isComprador(usuario.getId())){
                this.menuComprador();
            }
            else if(usuarioController.isOrganizador(usuario.getId())){
                this.menuOrganizador();
            }
        }
        else{
            System.out.println("Login falhou!\n");
            this.show();
        }
    }


    public void menuComprador(){
        System.out.println("\t\t\t[MENU]");
        System.out.println("[1] Visualizar Eventos");
        System.out.println("[2] Visualizar Organizadores");
        System.out.println("[3] Sair");

        int opcao = scanner.nextInt();
        switch(opcao){
            case 1:
                //chamar funcao de exibir eventos
                break;
            case 2:
                this.exibirOrganizadores();
                break;
            case 3:
                System.exit(0);
                //termina o programa
                break;
        }
    }

    public void menuOrganizador(){
        System.out.println("\t\t\t[MENU]");
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
                this.cadastrarEvento();
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
        Usuario usuarioCriado = usuarioController.getUsuarioByEmail(usuario.getEmail());
        return usuarioCriado.getId();
    }

    public Evento adicionarLocalizacaoEvento(Evento evento){
        boolean sair = false;
        String endereco = "";

        while(!sair){
            System.out.println("Selecione uma opção para adicionar um local: ");
            System.out.println("[1] Exibir Locais");
            System.out.println("[2] Criar um local");
            int opcao = scanner.nextInt();
            if(opcao == 1){
                endereco = this.exibirLocaisParaEventos();
                if(!endereco.equals("")) sair = true;
            }
            else if(opcao == 2){
                this.cadastrarLocal();
            }
        }

        evento.setLocalEnd(endereco);
        return evento;
    }

    public String exibirLocaisParaEventos(){
        System.out.println("\t\t\t[Locais]");
        ArrayList<String> locais = localController.getAllLocaisEnderecos();
        for(int i=0; i<locais.size(); i++){
            System.out.println("[" + i + "]: " + locais.get(i));
        }

        if(locais.size()>0){
            int opcao = scanner.nextInt();
            return locais.get(opcao);
        }
        else{
            System.out.println("Não há locais cadastrados!");
            System.out.println("Por favor cadastre um local para continuar");
            return "";
        }



    }

    public void cadastrarLocal(){
        System.out.println("Preencha os dados do local");
        System.out.print("Endereço: ");
        scanner.nextLine();
        String endereco = scanner.nextLine();
        System.out.println();
        System.out.println("Descrição: ");
        String descricao = scanner.nextLine();

        Local local = new Local(endereco, descricao);

        if(localController.cadastrarLocal(local)){
            System.out.println("Local cadastrado com sucesso!");
        }
        else{
            System.out.println("Não foi possível concluir o cadastro!");
        }
    }

    public void cadastrarEvento(){
        System.out.println("Preencha os dados do evento");

        System.out.println("Nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Data do evento (dd/MM/yyyy): ");
        String dataString = scanner.nextLine();
        Date dataEvento = eventoController.stringToDate(dataString);

        System.out.println("Data de inscrição (dd/MM/yyyy): ");
        dataString = scanner.nextLine();
        Date dataInscricao = eventoController.stringToDate(dataString);

        System.out.println("Capacidade máxima do evento: ");
        int capacidade = scanner.nextInt();

        System.out.println("Email do organizador: ");
        scanner.nextLine();
        String email = scanner.nextLine();
        Usuario organizador = usuarioController.getUsuarioByEmail(email);
        int idOrganizador = organizador.getId();

        Evento evento = new Evento(nome, dataEvento, dataInscricao, capacidade, idOrganizador);

        this.adicionarLocalizacaoEvento(evento);

        if(eventoController.cadastrarEvento(evento)){
            System.out.println("Evento cadastrado com sucesso!");
        }
        else{
            System.out.println("Não foi possível cadastrar o evento!");
        }
        
        this.menuOrganizador();
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

        if(!usuarioController.cadastrarUsuario(usuario)){
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

        if(usuarioController.cadastrarComprador(comprador)){
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

        if(usuarioController.cadastrarOrganizador(organizador)){
            System.out.println("Usuário cadastrado com sucesso!");
        }
        else{
            System.out.println("Não foi possível concluir o cadastro.");
        }
    }

    public void exibirOrganizadores(){
        ArrayList<Organizador> organizadores = new ArrayList<Organizador>();
        organizadores = usuarioController.getAllOrganizadores();

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = usuarioController.organizadoresToUsuarios(organizadores);

        System.out.println("Caso queira visualizar um organizador, digite o número à esquerda do nome.");
        System.out.println("Organizadores:");
        for(int i = 0; i<usuarios.size(); i++){
            System.out.println("[" + i + "] " + usuarios.get(i).getNome());
        }

        System.out.println("[" + usuarios.size() + "] Sair");
        int opcao = scanner.nextInt();
        if(opcao == usuarios.size()){
            this.menuComprador();
        }
        else{
            usuarios.get(opcao).printUsuario();
        }
    }
}
