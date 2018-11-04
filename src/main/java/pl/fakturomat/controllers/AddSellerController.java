package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.fakturomat.dataBase.modelManagers.AddSellerModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class AddSellerController {
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

  AddSellerModel addSellerModel = new AddSellerModel();

  @FXML
  void addAction() {
    try {
      addSellerModel.saveSellerInDataBase();
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
    addSellerModel.getSellerFx().nameProperty().bind(nameTextField.textProperty());
    addSellerModel.getSellerFx().nipProperty().bind(nipTextField.textProperty());
    addSellerModel.getSellerFx().postCodeProperty().bind(postCodeTextField.textProperty());
    addSellerModel.getSellerFx().cityProperty().bind(cityTextField.textProperty());
    addSellerModel.getSellerFx().addressProperty().bind(addressTextField.textProperty());
    addSellerModel.getSellerFx().phoneProperty().bind(phoneTextField.textProperty());
  }

}
