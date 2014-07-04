/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilhermebisotto;

import java.util.ArrayList;

/**
 *
 * @author Guilherme Bisotto
 */
public class Palavra {

    ArrayList<Integer> numeroDasLinhas;
    String palavra;
    char inicial;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.numeroDasLinhas = new ArrayList<>();
        this.inicial = palavra.toUpperCase().charAt(0);
        //this.addLinha(numLinha);
    }

    public void addLinha(int numLinha) {
        int temIgual = 0;

        for (Integer numeroDasLinha : numeroDasLinhas) {
            if (numeroDasLinha == numLinha) {
                temIgual++;
            }
        }
        if (temIgual == 0) {
            this.numeroDasLinhas.add(numLinha);
        }
    }

    public String getPalavra() {
        return this.palavra;
    }
    
    public char getInicial() {
        return this.inicial;
    }

    public ArrayList<Integer> getNumerosLinhas() {
        return this.numeroDasLinhas;
    }
}
