package com.senacfuc.vurna.objs;

public class Candidato {
    private int inscricao;
    private String nome, cod_cargo, cod_partido;


    /**
     * @return inscricao
     */
    public int getInscricao() {
        return inscricao;
    }

    /**
     * @param inscricao Numero de inscricao do candidato.
     */
    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    } 

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome do candidato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return cod_cargo
     */
    public String getCodCargo() {
        return cod_cargo;
    }

    /**
     * @param cod_cargo O codigo do cargo.
     */
    public void setCodCargo(String cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    /**
     * @return cod_partido
     */
    public String getCodPartido() {
        return cod_partido;
    }

    /**
     * @param cod_partido O codigo do partido.
     */
    public void setCodPartido(String cod_partido) {
        this.cod_partido = cod_partido;
    }
}
