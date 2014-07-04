package br.com.guilhermebisotto;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ManipuladorArquivo {

    private BufferedReader readBuffer;
    private BufferedWriter writeBuffer;
    private String path;
    private String nomeArquivo;
    private int numLinha = 1;
    
    public ManipuladorArquivo(String path, String nomeArquivo) {
        this.path = path;
        this.nomeArquivo = nomeArquivo;
    }

    public boolean escreveNoArquivo(String texto) {
        try {
            writeBuffer = new BufferedWriter(new FileWriter(path + "html.html"));
            writeBuffer.append(texto);
            writeBuffer.close();
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public String leArquivo(OrganizadorPalavras organizador) {
        StringBuilder texto = new StringBuilder();
        GeradorHTML gerador = new GeradorHTML();

        try {
            readBuffer = new BufferedReader(new FileReader(path + nomeArquivo));
            do {
                String line;
                while ((line = readBuffer.readLine()) != null) {

                    gerador.geraTextoCompleto(this.concatenaTextoCompleto(line), numLinha);
                    texto.append(this.concatenaTextoCompleto(line));
                    texto.append("\n");
                    String[] palas = line.trim().split("[^A-Za-z0-9á-úÁ-Úà-ùÀ-Ùä-üÄ-Ü]");
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
            gerador.geraSumario(organizador.listaOrdenada(organizador.listaPalavras));
            texto = new StringBuilder();
            texto.append(gerador.geraPrimeiraParte());

            this.escreveNoArquivo(texto.toString());
            return texto.toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return (null);
        }
    }

    private String concatenaTextoCompleto(String linha) {
        StringBuilder texto = new StringBuilder();

        texto.append(linha);
        //texto.append("\n");

        return texto.toString();
    }
}
