package com.senacfuc.vurna.objs;

public class Eleitor {
    private int inscricao;
    private String nome;

    /**
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param inscricao
     */
    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    }

    /**
     * @return Integer
     */
    public int getInscricao() {
        return inscricao;
    }
}
