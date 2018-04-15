package uinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import persistence.Cliente;

import static uinterface.Main.bar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fechaController {
    @FXML
    public TableView<Cliente> tabela;
    @FXML
    public TableColumn <Cliente, String>nome;
    @FXML
    public TableColumn <Cliente, String>cpf;



    public void mostraClientes(ActionEvent actionEvent) {

        try {
            bar.fechaBar();
        } catch (IOException e) {                }

        nome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        cpf.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));


        tabela.setItems(listaDeClientes());
    }


    private ObservableList<Cliente> listaDeClientes() {
        return FXCollections.observableArrayList(bar.clientesDoDia);
    }


}

