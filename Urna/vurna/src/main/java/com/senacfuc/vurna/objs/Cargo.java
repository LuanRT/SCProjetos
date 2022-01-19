package com.senacfuc.vurna.objs;

public class Cargo {
    private String cod_cargo, nome;

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
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome O nome do cargo. 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}