/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilhermebisotto;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        //1.2 Parte 2: Geração de um arquivo HTML - OKAY
        //1.3 Parte 3: GUI - Okay
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } catch (InstantiationException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        }

        Tela telaprincipal = new Tela();
        telaprincipal.setTitle("Trabalho Final Alpro II - PUCRS");
        telaprincipal.setVisible(true);

    }

}
