/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guilhermebisotto;

import java.util.ArrayList;

/**
 *
 * @author guilhermemorescobisotto
 */
public class GeradorHTML {
    
    private StringBuilder textoCompleto;
    private StringBuilder sumario;
    
    public GeradorHTML() {
        textoCompleto = new StringBuilder();
        sumario = new StringBuilder();
    }
    
    public void geraTextoCompleto(String linha, int numLinha) {
        textoCompleto.append("<div class=\"linha\"><a id=");
        textoCompleto.append("\"").append(numLinha).append("\"");
        textoCompleto.append(">").append(linha).append("</a></div>").append("\n");
    }
    
    public String getTextoCompleto() {
        return this.textoCompleto.toString();
    }
    
    public void geraSumario(ArrayList<Palavra> listaPalavras) {
        for(int i = 0; i < listaPalavras.size(); i++) {
            sumario.append(listaPalavras.get(i).getPalavra().charAt(0) + "\n");
            sumario.append(listaPalavras.get(i).getPalavra());
            for(int j = 0; j < listaPalavras.get(i).getNumerosLinhas().size(); j++) {
                sumario.append("<a href=\"#"+ listaPalavras.get(i).getNumerosLinhas().get(j) +"\">").append(listaPalavras.get(i).getNumerosLinhas().get(j) + "</a> ");
            }
            sumario.append("\n");
        }
    }
    
    public String getSumario() {
        return this.sumario.toString();
    }
    
}
