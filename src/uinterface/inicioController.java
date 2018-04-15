package uinterface;
import business.Bar;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class inicioController {

    public Label cadastro;

    Bar bar = new Bar();
    private Scene scene;


    public void cadastro(ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cadastro");
        stage.setScene(scene);
        stage.show();

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


    }

    public void cadastroSocio(ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("cadastroSocio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Socio");
        stage.setScene(scene);
        stage.show();

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


    }


    public void consulta(ActionEvent actionEvent) throws IOException {
        FXMLLoader consultar = new FXMLLoader();
        consultar.setLocation(getClass().getResource("consulta.fxml"));
        Scene consulta = new Scene(consultar.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Consulta");
        stage.setScene(consulta);
        stage.show();

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void fecharBar(ActionEvent actionEvent) throws IOException {
        FXMLLoader consultar = new FXMLLoader();
        consultar.setLocation(getClass().getResource("fecha.fxml"));
        Scene fechamento = new Scene(consultar.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Fechamento");
        stage.setScene(fechamento);
        stage.show();

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }


    public Scene getScene() {
        return scene;
    }
}
