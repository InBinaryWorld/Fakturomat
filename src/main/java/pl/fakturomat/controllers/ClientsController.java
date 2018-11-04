package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.dataBase.modelsFx.ClientFx;
import pl.fakturomat.dataBase.modelManagers.ClientModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class ClientsController {

  @FXML
  private TableView<ClientFx> tableView;

  @FXML
  private TableColumn<ClientFx, String> nameColumn;

  @FXML
  private TableColumn<ClientFx, String> nipColumn;

  @FXML
  private TableColumn<ClientFx, String> postCodeColumn;

  @FXML
  private TableColumn<ClientFx, String> cityColumn;

  @FXML
  private TableColumn<ClientFx, String> addressColumn;

  @FXML
  private TableColumn<ClientFx, String> phoneColumn;

  private ClientModel clientModel = new ClientModel();

  public void initialize(){
    try {
      clientModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(ClientModel.getClientFxList());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    nipColumn.setCellValueFactory(cellData -> cellData.getValue().nipProperty());
    postCodeColumn.setCellValueFactory(cellData -> cellData.getValue().postCodeProperty());
    cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
    addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
    phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

  }

  @FXML
  void addAction() {
    DialogTools.addClientDialog();
    try {
      clientModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
  }

}

