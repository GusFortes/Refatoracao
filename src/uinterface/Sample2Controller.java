package uinterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistence.Cliente;

public class Sample2Controller {

    public Label cadastrar;
    public Label voltar;
    public TextField nome;
    public TextField cpf;
    public TextField idade;
    public TextField genero;




    public void cadastrar(ActionEvent actionEvent) {

        Cliente c1 = new Cliente(nome.getText(), cpf.getText(), Integer.parseInt(idade.getText()), genero.getText());


        cadastrar.setText("Cliente " + c1.getNome() + "cadastrado com sucesso!");

    }


    public void voltar(ActionEvent actionEvent) {

    }
}
