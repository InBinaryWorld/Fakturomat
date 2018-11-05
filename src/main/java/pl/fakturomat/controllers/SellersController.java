package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.database.modelmanagers.SellerModel;
import pl.fakturomat.database.modelsfx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class SellersController {

  @FXML
  private TableView<SellerFx> tableView;

  @FXML
  private TableColumn<SellerFx, String> nameClm;

  @FXML
  private TableColumn<SellerFx, String> nipClm;

  @FXML
  private TableColumn<SellerFx, String> postCodeClm;

  @FXML
  private TableColumn<SellerFx, String> cityClm;

  @FXML
  private TableColumn<SellerFx, String> addressClm;

  @FXML
  private TableColumn<SellerFx, String> phoneColumn;

  private SellerModel sellerModel = new SellerModel();

  /**
   * Initialize.
   */
  @FXML
  public void initialize() {
    try {
      sellerModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(SellerModel.getSellerFxList());
    nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    nipClm.setCellValueFactory(cellData -> cellData.getValue().nipProperty());
    postCodeClm.setCellValueFactory(cellData -> cellData.getValue().postCodeProperty());
    cityClm.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
    addressClm.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
    phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

  }

  @FXML
  void addAction() {
    DialogTools.addSellerDialog();
    try {
      sellerModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
  }

}

