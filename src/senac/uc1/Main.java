package senac.uc1;

import java.util.*;
import senac.uc1.cliente.*;
import senac.uc1.utils.*;

public class Main {
    private static int estado_index = 0;
    private static State estado_atual;
    private static ArrayList < Cliente > lista_de_clientes;
    private static Scanner sc;

    public static void main(String...args) {
        sc = new Scanner(System.in);
        lista_de_clientes = new ArrayList < Cliente > ();

        // Seta o estado inicial do programa para menu principal
        setSystemState(State.MENU_PRINCIPAL);

        // Inicializa o loop principal do programa
        init();
    }

    private static void init() {
        /* 
         * Executa as acoes do sistema de acordo com
         * o estado atual do programa
         */
        while (estado_atual != State.PARADO) {
            switch (estado_atual.toString()) {
                case "PARANDO":
                    stopSystem();
                    break;
                case "CADASTRANDO_CLIENT":
                    cadastraClient();
                    break;
                case "REMOVENDO_CLIENT":
                    removeClient();
                    break;
                case "MODIFICANDO_CLIENT":
                    modificaClient();
                    break;
                case "EXIBINDO_STATS":
                    showStats();
                    break;
                case "EXIBINDO_DETALHES":
                    showClientDetails();
                    break;
                case "MENU_PRINCIPAL":
                    showMainMenu();
                    break;
                default:
                    throw new Error(Constants.INVALID_STATE);
            }
        }
    }

    private static void showStats() {
        System.out.println();
        System.out.println(Constants.STATISTICS);
        System.out.println(Constants.REGISTERED_CLIENTS + lista_de_clientes.size());
        System.out.println();

        delay(1200);

        setSystemState(State.MENU_PRINCIPAL);
    }

    private static void showClientDetails() {
        // Verifica se a lista tem pelo menos 1 cliente registrado
        if (lista_de_clientes.size() == 0) {
            System.out.println();
            System.out.println(Constants.CLIENTS_UNAVAILABLE);
            System.out.println();
            delay(1200);
            setSystemState(State.MENU_PRINCIPAL);
            return;
        }

        // Se tiver então pede o usuario para escrever o email de algum cliente
        System.out.println();
        System.out.println(Constants.CLIENT_DETAILS_TITLE);
        System.out.println();

        System.out.println(Constants.TYPE_CLIENT_EMAIL);
        String email = sc.next();
        System.out.println();

        System.out.println(Constants.SEARCHING_CLIENT);
        delay(1200);

        // Verifica cada cliente da lista ate encontrar o certo
        for (Cliente client: lista_de_clientes) {
            if (client.getEmail().equals(email)) {
                System.out.println();
                System.out.println(client.toString());
                System.out.println();
                delay(1200);
                setSystemState(State.MENU_PRINCIPAL);
                return;
            }
        }

        // Caso não seja encontrado nada entao avisa o usuario e volta ao menu principal
        System.out.println(Constants.CLIENT_NOT_FOUND.replace("${email}", email));
        System.out.println();

        setSystemState(State.MENU_PRINCIPAL);
    }

    private static void cadastraClient() {
        System.out.println();
        System.out.println(Constants.CLIENT_REGISTRATION);
        System.out.println(Constants.REGISTRATION_PROGRESS);
        System.out.println();

        String name, address, phone_number, email, client_type;
        Cliente client = new Cliente();

        // Isso é necessario, consome as linhas extras
        sc.nextLine();

        System.out.println("Nome: ");
        name = sc.nextLine();
        System.out.println();

        System.out.println("Endereço: ");
        address = sc.nextLine();
        System.out.println();

        System.out.println("Telefone: ");
        phone_number = sc.nextLine();
        System.out.println();

        System.out.println("E-mail: ");
        email = sc.nextLine();
        System.out.println();

        System.out.println(Constants.CLIENT_TYPE_MSG);
        client_type = sc.nextLine();
        System.out.println();

        // Cria o objeto do cliente de acordo com seu tipo
        if (client_type.toLowerCase().equals("f")) {
            System.out.println("CPF: ");

            String cpf = sc.nextLine();

            PessoaFisica pessoa_fisica = new PessoaFisica();
            pessoa_fisica.setCpf(cpf);

            client = pessoa_fisica;
        } else if (client_type.toLowerCase().equals("j")) {
            System.out.println("CNPJ: ");

            String cnpj = sc.nextLine();

            PessoaJuridica pessoa_juridica = new PessoaJuridica();
            pessoa_juridica.setCnpj(cnpj);

            client = pessoa_juridica;
        } else {
            // Recomeca o processo caso o usuario selecione uma opcao invalida
            System.out.println(Constants.INVALID_TYPE_MSG);
            return;
        }

        // Seta as informacoes restantes & adiciona o cliente a lista
        client.setNome(name);
        client.setEndereco(address);
        client.setTelefone(phone_number);
        client.setEmail(email);

        lista_de_clientes.add(client);

        System.out.println();
        System.out.println(Constants.REGISTRATION_SUCCESS_MSG);
        System.out.println();

        delay(1200);

        setSystemState(State.MENU_PRINCIPAL);
    }

    private static void removeClient() { /* TODO: Implementar isso */ }
    private static void modificaClient() { /* TODO: Implementar isso */ }

    // Para o sistema completamente
    private static void stopSystem() {
        System.out.println();
        System.out.println(Constants.GOODBYE);
        setSystemState(State.PARADO);
    }

    // Printa o menu principal e pede um novo estado para o sistema
    private static void showMainMenu() {
        System.out.println(Constants.MAIN_MENU);
        getNewState();
    }

    // Pega o novo estado do sistema apos interacao com o usuario
    private static void getNewState() {
        estado_index = sc.nextInt();

        if (estado_index > 5) {
            /*
             * Somente opcoes abaixo ou iguais a posicao 5 sao validas para o usuario,
             * pois acima disso sao acoes internas do sistema
             */

            System.out.println();
            System.out.println(Constants.INVALID_OPTION);
            estado_index = 7; // 7 é a posicao de “MENU_PRINCIPAL” no enum
        }

        delay(500);

        setSystemState(State.get(estado_index));
    }

    // Seta o estado atual do sistema
    private static void setSystemState(State state) {
        estado_atual = state;
    }

    // Faz a thread principal pausar por uma determinada quantidade de tempo, isso ajuda a manter a aplicacao mais dinamica
    private static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }
}