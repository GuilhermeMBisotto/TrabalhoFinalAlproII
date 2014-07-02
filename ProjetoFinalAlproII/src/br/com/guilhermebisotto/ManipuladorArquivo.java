package br.com.guilhermebisotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

    private BufferedReader readBuffer;
    private BufferedWriter writeBuffer;
    private final String path = "/Users/guilhermemorescobisotto/NetBeansProjects/TrabalhoFinalAlproII/ProjetoFinalAlproII/Textos/Arquivo.txt";
    private int numLinha = 1;

    public boolean escreveNoArquivo(String texto) {
        try {
            writeBuffer = new BufferedWriter(new FileWriter(path));
            writeBuffer.append(texto + "\n");
            writeBuffer.close();
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public String leArquivo(OrganizadorPalavras organizador) {
        StringBuilder texto = new StringBuilder();

        try {
            readBuffer = new BufferedReader(new FileReader(path));
            do {
                String line;
                while ((line = readBuffer.readLine()) != null) {
                    texto.append(this.concatenaTextoCompleto(line));
                    String[] palas = line.trim().split(" ");
                    for (String pala : palas) {
                        if (!pala.equalsIgnoreCase("")) {
                            organizador.addPalavra(pala, numLinha);
                        }
                    }
                    numLinha++;
                }
            } while (readBuffer.read() != -1);
            readBuffer.close();
            numLinha = 1;
            return texto.toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return (null);
        }
    }
    
    private String concatenaTextoCompleto(String linha) {
        StringBuilder texto = new StringBuilder();
        
        texto.append(linha);
        texto.append("\n");
        
        return texto.toString();
    }
}
