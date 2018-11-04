package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.fakturomat.dataBase.modelManagers.AddClientModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class AddClientController {
  @FXML
  public Button addButton;

  @FXML
  private TextField nameTextField;

  @FXML
  private TextField nipTextField;

  @FXML
  private TextField postCodeTextField;

  @FXML
  private TextField cityTextField;

  @FXML
  private TextField addressTextField;

  @FXML
  private TextField phoneTextField;

  AddClientModel addClientModel = new AddClientModel();

  @FXML
  void addAction() {
    try {
      addClientModel.saveClientInDataBase();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    Stage stage = (Stage) addButton.getScene().getWindow();
    stage.close();
  }

  public void initialize() {
    initBindings();
  }

  private void initBindings() {
    addButton.disableProperty().bind(nameTextField.textProperty().isEmpty().or(nipTextField.textProperty().isEmpty()).or(
            postCodeTextField.textProperty().isEmpty()).or(cityTextField.textProperty().isEmpty()).or(addressTextField.textProperty().isEmpty()));
    addClientModel.getClientFx().nameProperty().bind(nameTextField.textProperty());
    addClientModel.getClientFx().nipProperty().bind(nipTextField.textProperty());
    addClientModel.getClientFx().postCodeProperty().bind(postCodeTextField.textProperty());
    addClientModel.getClientFx().cityProperty().bind(cityTextField.textProperty());
    addClientModel.getClientFx().addressProperty().bind(addressTextField.textProperty());
    addClientModel.getClientFx().phoneProperty().bind(phoneTextField.textProperty());
  }

}
