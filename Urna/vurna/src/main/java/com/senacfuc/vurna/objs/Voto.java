package com.senacfuc.vurna.objs;

public class Voto {
    private int inscricao_candidato, inscricao_eleitor;

    /**
     * @return inscricao_candidato
     */
    public int getInscricaCandidato() {
        return inscricao_candidato;
    }

    /**
     * @param inscricao_candidato O numero de inscricao do candidato.
     */
    public void setInscricaoCandidato(int inscricao_candidato) {
        this.inscricao_candidato = inscricao_candidato;
    }

    /**
     * @return inscricao_eleitor
     */
    public int getInscricaoEleitor() {
        return inscricao_eleitor;
    }

    /**
     * @param inscricao_eleitor O numero de inscricao do eleitor.
     */
    public void setInscricaoEleitor(int inscricao_eleitor) {
        this.inscricao_eleitor = inscricao_eleitor;
    }
}
