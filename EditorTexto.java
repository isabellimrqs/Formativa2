package model;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.Alert.AlertType.*;

import java.io.*;

public class EditorTexto {

    public boolean gravarTexto(String text,String file, String path) {

        String texto = text; // lê o texto do usuário
        String nomeArquivo = path+"\\"+file; // lê o nome do arquivo do usuário
        if (nomeArquivo.endsWith(".txt")) {
            // verifica se o nome do arquivo termina com .txt
            try {
                // tenta criar um objeto PrintWriter para escrever no arquivo
                PrintWriter pw = new PrintWriter(new File(nomeArquivo));
                pw.println(texto); // escreve o texto no arquivo
                pw.close(); // fecha o arquivo
                new Alert(INFORMATION, "Texto escrito com sucesso no arquivo " + nomeArquivo, ButtonType.OK);
                return true;
            } catch (FileNotFoundException e) {
                // trata a exceção se o arquivo não for encontrado
                new Alert(WARNING, "O arquivo " + nomeArquivo + " não foi encontrado.", ButtonType.OK);
                return false;
            }
        } else {
            // informa ao usuário que o nome do arquivo é inválido
            new Alert(ERROR, "O nome do arquivo deve terminar com .txt", ButtonType.OK);
            return false;
        }
    }

    public String lerTexto(String path,String file) {

        String nomeArquivo = path+"\\"+file;
        String linha = ""; // variável para armazenar cada linha do arquivo
        if (nomeArquivo.endsWith(".txt")) {
            // verifica se o nome do arquivo termina com .txt
            try {
                // tenta criar um objeto BufferedReader para ler do arquivo
                BufferedReader br = new BufferedReader(new FileReader(new File(nomeArquivo)));

                while ((linha = br.readLine()) != null) {
                    // lê cada linha do arquivo até o final
                    new Alert(INFORMATION, "Leitura realizada com sucesso" + nomeArquivo, ButtonType.OK);
                    return linha;
                }
                br.close(); // fecha o arquivo
            } catch (FileNotFoundException e) {
                // trata a exceção se o arquivo não for encontrado
                new Alert(WARNING, "O arquivo " + nomeArquivo + " não foi encontrado.", ButtonType.OK);
                return "";
            } catch (IOException e) {
                // trata a exceção se houver algum erro de entrada ou saída
                new Alert(ERROR, "Ocorreu um erro de leitura do arquivo!", ButtonType.OK);
                return "";
            }
        } else {
            // informa ao usuário que o nome do arquivo é inválido
            new Alert(INFORMATION, "O nome do arquivo ou a extensão são inválidos!", ButtonType.OK);
            return "";
        }
       return linha;
    }
}
