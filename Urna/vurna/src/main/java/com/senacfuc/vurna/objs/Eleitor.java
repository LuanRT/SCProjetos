package com.senacfuc.vurna.objs;

public class Eleitor {
    private int inscricao;
    private String nome;

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome O nome do eleitor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param inscricao O numero de inscricao do eleitor.
     */
    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    }

    /**
     * @return inscricao
     */
    public int getInscricao() {
        return inscricao;
    }
}
