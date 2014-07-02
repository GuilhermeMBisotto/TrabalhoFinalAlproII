/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guilhermebisotto;

import java.util.StringTokenizer;

/**
 *
 * @author Guilherme Bisotto
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
        //1.1 Parte 1: Modelagem das estruturas de dados e leitura do arquivo Parte 1 - OKAY
        //1.1 Parte 1: Modelagem das estruturas de dados e leitura do arquivo Parte 2 - OKAY
        //1.2 Parte 2: Geração de um arquivo HTML - Em Progresso
        //1.3 Parte 3: GUI - Em Espera
        
        OrganizadorPalavras organizador = new OrganizadorPalavras();
	ManipuladorArquivo manipula = new ManipuladorArquivo();
        String arquivoDeTexto = manipula.leArquivo(organizador);
        
        System.out.println("-------Texto Do Arquivo-------");
        System.out.println(arquivoDeTexto);
        System.out.println("-----Lista Das Palavras e Linhas Em Que Aparecem-----");
        System.out.println(organizador.toString());
    }
    
}
