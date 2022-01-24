package com.senacfuc.vurna.objs;

public class Voto {
    private int inscricao_candidato, inscricao_eleitor;
    private String cod_cargo;

    /**
     * @return Integer
     */
    public int getInscricaoCandidato() {
        return inscricao_candidato;
    }

    /**
     * @param inscricao_candidato
     */
    public void setInscricaoCandidato(int inscricao_candidato) {
        this.inscricao_candidato = inscricao_candidato;
    }

    /**
     * @return Integer
     */
    public int getInscricaoEleitor() {
        return inscricao_eleitor;
    }

    /**
     * @param inscricao_eleitor
     */
    public void setInscricaoEleitor(int inscricao_eleitor) {
        this.inscricao_eleitor = inscricao_eleitor;
    }

    /**
     * @return String
     */
    public String getCodCargo() {
        return cod_cargo;
    }

    /**
     * @param cod_cargo
     */
    public void setCodCargo(String cod_cargo) {
        this.cod_cargo = cod_cargo;
    }
}
