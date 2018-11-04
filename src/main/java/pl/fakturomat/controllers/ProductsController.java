package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.dataBase.modelsFx.ProductFx;
import pl.fakturomat.dataBase.modelManagers.ProductModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

public class ProductsController {

  @FXML
  private TableView<ProductFx> tableView;

  @FXML
  private TableColumn<ProductFx, String> nameColumn;

  @FXML
  private TableColumn<ProductFx, String> measureColumn;

  @FXML
  private TableColumn<ProductFx, Double> priceColumn;

  @FXML
  private TableColumn<ProductFx, Double> taxColumn;

  ProductModel productModel = new ProductModel();

  public void initialize(){

    try {
      productModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(productModel.getClientFxList());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    measureColumn.setCellValueFactory(cellData -> cellData.getValue().measureProperty());
    taxColumn.setCellValueFactory(cellData -> cellData.getValue().taxProperty().asObject());
    priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
  }

  @FXML
  void addAction() {
    DialogTools.addProductDialog();
    try {
      ProductModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
  }

}
