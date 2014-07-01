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
    
    public Palavra(String palavra, int numLinha) {
        this.palavra = palavra;
        this.numeroDasLinhas.add(numLinha);
    }
    
    public void addLinha(int numLinha) {
        int temIgual = 0;
        for(int i = 0; i < numeroDasLinhas.size(); i++) {
            if(numeroDasLinhas.get(i) == numLinha) {
                temIgual++;
            }
        }
        if(temIgual == 0) {
            this.addLinha(numLinha);
        }
    }
    
    public String getPalavra() {
        return this.palavra;
    }
    
    public ArrayList<Integer> getNumerosLinhas() {
        return this.numeroDasLinhas;
    }
}