package senac.uc1.utils;

public enum State {
    // 0 sempre é parando
    PARANDO,

    // Acoes do front-end
    CADASTRANDO_CLIENT,
    REMOVENDO_CLIENT,
    MODIFICANDO_CLIENT,
    EXIBINDO_STATS,
    EXIBINDO_DETALHES,

    // Acoes internas
    ESPERANDO_INPUT,
    MENU_PRINCIPAL,
    PARADO;

    public static State get(int index) {
        return values()[index];
    }
}