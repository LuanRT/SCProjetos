package com.senacfuc.vurna.objs;

public class Candidato {
    private int inscricao;
    private String nome, cod_cargo, cod_partido;


    /**
     * @return Integer
     */
    public int getInscricao() {
        return inscricao;
    }

    /**
     * @param inscricao
     */
    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    } 

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

    /**
     * @return String
     */
    public String getCodPartido() {
        return cod_partido;
    }

    /**
     * @param cod_partido
     */
    public void setCodPartido(String cod_partido) {
        this.cod_partido = cod_partido;
    }
}
