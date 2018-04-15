package uinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.ClienteSocio;

import static uinterface.Main.bar;

import java.io.IOException;

public class cadastroSocioController {
    public Label cadastrar;
    public Label voltar;
    public TextField nome;
    public TextField cpf;
    public TextField idade;
    public TextField genero;
    public TextField NSocio;




    public void cadastrar(ActionEvent actionEvent) {

        ClienteSocio c1 = new ClienteSocio(nome.getText(), cpf.getText(), Integer.parseInt(idade.getText()), genero.getText(), Integer.parseInt(NSocio.getText()));

        cadastrar.setText("Cliente " + c1.getNome() + " cadastrado com sucesso!");

        bar.cadastroCliente(c1);

        System.out.println(bar.getClientesNoBar());

        cadastrar.setText("Cliente Cadastrado!");
    }

    public void voltar(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
