package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Animal;
import model.Granja;
import model.TipoAnimal;

public class GranjaController {

    @FXML
    private TextField identificadorField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField pesoField;

    @FXML
    private DatePicker fechaNacimientoPicker;

    @FXML
    private ComboBox<TipoAnimal> tipoComboBox;

    @FXML
    private ListView<Animal> animalesListView;

    @FXML
    private Label gallinasCountLabel;

    @FXML
    private Label vacasCountLabel;

    @FXML
    private Label cerdosCountLabel;

    private Granja granja;
    private ObservableList<Animal> animalesList;

    @FXML
    public void initialize() {
        granja = new Granja();
        animalesList = FXCollections.observableArrayList();
        animalesListView.setItems(animalesList);
        tipoComboBox.setItems(FXCollections.observableArrayList(TipoAnimal.values()));
    }

    @FXML
    private void handleRegistrarAnimal() {
        int identificador = Integer.parseInt(identificadorField.getText());
        String nombre = nombreField.getText();
        double peso = Double.parseDouble(pesoField.getText());
        TipoAnimal tipo = tipoComboBox.getValue();
        Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoPicker.getValue());

        Animal animal = new Animal(identificador, nombre, peso, tipo, fechaNacimiento);
        granja.registrarAnimal(animal);
        animalesList.add(animal);

        actualizarContadores();
    }

    private void actualizarContadores() {
        gallinasCountLabel.setText("Gallinas: " + granja.contarAnimalesPorTipo(TipoAnimal.GALLINA));
        vacasCountLabel.setText("Vacas: " + granja.contarAnimalesPorTipo(TipoAnimal.VACA));
        cerdosCountLabel.setText("Cerdos: " + granja.contarAnimalesPorTipo(TipoAnimal.CERDO));
    }
}
