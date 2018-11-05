package pl.fakturomat.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import pl.fakturomat.database.modelmanagers.AddProductModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;
import pl.fakturomat.tools.Listeners;

public class AddProductController {

  @FXML
  private Button addButton;

  @FXML
  private TextField nameTxtFld;

  @FXML
  private TextField measureTxtFld;

  @FXML
  private TextField priceTxtFld;

  @FXML
  private TextField taxTxtFld;

  private AddProductModel addProductModel = new AddProductModel();

  @FXML
  void addAction() {
    try {
      addProductModel.saveProductInDataBase();
    } catch (
            ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    Stage stage = (Stage) addButton.getScene().getWindow();
    stage.close();
  }

  public void initialize() {
    initBindings();
  }

  private void initBindings() {
    BooleanProperty flag1 = new SimpleBooleanProperty(false);
    BooleanProperty flag2 = new SimpleBooleanProperty(false);
    addButton.disableProperty().bind(nameTxtFld.textProperty().isEmpty().or(
            measureTxtFld.textProperty().isEmpty()).or(
            priceTxtFld.textProperty().isEmpty()).or(
                    taxTxtFld.textProperty().isEmpty()).or(flag1).or(flag2));
    addProductModel.getProductFx().measureProperty().bind(measureTxtFld.textProperty());
    addProductModel.getProductFx().nameProperty().bind(nameTxtFld.textProperty());

    StringConverter<Number> converter = new NumberStringConverter();
    DoubleProperty taxProperty = addProductModel.getProductFx().taxProperty();
    Bindings.bindBidirectional(taxTxtFld.textProperty(), taxProperty, converter);
    DoubleProperty priceProperty = addProductModel.getProductFx().priceProperty();
    Bindings.bindBidirectional(priceTxtFld.textProperty(), priceProperty, converter);
    Listeners.listener(flag1, taxTxtFld);
    Listeners.listener(flag2, priceTxtFld);
  }


}
