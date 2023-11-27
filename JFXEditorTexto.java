package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import model.EditorTexto;

public class JFXEditorTexto {

    public TextArea txtAreaTexto;
    public TextField txtPath;
    public TextField txtNomeArquivo;
    public Button btnLerArquivo;
    public Button btnGravarArquivo;

    public void lerArquivo(ActionEvent actionEvent) {
        String path = txtPath.getText();
        String file = txtNomeArquivo.getText();
        EditorTexto leitor = new EditorTexto();
        txtAreaTexto.setText(leitor.lerTexto(path,file));
    }

    public void gravarArquivo(ActionEvent actionEvent) {
        System.out.println("passei por aqui!");
        String path = txtPath.getText();
        String file = txtNomeArquivo.getText();
        String texto = txtAreaTexto.getText();
        EditorTexto gravador = new EditorTexto();
        gravador.gravarTexto(texto,file,path);
    }
}
