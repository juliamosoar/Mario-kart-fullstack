package com.ifnmg.ds.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class API {
    private static final String FILE_NAME = "data/personagens_mario.csv";

    public static List<Personagem> listaPersonagem() throws FileNotFoundException {
        List<Personagem> myList = new ArrayList<>();
        File csvfile = new File(FILE_NAME);
        try (Scanner sc = new Scanner(csvfile)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                String nome = data[1];
                int velocidade = Integer.parseInt(data[2]);
                int manobrabilidade = Integer.parseInt(data[3]);
                int poder = Integer.parseInt(data[4]);
                String imagem = data[5];

                Personagem personagem = new Personagem(id, nome, velocidade, manobrabilidade, poder, imagem);
                myList.add(personagem);
            }
            return myList;
        }
    }

    private static int sorteio(int numero) {
        Random r = new Random();
        return r.nextInt(numero);
    }

    public static int sorteioPista(int n_pista) {
        return sorteio(n_pista);
    }

    public static Personagem sorteioPersonagem(List<Personagem> personagens) {
        return personagens.get(sorteio(personagens.size()));
    }

    public static int dado() {
        return sorteio(6) + 1;
    }

    public static Rodada entrada(int rodada, int pista, Personagem j1, Personagem j2, int dado1, int dado2)
            throws Exception {
        int ponto1 = dado1 + pv(pista, j1);
        int ponto2 = dado2 + pv(pista, j2);
        return new Rodada(rodada, pista, j1.getId(), j2.getId(), ponto1, ponto2);
    }

    private static int pv(int pista, Personagem idJogador) throws Exception {
        if (pista == 1)
            return idJogador.getVelocidade();
        else if (pista == 2)
            return idJogador.getPoder();
        else if (pista == 3)
            return idJogador.getManobrabilidade();
        else
            throw new Exception("Essa opção não esta disponível");
    }

    public static void score(Rodada rodada, List<Personagem> personagem){
        if(rodada.getPista() == 2){
            if(rodada.getPontuacao1() < rodada.getPontuacao2()){
                if(personagem.get(rodada.getIdJogador1()).getScore()> 0){
                    personagem.get(rodada.getIdJogador1()).setScore(personagem.get(rodada.getIdJogador1()).getScore()-1);
                }
            }
            if(rodada.getPontuacao2() < rodada.getPontuacao1()){
                if(personagem.get(rodada.getIdJogador2()).getScore()> 0){
                    personagem.get(rodada.getIdJogador2()).setScore(personagem.get(rodada.getIdJogador2()).getScore()-1);
                }
            }
        }
        else{
            if(rodada.getPontuacao1() < rodada.getPontuacao2()) {
                personagem.get(rodada.getIdJogador1()).setScore(personagem.get(rodada.getIdJogador1()).getScore()+1);
            }
            if(rodada.getPontuacao2() < rodada.getPontuacao1()){
              personagem.get(rodada.getIdJogador2()).setScore(personagem.get(rodada.getIdJogador2()).getScore()+1);
            }
        }  
    } 
}  
