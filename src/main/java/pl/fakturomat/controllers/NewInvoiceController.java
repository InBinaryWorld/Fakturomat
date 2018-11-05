package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.database.modelmanagers.NewInvoiceModel;
import pl.fakturomat.database.modelsfx.ClientFx;
import pl.fakturomat.database.modelsfx.OrderFx;
import pl.fakturomat.database.modelsfx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

import java.sql.SQLException;
import java.time.LocalDate;

public class NewInvoiceController {
  @FXML
  private ComboBox<SellerFx> sellerComBox;
  @FXML
  private ComboBox<ClientFx> clientComBox;
  @FXML
  private TableView<OrderFx> tableView;
  @FXML
  private TableColumn<OrderFx, String> nameClm;
  @FXML
  private TableColumn<OrderFx, Double> quantityClm;
  @FXML
  private TableColumn<OrderFx, String> measureClm;
  @FXML
  private TableColumn<OrderFx, Double> priceClm;
  @FXML
  private TableColumn<OrderFx, Double> taxClm;
  @FXML
  private TableColumn<OrderFx, Double> amountClm;
  @FXML
  private Label totalAmountLabel;
  @FXML
  private Button acceptInvoiceBtn;
  private NewInvoiceModel newInvoiceModel = new NewInvoiceModel();

  /**
   * Initialize.
   */
  public void initialize() {
    try {
      newInvoiceModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initControls();
    initBindings();
    totalAmountLabel.setText("0");
  }

  private void initControls() {
    sellerComBox.setItems(newInvoiceModel.getSellerFxList());
    clientComBox.setItems(newInvoiceModel.getClientFxList());
    tableView.setItems(newInvoiceModel.getOrderFxList());
    nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    quantityClm.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
    amountClm.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
    taxClm.setCellValueFactory(cellData -> cellData.getValue().taxProperty().asObject());
    measureClm.setCellValueFactory(cellData -> cellData.getValue().measureProperty());
    priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
  }

  private void initBindings() {
    acceptInvoiceBtn.disableProperty().bind(clientComBox.valueProperty().isNull()
            .or(sellerComBox.valueProperty().isNull()));
    newInvoiceModel.getInvoiceFx().clientFxProperty().bind(clientComBox.valueProperty());
    newInvoiceModel.getInvoiceFx().sellerFxProperty().bind(sellerComBox.valueProperty());
  }

  public NewInvoiceController() {
  }

  @FXML
  private void acceptInvoiceAction() {
    newInvoiceModel.getInvoiceFx().setDate(LocalDate.now());
    try {
      newInvoiceModel.saveInDatabase();
    } catch (ApplicationException | SQLException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }

    newInvoiceModel = new NewInvoiceModel();
    initialize();
  }

  @FXML
  private void addProductAction() {
    DialogTools.addOrderDialog(newInvoiceModel);
    double count = 0;
    for (final OrderFx orderFx : newInvoiceModel.getOrderFxList()) {
      count += orderFx.getAmount();
    }
    totalAmountLabel.setText(String.valueOf(count));
  }

}
