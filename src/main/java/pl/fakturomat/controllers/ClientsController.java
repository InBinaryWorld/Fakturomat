package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.database.modelmanagers.ClientModel;
import pl.fakturomat.database.modelsfx.ClientFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class ClientsController {

  @FXML
  private TableView<ClientFx> tableView;

  @FXML
  private TableColumn<ClientFx, String> nameClm;

  @FXML
  private TableColumn<ClientFx, String> nipClm;

  @FXML
  private TableColumn<ClientFx, String> postCodeClm;

  @FXML
  private TableColumn<ClientFx, String> cityClm;

  @FXML
  private TableColumn<ClientFx, String> addressClm;

  @FXML
  private TableColumn<ClientFx, String> phoneClm;

  private ClientModel clientModel = new ClientModel();

  /**
   * Initialize.
   */
  public void initialize() {
    try {
      clientModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(ClientModel.getClientFxList());
    nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    nipClm.setCellValueFactory(cellData -> cellData.getValue().nipProperty());
    postCodeClm.setCellValueFactory(cellData -> cellData.getValue().postCodeProperty());
    cityClm.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
    addressClm.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
    phoneClm.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

  }

  @FXML
  void addAction() {
    DialogTools.addClientDialog();
    try {
      clientModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
  }

}

