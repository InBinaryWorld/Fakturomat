package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.dataBase.modelsFx.SellerFx;
import pl.fakturomat.dataBase.modelManagers.SellerModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class SellersController {

  @FXML
  private TableView<SellerFx> tableView;

  @FXML
  private TableColumn<SellerFx, String> nameColumn;

  @FXML
  private TableColumn<SellerFx, String> nipColumn;

  @FXML
  private TableColumn<SellerFx, String> postCodeColumn;

  @FXML
  private TableColumn<SellerFx, String> cityColumn;

  @FXML
  private TableColumn<SellerFx, String> addressColumn;

  @FXML
  private TableColumn<SellerFx, String> phoneColumn;

  private SellerModel sellerModel = new SellerModel();

  public void initialize(){
    try {
      sellerModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(SellerModel.getSellerFxList());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    nipColumn.setCellValueFactory(cellData -> cellData.getValue().nipProperty());
    postCodeColumn.setCellValueFactory(cellData -> cellData.getValue().postCodeProperty());
    cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
    addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
    phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

  }

  @FXML
  void addAction() {
    DialogTools.addSellerDialog();
    try {
      sellerModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
  }

}

