package com.ifnmg.ds.backend;

public class Rodada {
    private final int idRodada;
    private final int pista;
    private final int idJogador1;
    private final int idJogador2;
    private final int pontuacao1;
    private final int pontuacao2;

    public Rodada(int idRodada,  int pista, int idJogador1, int idJogador2, int pontuacao1, int pontuacao2) {
        this.idJogador1 = idJogador1;
        this.idJogador2 = idJogador2;
        this.idRodada = idRodada;
        this.pista = pista;
        this.pontuacao1 = pontuacao1;
        this.pontuacao2 = pontuacao2;
    }

    public int getIdRodada() {
        return idRodada;
    }

    public int getPista() {
        return pista;
    }

    public int getIdJogador1() {
        return idJogador1;
    }

    public int getIdJogador2() {
        return idJogador2;
    }

    public int getPontuacao1() {
        return pontuacao1;
    }

    public int getPontuacao2() {
        return pontuacao2;
    }

    
}
