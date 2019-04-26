package com.aps_cdm_fadergs.aps_cdm_fadergs;

public class Produto {

    private int id;
    private String nome;
    private String valor;

    @Override
    public String toString() {
        return this.nome + "\n" + this.nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor){
        this.valor = valor;
    }


    public int getQuantidade() {
        return 0;
    }
}



