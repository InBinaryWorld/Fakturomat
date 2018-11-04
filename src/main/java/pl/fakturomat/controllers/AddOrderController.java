package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.fakturomat.dataBase.modelManagers.AddOrderModel;
import pl.fakturomat.dataBase.modelManagers.NewInvoiceModel;

public class AddOrderController {

  @FXML
  private Button addButton;

  @FXML
  private TextField quantityTextField;

  @FXML
  private ComboBox<?> productComboBox;

  AddOrderModel addOrderModel= new AddOrderModel();

  public AddOrderController() {
  }

  public void initialize(){

  }

  @FXML
  void addAction() {

  }

  public void passNewInvoiceModel(NewInvoiceModel newInvoiceModel){
    addOrderModel.setNewInvoiceModel(newInvoiceModel);
  }

}
