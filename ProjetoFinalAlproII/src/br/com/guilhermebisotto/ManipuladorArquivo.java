package br.com.guilhermebisotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

    private BufferedReader readBuffer;
    private BufferedWriter writeBuffer;
    private String path = "D:\\Trabalho PUC\\TrabalhoFinalAlproII\\ArquivosDeTextos\\Arquivo.txt";
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
                StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = readBuffer.readLine()) != null) {
                    String[] palas = line.toString().trim().split(" ");
                    for (int j = 0; j < palas.length; j++) {
                        if (!palas[j].equalsIgnoreCase("")) {
                            organizador.addPalavra(palas[j], numLinha);
                        }
                    }
                    numLinha++;
                }
            } while (readBuffer.read() != -1);
            readBuffer.close();

            return texto.toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return (null);
        }
    }
}
