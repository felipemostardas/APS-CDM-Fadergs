package com.aps_cdm_fadergs.aps_cdm_fadergs;

public class Produto {

    private int id;
    private String nome;
    private float valor;
    private int quantidade;

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

    public float getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}



