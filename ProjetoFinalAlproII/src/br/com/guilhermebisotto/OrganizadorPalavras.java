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
    
    public void addPalavra(String palavra, int numLinha) {
        int existepalavra = 0;
        
        for(int i = 0; i < listaPalavras.size(); i++) {
            if(listaPalavras.get(i).getPalavra().equalsIgnoreCase(palavra)) {
                listaPalavras.get(i).addLinha(numLinha);
                existepalavra++;
            }
        }
        if(existepalavra == 0) {
            Palavra novaPalavra = new Palavra(palavra, numLinha);
            listaPalavras.add(novaPalavra);
        }
    }
    
    public ArrayList<Palavra> listaOrdenada() {
        ArrayList<Palavra> listaOrdenada = new ArrayList<>();
        return listaOrdenada;
    }
}
