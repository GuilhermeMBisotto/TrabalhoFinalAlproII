/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guilhermebisotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Guilherme Bisotto
 */
public class OrganizadorPalavras {
    ArrayList<Palavra> listaPalavras;
    
    public OrganizadorPalavras() {
        listaPalavras = new ArrayList<>();
    }
    
    public void addPalavra(String palavra, int numLinha) {
        int existepalavra = 0;
        
        for (Palavra listaPalavra : listaPalavras) {
            if (listaPalavra.getPalavra().equalsIgnoreCase(palavra)) {
                listaPalavra.addLinha(numLinha);
                existepalavra++;
            }
        }
        if(existepalavra == 0) {
            Palavra novaPalavra = new Palavra(palavra);
            novaPalavra.addLinha(numLinha);
            listaPalavras.add(novaPalavra);
        }
    }
    
    public ArrayList<Palavra> listaOrdenada(ArrayList<Palavra> listaOrdenada) {
        ordenaPorNome(listaOrdenada);
        return listaOrdenada;
    }
    
    private static void ordenaPorNome(ArrayList<Palavra> lista) {  
        Collections.sort(lista, new Comparator<Palavra>() {  
            @Override
            public int compare(Palavra o1, Palavra o2) {
                return o1.getPalavra().toUpperCase().compareTo(o2.getPalavra().toUpperCase());  
            }
     });  
    }  
    
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        
        for (Palavra listaPalavra : listaPalavras) {
            retorno.append(listaPalavra.getPalavra()).append(" ");
            for (int j = 0; j < listaPalavra.getNumerosLinhas().size(); j++) {
                retorno.append(listaPalavra.getNumerosLinhas().get(j)).append(" ");
            }
            retorno.append(" - ");
        }
        return retorno.toString();
    }
}
