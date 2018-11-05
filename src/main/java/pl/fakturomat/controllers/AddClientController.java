package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.fakturomat.database.modelmanagers.AddClientModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class AddClientController {
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

  private final AddClientModel addClientModel = new AddClientModel();

  @FXML
  private void addAction() {
    try {
      addClientModel.saveClientInDataBase();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    final Stage stage = (Stage) addBtn.getScene().getWindow();
    stage.close();
  }

  public void initialize() {
    initBindings();
  }

  public AddClientController() {
  }

  private void initBindings() {
    addBtn.disableProperty().bind(nameTxtFld.textProperty().isEmpty()
            .or(nipTxtFld.textProperty().isEmpty())
            .or(postCodeTxtFld.textProperty().isEmpty())
            .or(cityTxtFld.textProperty().isEmpty())
            .or(addressTxtFld.textProperty().isEmpty()));
    addClientModel.getClientFx().nameProperty().bind(nameTxtFld.textProperty());
    addClientModel.getClientFx().nipProperty().bind(nipTxtFld.textProperty());
    addClientModel.getClientFx().postCodeProperty().bind(postCodeTxtFld.textProperty());
    addClientModel.getClientFx().cityProperty().bind(cityTxtFld.textProperty());
    addClientModel.getClientFx().addressProperty().bind(addressTxtFld.textProperty());
    addClientModel.getClientFx().phoneProperty().bind(phoneTxtFld.textProperty());
  }

}
