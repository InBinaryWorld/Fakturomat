package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.database.modelmanagers.ProductModel;
import pl.fakturomat.database.modelsfx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class ProductsController {

  @FXML
  private TableView<ProductFx> tableView;

  @FXML
  private TableColumn<ProductFx, String> nameClm;

  @FXML
  private TableColumn<ProductFx, String> measureClm;

  @FXML
  private TableColumn<ProductFx, Double> priceClm;

  @FXML
  private TableColumn<ProductFx, Double> taxColumn;

  /**
   * Initialize.
   */
  @FXML
  public void initialize() {

    try {
      ProductModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(ProductModel.getClientFxList());
    nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    measureClm.setCellValueFactory(cellData -> cellData.getValue().measureProperty());
    taxColumn.setCellValueFactory(cellData -> cellData.getValue().taxProperty().asObject());
    priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
  }

  @FXML
  void addAction() {
    DialogTools.addProductDialog();
    try {
      ProductModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
  }

}
