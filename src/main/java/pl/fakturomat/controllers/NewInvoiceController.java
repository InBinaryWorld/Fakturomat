package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.dataBase.modelManagers.NewInvoiceModel;
import pl.fakturomat.dataBase.modelsFx.ClientFx;
import pl.fakturomat.dataBase.modelsFx.OrderFx;
import pl.fakturomat.dataBase.modelsFx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

import java.sql.SQLException;
import java.time.LocalDate;

public class NewInvoiceController {

  @FXML
  private ComboBox<SellerFx> sellerComboBox;

  @FXML
  private ComboBox<ClientFx> clientComboBox;

  @FXML
  private TableView<OrderFx> tableView;

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

  @FXML
  private Button acceptInvoiceButton;

  NewInvoiceModel newInvoiceModel = new NewInvoiceModel();

  public void initialize(){
    try {
      newInvoiceModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initControls();
    initBindings();
    totalAmountLabel.setText("0");
  }

  private void initControls() {

    sellerComboBox.setItems(newInvoiceModel.getSellerFxList());
    clientComboBox.setItems(newInvoiceModel.getClientFxList());
    tableView.setItems(newInvoiceModel.getOrderFxList());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
    amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
    taxColumn.setCellValueFactory(cellData -> cellData.getValue().taxProperty().asObject());
    measureColumn.setCellValueFactory(cellData -> cellData.getValue().measureProperty());
    priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

  }

  private void initBindings() {
    acceptInvoiceButton.disableProperty().bind(clientComboBox.valueProperty().isNull().or(sellerComboBox.valueProperty().isNull()));
    newInvoiceModel.getInvoiceFx().clientFxProperty().bind(clientComboBox.valueProperty());
    newInvoiceModel.getInvoiceFx().sellerFxProperty().bind(sellerComboBox.valueProperty());
    //Można przeniećć do acceptInvoiceAction
    newInvoiceModel.getInvoiceFx().setDate(LocalDate.now());

  }

  public NewInvoiceController() {
  }

  @FXML
  void acceptInvoiceAction() {
    try {
      newInvoiceModel.saveInDatabase();
    } catch (ApplicationException | SQLException e) {
      DialogTools.errorDialog(e.getMessage());
    }

    newInvoiceModel = new NewInvoiceModel();
    initialize();
  }

  @FXML
  void addProductAction() {
    DialogTools.addOrderDialog(newInvoiceModel);

    double count =0;
    for (OrderFx orderFx: newInvoiceModel.getOrderFxList()) {
      count +=orderFx.getAmount();
    };
    totalAmountLabel.setText(count+"");


  }

}
