package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.fakturomat.database.modelmanagers.ShowInvoiceModel;
import pl.fakturomat.database.modelsfx.InvoiceFx;
import pl.fakturomat.database.modelsfx.OrderFx;
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
  private Label sPostCodeLabel;
  @FXML
  private Label sellerCityLabel;
  @FXML
  private Label sAddressLabel;
  @FXML
  private Label sellerPhoneLabel;
  @FXML
  private Label clientNameLabel;
  @FXML
  private Label clientNipLabel;
  @FXML
  private Label cPostCodeLabel;
  @FXML
  private Label clientCityLabel;
  @FXML
  private Label cAddressLabel;
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

  private ShowInvoiceModel showInvMod = new ShowInvoiceModel();

  @FXML
  void okAction() {
    final Stage stage = (Stage) tableView.getScene().getWindow();
    stage.close();
  }

  /**
   * Initialize.
   *
   * @param invoiceFx IncoiceFx object.
   */
  public void passInvoiceFx(final InvoiceFx invoiceFx) {
    try {
      showInvMod.init(invoiceFx);
    } catch (ApplicationException | SQLException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initBindings();
    initTableView();
  }

  private void initTableView() {
    tableView.setItems(showInvMod.getOrderFxList());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
    measureColumn.setCellValueFactory(cellData -> cellData.getValue().measureProperty());
    priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    quantityColumn.setCellValueFactory(cd -> cd.getValue().quantityProperty().asObject());
    taxColumn.setCellValueFactory(cellData -> cellData.getValue().taxProperty().asObject());
  }

  private void initBindings() {
    dateLabel.setText(showInvMod.getInvoiceFx().getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    invoiceIdLabel.setText(showInvMod.getInvoiceFx().getInvoiceId() + "");
    totalAmountLabel.setText(showInvMod.getTotalAmount() + "");

    sellerNameLabel.setText(showInvMod.getInvoiceFx().getSellerFx().getName());
    sellerNipLabel.setText(showInvMod.getInvoiceFx().getSellerFx().getNip());
    sPostCodeLabel.setText(showInvMod.getInvoiceFx().getSellerFx().getPostCode());
    sellerCityLabel.setText(showInvMod.getInvoiceFx().getSellerFx().getCity());
    sAddressLabel.setText(showInvMod.getInvoiceFx().getSellerFx().getAddress());
    sellerPhoneLabel.setText(showInvMod.getInvoiceFx().getSellerFx().getPhone());

    clientNameLabel.setText(showInvMod.getInvoiceFx().getClientFx().getName());
    clientNipLabel.setText(showInvMod.getInvoiceFx().getClientFx().getNip());
    cPostCodeLabel.setText(showInvMod.getInvoiceFx().getClientFx().getPostCode());
    clientCityLabel.setText(showInvMod.getInvoiceFx().getClientFx().getCity());
    cAddressLabel.setText(showInvMod.getInvoiceFx().getClientFx().getAddress());
    clientPhoneLabel.setText(showInvMod.getInvoiceFx().getClientFx().getPhone());


  }
}
