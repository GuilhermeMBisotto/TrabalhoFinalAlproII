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
	
	public String leArquivo() {
            StringBuffer texto = new StringBuffer();
            
            try {
			readBuffer = new BufferedReader(new FileReader(path));
                        do {
                            texto.append(readBuffer.readLine());
                        } while(readBuffer.read() != -1);
			readBuffer.close();
			return texto.toString();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return (null);
		}
	}
}
