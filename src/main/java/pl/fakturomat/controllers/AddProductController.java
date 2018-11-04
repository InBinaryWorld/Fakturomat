package pl.fakturomat.controllers;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import pl.fakturomat.dataBase.modelManagers.AddProductModel;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

import java.util.function.BooleanSupplier;

public class AddProductController {

  @FXML
  private Button addButton;

  @FXML
  private TextField nameTextField;

  @FXML
  private TextField measureTextField;

  @FXML
  private TextField priceTextField;

  @FXML
  private TextField taxTextField;

  AddProductModel addProductModel = new AddProductModel();

  @FXML
  void addAction() {
    try{
    addProductModel.saveProductInDataBase();
  } catch (
  ApplicationException e) {
    DialogTools.errorDialog(e.getMessage());
  }
  Stage stage = (Stage) addButton.getScene().getWindow();
    stage.close();
  }

  public void initialize(){
    initBindings();
  }

  private void initBindings() {
    BooleanProperty flag1 = new SimpleBooleanProperty(false);
    BooleanProperty flag2 = new SimpleBooleanProperty(false);
    addButton.disableProperty().bind(nameTextField.textProperty().isEmpty().or(measureTextField.textProperty().isEmpty()).or(
            priceTextField.textProperty().isEmpty()).or(taxTextField.textProperty().isEmpty()).or(flag1).or(flag2));
    addProductModel.getProductFx().measureProperty().bind(measureTextField.textProperty());
    addProductModel.getProductFx().nameProperty().bind(nameTextField.textProperty());

    StringConverter<Number> converter = new NumberStringConverter();
    Bindings.bindBidirectional(taxTextField.textProperty(),addProductModel.getProductFx().taxProperty(), converter);
    Bindings.bindBidirectional(priceTextField.textProperty(),addProductModel.getProductFx().priceProperty(),converter);
    listener(flag1, taxTextField);
    listener(flag2, priceTextField);
  }

  private void listener(BooleanProperty flag, TextField textField) {
    textField.textProperty().addListener((observable, oldValue, newValue) -> {
      if(!newValue.equals("")) {
        try {
          Double.parseDouble(newValue);
          flag.setValue(false);
        } catch (Exception e) {
          flag.setValue(true);
        }
      }
    });
  }
}
