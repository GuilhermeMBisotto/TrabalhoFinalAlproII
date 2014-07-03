/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.guilhermebisotto;

import java.util.ArrayList;

/**
 *
 * @author guilhermemorescobisotto
 */
public class GeradorHTML {
    
    private StringBuilder textoCompleto;
    private StringBuilder sumario;
    private final String path = System.getProperty("user.dir") + "/Textos/";
    
    public GeradorHTML() {
        textoCompleto = new StringBuilder();
        sumario = new StringBuilder();
    }
    
    public void geraTextoCompleto(String linha, int numLinha) {
        textoCompleto.append("<div><a id=");
        textoCompleto.append("\"").append(numLinha).append("\"");
        textoCompleto.append(">");
        if(textoCompleto.append(linha).equals(textoCompleto))
            textoCompleto.append("<br>").append("</a></div>").append("\n");
        else
            textoCompleto.append(linha).append("</a></div>").append("\n");     
        
    }
    
    public String getTextoCompleto() {
        return this.textoCompleto.toString();
    }
    
    public void geraSumario(ArrayList<Palavra> listaPalavras) {
        textoCompleto.append("</div>");
        sumario.append("<div>");
        for (Palavra listaPalavra : listaPalavras) {
            sumario.append("<h2>" + listaPalavra.getPalavra().charAt(0) + "</h2>").append("\n");
            sumario.append("<div class=\"content-wrapper-container\">");
            sumario.append("<div class=\"word-wrapper\">").append(listaPalavra.getPalavra()).append("</div>").append("\n");
            sumario.append("<div  class=\"links-wrapper\">").append("\n");
            for (int j = 0; j < listaPalavra.getNumerosLinhas().size(); j++) {
                sumario.append("<a class=\"links\" id=\"links\" href=\"#").append(listaPalavra.getNumerosLinhas().get(j)).append("\">").append(listaPalavra.getNumerosLinhas().get(j) + "</a> ").append("\n");  
            }
            sumario.append("</div>").append("\n").append("<div class=\"clear-both\"></div>").append("</div>");
        }
    }
    
    public String geraPrimeiraParte() {
        StringBuilder html = new StringBuilder();
        
        html.append("<!DOCTYPE html>\n\n");
        html.append("<html>\n\n");
        html.append("<head>\n");
        html.append("<title>Trabalho Final Alpro II - PUCRS</title>\n");
        html.append("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n");
        html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"").append(path).append("styles.css\" />\n");
        html.append("</head>\n\n");
        html.append("<body>\n");
        html.append("<h1>Trabalho Final Alpro II</h1>");
        html.append("<div class=\"text-content\" id=\"links-wrapper\">\n");
        html.append(this.getTextoCompleto());
        html.append("\n\n");
        html.append(this.getSumario());
        html.append("</div>\n\n");
        html.append(this.geraScript());
        html.append("</body>\n\n");
        html.append("</html>");
        
        return html.toString();
    }
    
    private String geraScript() {
        StringBuilder script = new StringBuilder();
        
        script.append("<script type=\"text/javascript\">\n");
        script.append("var descendentes = document.querySelectorAll(\"#links\");\n" +
"for (var i = 0; i < descendentes.length; i++) {\n" +
"    descendentes[i].addEventListener(\"click\", function (e) {\n" +
"        alert('O elemento clicado foi o ' + this.innerHTML);\n" +
"		var destaque = document.getElementById(this.innerHTML);\n" +
"		destaque.className = \"linha\";\n" +
"    })\n" +
"}\n");
        script.append("</script>\n\n");
        
        return script.toString();
    }
    
    public String getSumario() {
        return this.sumario.toString();
    }
    
}
