package pl.fakturomat.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.fakturomat.database.modelmanagers.AddOrderModel;
import pl.fakturomat.database.modelmanagers.NewInvoiceModel;
import pl.fakturomat.database.modelsfx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;
import pl.fakturomat.tools.Listeners;

public class AddOrderController {

  @FXML
  private Button addBtn;

  @FXML
  private TextField quantityTxtFld;

  @FXML
  private ComboBox<ProductFx> productComBox;

  private AddOrderModel addOrderModel = new AddOrderModel();
  private NewInvoiceModel newInvoiceModel;

  public AddOrderController() {
  }

  /**
   * Initialize.
   */
  public void initialize() {
    try {
      addOrderModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initControls();
    BooleanProperty flag = new SimpleBooleanProperty(false);
    addBtn.disableProperty().bind(productComBox.valueProperty().isNull().or(
            quantityTxtFld.textProperty().isEmpty()).or(flag));
    Listeners.listener(flag, quantityTxtFld);

  }


  private void initControls() {
    productComBox.setItems(addOrderModel.getProductFxList());
  }

  @FXML
  void addAction() {

    addOrderModel.getOrderFx().priceProperty().bind(productComBox.getValue().priceProperty());
    addOrderModel.getOrderFx().measureProperty().bind(productComBox.getValue().measureProperty());
    addOrderModel.getOrderFx().taxProperty().bind(productComBox.getValue().taxProperty());
    addOrderModel.getOrderFx().nameProperty().bind(productComBox.getValue().nameProperty());
    addOrderModel.getOrderFx().invoiceFxProperty().bind(newInvoiceModel.invoiceFxProperty());
    addOrderModel.getOrderFx().setQuantity(Double.parseDouble(quantityTxtFld.getText()));

    newInvoiceModel.getOrderFxList().add(addOrderModel.getOrderFx());
    Stage stage = (Stage) addBtn.getScene().getWindow();
    stage.close();

  }

  public void passNewInvoiceModel(NewInvoiceModel newInvoiceModel) {
    this.newInvoiceModel = newInvoiceModel;
  }

}
