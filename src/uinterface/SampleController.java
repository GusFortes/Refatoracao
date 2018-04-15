package uinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.Cliente;

import java.io.IOException;

public class SampleController {

    public Label cadastro;

    public Cliente c1 = new Cliente("João", "1234",20, "Masculino");


    public void cadastro(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.show();

    }

    public void consulta(ActionEvent actionEvent) {
        cadastro.setText(c1.getNome());
    }

    public void consultaDia(ActionEvent actionEvent) {
    }
}
