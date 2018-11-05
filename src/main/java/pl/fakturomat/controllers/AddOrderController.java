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

  public AddOrderController() {
  }

  /**
   * Initialize.
   */
  public final void initialize() {
    try {
      addOrderModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initControls();
    initBindings();

  }

  private void initBindings() {
    final BooleanProperty flag = new SimpleBooleanProperty(false);
    addBtn.disableProperty().bind(productComBox.valueProperty().isNull()
            .or(quantityTxtFld.textProperty().isEmpty()).or(flag));
    Listeners.listener(flag, quantityTxtFld);
  }

  private void initControls() {
    productComBox.setItems(addOrderModel.getProductFxList());
  }

  @FXML
  private void addAction() {
    pullData();
    addOrderModel.addToOrderList();
    final Stage stage = (Stage) addBtn.getScene().getWindow();
    stage.close();

  }

  private void pullData() {
    addOrderModel.getOrderFx().priceProperty().bind(productComBox.getValue().priceProperty());
    addOrderModel.getOrderFx().measureProperty().bind(productComBox.getValue().measureProperty());
    addOrderModel.getOrderFx().taxProperty().bind(productComBox.getValue().taxProperty());
    addOrderModel.getOrderFx().nameProperty().bind(productComBox.getValue().nameProperty());
    addOrderModel.getOrderFx().invoiceFxProperty().bind(addOrderModel.getNewInvoiceModel().invoiceFxProperty());
    addOrderModel.getOrderFx().setQuantity(Double.parseDouble(quantityTxtFld.getText()));
  }


  public void passNewInvoiceModel(NewInvoiceModel newInvoiceModel) {
    addOrderModel.setNewInvoiceModel(newInvoiceModel);
  }
}
