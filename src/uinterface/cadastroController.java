package uinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.Cliente;

import static uinterface.Main.bar;

import java.io.IOException;

public class cadastroController {

	public Label cadastrar;
	public Label voltar;
	public TextField nome;
	public TextField cpf;
	public TextField idade;
	public TextField genero;

	public void cadastrar(ActionEvent actionEvent) {

		Cliente c1 = new Cliente(nome.getText(), cpf.getText(), Integer.parseInt(idade.getText()), genero.getText());
		bar.cadastroCliente(c1);

		cadastrar.setText("Cliente Cadastrado!");

	}

	public void voltar(ActionEvent actionEvent) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Inicio");
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();

		((Node) (actionEvent.getSource())).getScene().getWindow().hide();
	}
}
