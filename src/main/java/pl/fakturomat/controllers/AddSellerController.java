package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.fakturomat.database.modelmanagers.AddSellerModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class AddSellerController {
  @FXML
  public Button addBtn;

  @FXML
  private TextField nameTxtFld;

  @FXML
  private TextField nipTxtFld;

  @FXML
  private TextField postCodeTxtFld;

  @FXML
  private TextField cityTxtFld;

  @FXML
  private TextField addressTxtFld;

  @FXML
  private TextField phoneTxtFld;

  private AddSellerModel addSellerModel = new AddSellerModel();

  @FXML
  void addAction() {
    try {
      addSellerModel.saveSellerInDataBase();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    Stage stage = (Stage) addBtn.getScene().getWindow();
    stage.close();
  }

  public void initialize() {
    initBindings();
  }

  private void initBindings() {
    addBtn.disableProperty().bind(nameTxtFld.textProperty().isEmpty().or(
            nipTxtFld.textProperty().isEmpty()).or(
            postCodeTxtFld.textProperty().isEmpty()).or(
                    cityTxtFld.textProperty().isEmpty()).or(
                            addressTxtFld.textProperty().isEmpty()));
    addSellerModel.getSellerFx().nameProperty().bind(nameTxtFld.textProperty());
    addSellerModel.getSellerFx().nipProperty().bind(nipTxtFld.textProperty());
    addSellerModel.getSellerFx().postCodeProperty().bind(postCodeTxtFld.textProperty());
    addSellerModel.getSellerFx().cityProperty().bind(cityTxtFld.textProperty());
    addSellerModel.getSellerFx().addressProperty().bind(addressTxtFld.textProperty());
    addSellerModel.getSellerFx().phoneProperty().bind(phoneTxtFld.textProperty());
  }

}
