package senac.uc1.utils;

public class Constants {
    public static final String
        // Menu principal & Outros:
        MENU_PRINCIPAL =
        "⚙️ -- Gerenciador De Clientes -- ⚙️" + "\n\n" +
        "O que gostaria de fazer hoje?\nDigite o número da opção desejada:" + "\n\n" +
        "1. Cadastrar cliente" + "\n" +
        "2. Remover cliente" + "\n" +
        "3. Atualizar dados de cliente" + "\n" +
        "4. Exibir estatísticas" + "\n" +
        "5. Consultar cliente" + "\n\n" +
        "Digite 0 para sair do programa.",

        OPCAO_INVALIDA =
        "❌ Opção inválida! Escolha somente números\nque estejam presentes no menu:\n",

        GOODBYE =
        "👋 Até mais!",

        // Mensagens de erro:
        ESTADO_INVALIDO =
        "[SYS-ERROR]: O sistema tentou acessar um estado não existente!",

        // Tela de registro de clientes: 
        CLIENT_REGISTRO =
        "🗃️ Cadastro De Cliente 🗃️",

        REGISTRO_PROGRESSO =
        "Preencha os dados cadastrais de seu cliente:",

        TIPO_DE_CLIENT_MSG =
        "Certo!\nAgora me diga em qual categoria esse cliente se encaixa:\npessoa fisica ou juridica (f/j)?",

        REGISTRO_SUCESSO_MSG =
        "✅ Usuário cadastrado com sucesso!",

        OP_INVALIDO_MSG =
        "❌ Opção inválida",

        // Tela de atualizacao de clientes:
        UPDATE_INFO =
        "📋 Atualizar Informações 📋",

        UPDATE_INFO_OPCOES =
        "Digite o número do campo no qual deseja atualizar:" + "\n" +
        "1. Nome" + "\n" +
        "2. Endereço" + "\n" +
        "3. Telefone" + "\n" +
        "4. E-mail" + "\n" +
        "5. CPF/CNPJ",

        DIGITE_EMAIL_DO_CLIENTE_0 =
        "Digite o endereço de e-mail do cliente no qual deseja atualizar\nE-mail:",

        UPDATE_NOME_SUCESSO_MSG =
        "✅ Nome atualizado com sucesso!",

        UPDATE_ENDERECO_SUCESSO_MSG =
        "✅ Endereço atualizado com sucesso!",

        UPDATE_TELEFONE_SUCESSO_MSG =
        "✅ Telefone atualizado com sucesso!",

        UPDATE_EMAIL_SUCESSO_MSG =
        "✅ Endereço de e-mail atualizado com sucesso!",

        UPDATE_DOC_SUCESSO_MSG =
        "✅ Documentos atualizados com sucesso!",

        // Tela de remocao de clientes:
        REMOVE_CLIENT =
        "🗄️ Descadastrar Cliente 🗄️",

        REMOVENDO_CLIENT =
        "Removendo cliente...",

        DIGITE_EMAIL_DO_CLIENTE_1 =
        "Digite o endereço de e-mail do cliente no qual deseja descadastrar\nE-mail:",

        CLIENT_REMOVIDO =
        "✅ Cliente removido do sistema com sucesso!",

        // Estatisticas & Detalhes de clientes:
        ESTATISTICAS =
        "📊 Estatísticas 📊",

        CLIENTES_REGISTRADOS =
        "Clientes cadastrados: ",

        CONSULTA_CLIENTS =
        "📋 Consulta De Cliente 📋",

        CLIENTS_INDISPONIVEL =
        "Nenhum cliente registrado no sistema!",

        CLIENT_NAO_ENCONTRADO =
        "Não foi encontrado nenhum cliente com e-mail ${email}!",

        CLIENT_ENCONTRADO =
        "Cliente encontrado:",

        DIGITE_EMAIL_DO_CLIENTE_2 =
        "Digite o endereço de e-mail do cliente no qual deseja consultar\nE-mail:",

        PROCURANDO_CLIENT =
        "🔍 Procurando...";
}