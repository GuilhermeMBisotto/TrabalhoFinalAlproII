/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guilhermebisotto;

import java.util.Scanner;

/**
 *
 * @author Guilherme Bisotto
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Portanto, a primeira tarefa é a modelagem de um conjunto de classes capaz de armazenar as palavras 
        com as informações das linhas onde elas aparecem no arquivo texto original. 
        Veja na ﬁgura abaixo um exemplo dessa representação: as palavras estão na lista vertical, 
        e cada uma possui uma lista de números de linha onde ocorrem 
        (este é apenas um exemplo, sua estrutura não precisa ser exatamente esta).*/
		
	ManipuladorArquivo manipula = new ManipuladorArquivo();
	System.out.println("Texto lido do arquivo: " + manipula.leArquivo());
    }
    
}
