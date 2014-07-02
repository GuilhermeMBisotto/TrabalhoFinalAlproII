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
public class OrganizadorPalavras {

    private class Node<T> {
		private T node;
		private Node<T> next;
		
		public Node(T ele) {
			this.node = ele;
			this.next = null;
		}

		public T getNode() {
			return node;
		}

		public void setNode(T node) {
			this.node = node;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> obj) {
			this.next =  obj;
		}	
	}
    
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
    
    public ArrayList<Palavra> listaOrdenada() {
        ArrayList<Palavra> listaOrdenada = new ArrayList<>();
        return listaOrdenada;
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
