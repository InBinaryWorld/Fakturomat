package pl.fakturomat.tools;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogTools {

  public static final String ADD_CLIENT_FXML = "/fxml/AddClient.fxml";
  public static final String ADD_SELLER_FXML = "/fxml/AddSeller.fxml";

  public static void dialogAboutApplication() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("O Programie");
    alert.setHeaderText("Fakturomat 1.0");
    alert.setContentText("Program do wystawiania faktur.");
    alert.showAndWait();
  }

  public static Optional<ButtonType> confirmationDialog() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Wyjdź");
    alert.setHeaderText("Czy na pewno chcesz opuścić Fakturomat?");
    ButtonType yesButton = ButtonTypes.YES;
    ButtonType noButton = ButtonTypes.NO;
    alert.getButtonTypes().setAll(noButton, yesButton);
    Optional<ButtonType> result = alert.showAndWait();
    return result;
  }

  public static void errorDialog(String error) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Błąd");
    alert.setHeaderText("Uwaga! Błąd!");

    TextArea textArea = new TextArea(error);
    textArea.setEditable(false);
    alert.getDialogPane().setContent(textArea);
    alert.showAndWait();
  }

  public static void addClientDialog(){
    addDialog(ADD_CLIENT_FXML, "Dodaj klienta");
  }

  public static void addSellerDialog() {
    addDialog(ADD_SELLER_FXML, "Dodaj sprzedawcę");
  }

  public static void addProductDialog() {
    addDialog("/fxml/AddProduct.fxml", "Dodaj produkt");
  }

  private static void addDialog(String s, String s2) {
    Pane pane = FxmlTools.fxmlLoader(s);
    Scene scene = new Scene(pane);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setResizable(false);
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle(s2);
    stage.showAndWait();
  }
}
