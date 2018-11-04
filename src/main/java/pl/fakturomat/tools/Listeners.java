package pl.fakturomat.tools;

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.TextField;

public abstract class Listeners {
  public static void listener(BooleanProperty flag, TextField textField) {
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
