package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.fakturomat.dataBase.modelManagers.ShowInvoiceModel;
import pl.fakturomat.dataBase.modelsFx.InvoiceFx;
import pl.fakturomat.dataBase.modelsFx.OrderFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ShowInvoiceController {
  @FXML
  private Label dateLabel;
  @FXML
  private Label sellerNameLabel;
  @FXML
  private Label sellerNipLabel;
  @FXML
  private Label sellerPostCodeLabel;
  @FXML
  private Label sellerCityLabel;
  @FXML
  private Label sellerAddressLabel;
  @FXML
  private Label sellerPhoneLabel;
  @FXML
  private Label clientNameLabel;
  @FXML
  private Label clientNipLabel;
  @FXML
  private Label clientPostCodeLabel;
  @FXML
  private Label clientCityLabel;
  @FXML
  private Label clientAddressLabel;
  @FXML
  private Label clientPhoneLabel;
  @FXML
  private Label invoiceIdLabel;
  @FXML
  public TableView<OrderFx> tableView;
  @FXML
  private TableColumn<OrderFx, String> nameColumn;
  @FXML
  private TableColumn<OrderFx, Double> quantityColumn;
  @FXML
  private TableColumn<OrderFx, String> measureColumn;
  @FXML
  private TableColumn<OrderFx, Double> priceColumn;
  @FXML
  private TableColumn<OrderFx, Double> taxColumn;
  @FXML
  private TableColumn<OrderFx, Double> amountColumn;
  @FXML
  private Label totalAmountLabel;

  ShowInvoiceModel showInvoiceModel = new ShowInvoiceModel();

  @FXML
  void okAction() {
    Stage stage = (Stage)tableView.getScene().getWindow();
    stage.close();
  }

  public void passInvoiceFx(InvoiceFx invoiceFx) {
    try {
      showInvoiceModel.init(invoiceFx);
    } catch (ApplicationException | SQLException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initBindings();
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(showInvoiceModel.getOrderFxList());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
    measureColumn.setCellValueFactory(cellData -> cellData.getValue().measureProperty());
    priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
    taxColumn.setCellValueFactory(cellData -> cellData.getValue().taxProperty().asObject());
  }

  private void initBindings() {
    dateLabel.setText(showInvoiceModel.getInvoiceFx().getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    invoiceIdLabel.setText(showInvoiceModel.getInvoiceFx().getInvoiceId()+"");
    totalAmountLabel.setText(showInvoiceModel.getTotalAmount()+"");

    sellerNameLabel.setText(showInvoiceModel.getInvoiceFx().getSellerFx().getName());
    sellerNipLabel.setText(showInvoiceModel.getInvoiceFx().getSellerFx().getNip());
    sellerPostCodeLabel.setText(showInvoiceModel.getInvoiceFx().getSellerFx().getPostCode());
    sellerCityLabel.setText(showInvoiceModel.getInvoiceFx().getSellerFx().getCity());
    sellerAddressLabel.setText(showInvoiceModel.getInvoiceFx().getSellerFx().getAddress());
    sellerPhoneLabel.setText(showInvoiceModel.getInvoiceFx().getSellerFx().getPhone());

    clientNameLabel.setText(showInvoiceModel.getInvoiceFx().getClientFx().getName());
    clientNipLabel.setText(showInvoiceModel.getInvoiceFx().getClientFx().getNip());
    clientPostCodeLabel.setText(showInvoiceModel.getInvoiceFx().getClientFx().getPostCode());
    clientCityLabel.setText(showInvoiceModel.getInvoiceFx().getClientFx().getCity());
    clientAddressLabel.setText(showInvoiceModel.getInvoiceFx().getClientFx().getAddress());
    clientPhoneLabel.setText(showInvoiceModel.getInvoiceFx().getClientFx().getPhone());


  }
}
