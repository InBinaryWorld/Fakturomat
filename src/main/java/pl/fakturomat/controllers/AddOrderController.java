package pl.fakturomat.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import pl.fakturomat.dataBase.modelManagers.AddOrderModel;
import pl.fakturomat.dataBase.modelManagers.NewInvoiceModel;
import pl.fakturomat.dataBase.modelsFx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;
import pl.fakturomat.tools.Listeners;
import pl.fakturomat.tools.converters.OrderConventer;

public class AddOrderController {

  @FXML
  private Button addButton;

  @FXML
  private TextField quantityTextField;

  @FXML
  private ComboBox<ProductFx> productComboBox;

  private AddOrderModel addOrderModel= new AddOrderModel();
  private NewInvoiceModel newInvoiceModel;

  public AddOrderController() {
  }

  public void initialize(){
    try {
      addOrderModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initControls();

    BooleanProperty flag = new SimpleBooleanProperty(false);
    addButton.disableProperty().bind(productComboBox.valueProperty().isNull().or(quantityTextField.textProperty().isEmpty()).or(flag));
    Listeners.listener(flag,quantityTextField);

  }


  private void initControls() {
    productComboBox.setItems(addOrderModel.getProductFxList());
  }

  @FXML
  void addAction() {

    addOrderModel.getOrderFx().priceProperty().bind(productComboBox.valueProperty().get().priceProperty());
    addOrderModel.getOrderFx().measureProperty().bind(productComboBox.valueProperty().get().measureProperty());
    addOrderModel.getOrderFx().taxProperty().bind(productComboBox.valueProperty().get().taxProperty());
    addOrderModel.getOrderFx().nameProperty().bind(productComboBox.valueProperty().get().nameProperty());
    addOrderModel.getOrderFx().invoiceFxProperty().bind(newInvoiceModel.invoiceFxProperty());
    addOrderModel.getOrderFx().setQuantity(Double.parseDouble(quantityTextField.getText()));

    newInvoiceModel.getOrderFxList().add(addOrderModel.getOrderFx());
    Stage stage =(Stage) addButton.getScene().getWindow();
    stage.close();

  }

  public void passNewInvoiceModel(NewInvoiceModel newInvoiceModel){
    this.newInvoiceModel = newInvoiceModel;
  }

}
