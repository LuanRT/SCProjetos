package senac.uc1.utils;

public class Constants {
    public static final String
        // Menu principal & Outros:
        MAIN_MENU =
        "⚙️ -- Gerenciador De Clientes -- ⚙️" + "\n\n" +
        "O que gostaria de fazer hoje?\nDigite o número da opção desejada:" + "\n\n" +
        "1. Cadastrar cliente" + "\n" +
        "2. Remover cliente" + "\n" +
        "3. Atualizar dados de cliente" + "\n" +
        "4. Exibir estatísticas" + "\n" +
        "5. Consultar cliente" + "\n\n" +
        "Digite 0 para sair do programa.",

        INVALID_OPTION =
        "❌ Opção inválida! Escolha somente números\nque estejam presentes no menu:\n",

        GOODBYE =
        "👋 Até mais!", 

        // Mensagens de erro:
        INVALID_STATE =
        "[SYS-ERROR]: O sistema tentou acessar um estado não existente!",

        // Tela de registro de clientes: 
        CLIENT_REGISTRATION =
        "🗃️ Cadastro De Cliente 🗃️",

        REGISTRATION_PROGRESS =
        "Preencha os dados cadastrais de seu cliente:",

        CLIENT_TYPE_MSG =
        "Certo!\nAgora me diga em qual categoria esse cliente se encaixa:\npessoa fisica ou juridica (f/j)?",

        REGISTRATION_SUCCESS_MSG =
        "✅ Usuário cadastrado com sucesso!",

        INVALID_TYPE_MSG =
        "❌ Opção inválida",

        // Estatisticas & Detalhes de clientes
        STATISTICS =
        "📊 Estatísticas 📊",

        REGISTERED_CLIENTS =
        "Clientes cadastrados: ",

        CLIENT_DETAILS_TITLE =
        "📋 Consulta De Cliente 📋",

        CLIENTS_UNAVAILABLE =
        "Nenhum cliente registrado no sistema!",

        CLIENT_NOT_FOUND =
        "Não foi encontrado nenhum cliente com e-mail ${email}!",

        TYPE_CLIENT_EMAIL =
        "Digite o endereço de e-mail do cliente no qual deseja consultar\nE-mail:",

        SEARCHING_CLIENT =
        "🔍 Procurando...";
}