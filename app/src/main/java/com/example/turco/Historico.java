package com.example.turco;

public class Historico {
    private String nome1;
    private String nome2;

    private int ponto1;
    private int ponto2;

    private String vencedor;

    private String data;

    public Historico(String nome1, String data, String vencedor, int ponto2, int ponto1, String nome2) {
        this.nome1 = nome1;
        this.data = data;
        this.vencedor = vencedor;
        this.ponto2 = ponto2;
        this.ponto1 = ponto1;
        this.nome2 = nome2;
    }

    public String getNome1() {
        return nome1;
    }

    public void setNome1(String nome1) {
        this.nome1 = nome1;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public int getPonto2() {
        return ponto2;
    }

    public void setPonto2(int ponto2) {
        this.ponto2 = ponto2;
    }

    public int getPonto1() {
        return ponto1;
    }

    public void setPonto1(int ponto1) {
        this.ponto1 = ponto1;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }
}
