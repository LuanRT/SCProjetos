package senac.uc1;

import java.util.*;
import senac.uc1.utils.*;
import senac.uc1.cliente.*;

public class Main {
    private static State estado_atual;
    private static ArrayList<Cliente> lista_de_clientes;
    private static Scanner sc;

    public static void main(String... args) {
        sc = new Scanner(System.in);
        lista_de_clientes = new ArrayList<Cliente>();

        // Seta o estado inicial do programa para menu principal
        setSistemaEstado(State.MENU_PRINCIPAL);

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
                    mostraStats();
                    break;
                case "EXIBINDO_DETALHES":
                    consultaClient();
                    break;
                case "MENU_PRINCIPAL":
                    mostraMenuPrincipal();
                    break;
                default:
                    throw new Error(Constants.ESTADO_INVALIDO);
            }
        }
    }

    // Mostra quantidade de clientes registrados
    private static void mostraStats() {
        System.out.println();
        System.out.println(Constants.ESTATISTICAS);
        System.out.println(Constants.CLIENTES_REGISTRADOS + lista_de_clientes.size());
        System.out.println();

        delay(1200);

        setSistemaEstado(State.MENU_PRINCIPAL);
    }

    private static void mostraMenuPrincipal() {
        System.out.println(Constants.MENU_PRINCIPAL);
        getNewState();
    }

    private static void cadastraClient() {
        System.out.println();
        System.out.println(Constants.CLIENT_REGISTRO);
        System.out.println(Constants.REGISTRO_PROGRESSO);
        System.out.println();

        String nome, endereco, numero, email, tipo;
        Cliente client = new Cliente();

        // Isso é necessario, consome as linhas extras
        sc.nextLine();

        System.out.println("Nome: ");
        nome = sc.nextLine();
        System.out.println();

        System.out.println("Endereço: ");
        endereco = sc.nextLine();
        System.out.println();

        System.out.println("Telefone: ");
        numero = sc.nextLine();
        System.out.println();

        System.out.println("E-mail: ");
        email = sc.nextLine();
        System.out.println();

        System.out.println(Constants.TIPO_DE_CLIENT_MSG);
        tipo = sc.nextLine();
        System.out.println();

        // Cria o objeto do cliente de acordo com seu tipo
        if (tipo.toLowerCase().equals("f")) {
            System.out.println("CPF: ");

            String cpf = sc.nextLine();

            PessoaFisica pessoa_fisica = new PessoaFisica();
            pessoa_fisica.setCpf(cpf);

            client = pessoa_fisica;
        } else if (tipo.toLowerCase().equals("j")) {
            System.out.println("CNPJ: ");

            String cnpj = sc.nextLine();

            PessoaJuridica pessoa_juridica = new PessoaJuridica();
            pessoa_juridica.setCnpj(cnpj);

            client = pessoa_juridica;
        } else {
            // Recomeca o processo caso o usuario selecione uma opcao invalida
            System.out.println(Constants.OP_INVALIDO_MSG);
            return;
        }

        // Seta as informacoes restantes & adiciona o cliente a lista
        client.setNome(nome);
        client.setEndereco(endereco);
        client.setTelefone(numero);
        client.setEmail(email);

        lista_de_clientes.add(client);

        System.out.println();
        System.out.println(Constants.REGISTRO_SUCESSO_MSG);
        System.out.println();

        delay(1200);

        setSistemaEstado(State.MENU_PRINCIPAL);
    }

    private static void consultaClient() {
        // Verifica se a lista tem pelo menos 1 cliente registrado
        if (lista_de_clientes.size() == 0) {
            System.out.println();
            System.out.println(Constants.CLIENTS_INDISPONIVEL);
            System.out.println();

            delay(1200);

            setSistemaEstado(State.MENU_PRINCIPAL);
            return;
        }

        // Se tiver então pede o usuario para escrever o email de algum cliente
        System.out.println();
        System.out.println(Constants.CONSULTA_CLIENTS);
        System.out.println();

        System.out.println(Constants.DIGITE_EMAIL_DO_CLIENTE_2);
        String email = sc.next();
        System.out.println();

        System.out.println(Constants.PROCURANDO_CLIENT);
        delay(1200);

        // Procura na lista algum cliente que tenha o email fornecido
        Cliente client = findClient(email);
        if (client != null) {
            System.out.println();
            System.out.println(Constants.CLIENT_ENCONTRADO);
            System.out.println(client.toString());
            System.out.println();
            delay(1200);
            setSistemaEstado(State.MENU_PRINCIPAL);
        } else {
            System.out.println(Constants.CLIENT_NAO_ENCONTRADO.replace("${email}", email));
            System.out.println();

            setSistemaEstado(State.MENU_PRINCIPAL);
        }
    }

    private static void removeClient() {
        // Verifica se a lista tem pelo menos 1 cliente registrado
        if (lista_de_clientes.size() == 0) {
            System.out.println();
            System.out.println(Constants.CLIENTS_INDISPONIVEL);
            System.out.println();

            delay(1200);

            setSistemaEstado(State.MENU_PRINCIPAL);
            return;
        }

        System.out.println();
        System.out.println(Constants.REMOVE_CLIENT);

        // Consome linha extra
        sc.nextLine();

        System.out.println(Constants.DIGITE_EMAIL_DO_CLIENTE_1);
        String email = sc.nextLine();
        System.out.println();

        System.out.println(Constants.REMOVENDO_CLIENT);
        delay(1200);

        // Procura na lista algum cliente que tenha o mesmo email
        Cliente client = findClient(email);
        if (client != null) {
            lista_de_clientes.remove(client);
            System.out.println(Constants.CLIENT_REMOVIDO);
            System.out.println();
            delay(1200);
            setSistemaEstado(State.MENU_PRINCIPAL);
        } else {
            System.out.println(Constants.CLIENT_NAO_ENCONTRADO.replace("${email}", email));
            System.out.println();

            setSistemaEstado(State.MENU_PRINCIPAL);
        }
    }

    private static void modificaClient() {
        // Verifica se a lista tem pelo menos 1 cliente registrado
        if (lista_de_clientes.size() == 0) {
            System.out.println();
            System.out.println(Constants.CLIENTS_INDISPONIVEL);
            System.out.println();

            delay(1200);

            setSistemaEstado(State.MENU_PRINCIPAL);
            return;
        }

        System.out.println();
        System.out.println(Constants.UPDATE_INFO);

        // Consome linha extra
        sc.nextLine();

        System.out.println(Constants.DIGITE_EMAIL_DO_CLIENTE_0);
        String email = sc.nextLine();
        System.out.println();

        System.out.println(Constants.PROCURANDO_CLIENT);
        delay(1200);

        // Procura na lista algum cliente que tenha o mesmo email
        Cliente client = findClient(email);
        if (client != null) {
            System.out.println();
            System.out.println(Constants.CLIENT_ENCONTRADO);
            System.out.println(client.toString());

            System.out.println();
            System.out.println(Constants.UPDATE_INFO_OPCOES);
            System.out.println();

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1: // Nome
                    sc.nextLine();

                    System.out.println("Novo nome:");
                    String nome = sc.nextLine();
                    System.out.println();

                    client.setNome(nome);

                    System.out.println(Constants.UPDATE_NOME_SUCESSO_MSG);
                    System.out.println();
                    break;
                case 2: // Endereco
                    sc.nextLine();

                    System.out.println("Novo endereço:");
                    String endereco = sc.nextLine();
                    System.out.println();

                    client.setEndereco(endereco);

                    System.out.println(Constants.UPDATE_ENDERECO_SUCESSO_MSG);
                    System.out.println();
                    break;
                case 3: // Telefone
                    sc.nextLine();

                    System.out.println("Novo telefone:");
                    String telefone = sc.nextLine();
                    System.out.println();

                    client.setTelefone(telefone);

                    System.out.println(Constants.UPDATE_TELEFONE_SUCESSO_MSG);
                    System.out.println();
                    break;
                case 4: // E-mail
                    sc.nextLine();

                    System.out.println("Novo e-mail:");
                    String new_email = sc.nextLine();
                    System.out.println();

                    client.setEmail(new_email);

                    System.out.println(Constants.UPDATE_EMAIL_SUCESSO_MSG);
                    System.out.println();
                    break;
                case 5: // CPF ou CNPJ
                    sc.nextLine();

                    System.out.println("Novo CPF/CNPJ:");
                    String doc = sc.nextLine();
                    System.out.println();

                    // Identifica o tipo de cliente e procede
                    if (client.toString().contains("CNPJ:")) {
                        PessoaJuridica pessoa_juridica = (PessoaJuridica) client;
                        pessoa_juridica.setCnpj(doc);
                    } else {
                        PessoaFisica pessoa_fisica = (PessoaFisica) client;
                        pessoa_fisica.setCpf(doc);
                    }

                    System.out.println(Constants.UPDATE_DOC_SUCESSO_MSG);
                    System.out.println();
                    break;
                default:
                    System.out.println(Constants.OP_INVALIDO_MSG);
                    System.out.println();
                    break;
            }

            delay(1200);
            setSistemaEstado(State.MENU_PRINCIPAL);
        } else {
            System.out.println(Constants.CLIENT_NAO_ENCONTRADO.replace("${email}", email));
            System.out.println();

            setSistemaEstado(State.MENU_PRINCIPAL);
        }
    }

    // Pega o novo estado do sistema apos interacao com o usuario
    private static void getNewState() {
        int estado_index = sc.nextInt();

        if (estado_index > 5) {
            /*
             * Somente opcoes abaixo ou iguais a posicao 5 sao validas para o usuario,
             * pois acima disso sao acoes internas do sistema
             */

            System.out.println();
            System.out.println(Constants.OPCAO_INVALIDA);
            estado_index = 7; // 7 é a posicao de “MENU_PRINCIPAL” no enum
        }

        delay(500);

        setSistemaEstado(State.get(estado_index));
    }

    // Verifica cada cliente da lista ate encontrar o que contenha o email dado
    private static Cliente findClient(String email) {
        for (Cliente client: lista_de_clientes) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

    // Para o sistema completamente
    private static void stopSystem() {
        System.out.println();
        System.out.println(Constants.GOODBYE);
        setSistemaEstado(State.PARADO);
    }

    // Seta o estado atual do sistema
    private static void setSistemaEstado(State state) {
        estado_atual = state;
    }

    // Faz a thread principal pausar por uma determinada quantidade de tempo (em milissegundos), isso ajuda a manter a aplicacao mais dinamica
    private static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }
}