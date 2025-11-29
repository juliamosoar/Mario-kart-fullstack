package com.ifnmg.ds.backend;

public class Personagem {
    private final int id;
    private final String nome;
    private final int velocidade;
    private final int manobrabilidade;
    private final int poder;
    private final String imagem;

    public Personagem(int id, String nome, int velocidade, int manobrabilidade, int poder, String imagem) {
        this.id = id;
        this.nome = nome;
        this.velocidade = velocidade;
        this.manobrabilidade = manobrabilidade;
        this.poder = poder;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getManobrabilidade() {
        return manobrabilidade;
    }

    public int getPoder() {
        return poder;
    }

    public String getImagem() {
        return imagem;
    }   
}
