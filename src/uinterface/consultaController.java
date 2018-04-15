package uinterface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static uinterface.Main.bar;

import java.io.IOException;

public class consultaController {

	public TextField consultaPorCpf;
	public Label resultado;

	public void consultarCpf(ActionEvent actionEvent) {

		resultado.setText(bar.retornaCliente(consultaPorCpf.getText()).getNome());

	}

	public void genero(ActionEvent actionEvent) {
		resultado.setText(bar.retornaDistribuicaoGenero());
	}

	public void socios(ActionEvent actionEvent) {
		resultado.setText(bar.qntdDeSocios());
	}

	public void clientesNoBar(ActionEvent actionEvent) {

		resultado.setText("Quantidade de Clientes no Bar: " + String.valueOf(bar.qntdDePessoas()));

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
