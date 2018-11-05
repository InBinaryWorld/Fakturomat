package pl.fakturomat.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.fakturomat.controllers.AddOrderController;
import pl.fakturomat.controllers.ShowInvoiceController;
import pl.fakturomat.database.modelmanagers.NewInvoiceModel;
import pl.fakturomat.database.modelsfx.InvoiceFx;

import java.io.IOException;
import java.util.Optional;

public class DialogTools {

  private static final String ADD_CLIENT_FXML = "/fxml/AddClient.fxml";
  private static final String ADD_SELLER_FXML = "/fxml/AddSeller.fxml";
  private static final String ADD_PRODUCT_FXML = "/fxml/AddProduct.fxml";
  private static final String ADD_ORDER_FXML = "/fxml/AddOrder.fxml";
  private static final String SHOW_INVOICE_FXML = "/fxml/ShowInvoice.fxml";

  /**
   * Dialog.
   */
  public static void dialogAboutApplication() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("O Programie");
    alert.setHeaderText("Fakturomat 1.0");
    alert.setContentText("Program do wystawiania faktur.");
    alert.showAndWait();
  }

  /**
   * Dialog.
   *
   * @return optional.
   */
  public static Optional<ButtonType> confirmationDialog() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Wyjdź");
    alert.setHeaderText("Czy na pewno chcesz opuścić Fakturomat?");
    ButtonType yesButton = ButtonTypes.YES;
    ButtonType noButton = ButtonTypes.NO;
    alert.getButtonTypes().setAll(noButton, yesButton);
    return alert.showAndWait();
  }

  /**
   * dilog.
   *
   * @param error Error.
   */
  public static void errorDialog(String error) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Błąd");
    alert.setHeaderText("Uwaga! Błąd!");
    TextArea textArea = new TextArea(error);
    textArea.setEditable(false);
    alert.getDialogPane().setContent(textArea);
    alert.showAndWait();
  }

  public static void addClientDialog() {
    addDialog(ADD_CLIENT_FXML, "Dodaj klienta");
  }

  public static void addSellerDialog() {
    addDialog(ADD_SELLER_FXML, "Dodaj sprzedawcę");
  }

  public static void addProductDialog() {
    addDialog(ADD_PRODUCT_FXML, "Dodaj produkt");
  }

  private static void addDialog(String patch, String title) {
    Pane pane = FxmlTools.fxmlLoader(patch);
    assert pane != null;
    Scene scene = new Scene(pane);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setResizable(false);
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle(title);
    stage.showAndWait();
  }

  /**
   * Dialog.
   * @param newInvoiceModel In.
   */
  public static void addOrderDialog(NewInvoiceModel newInvoiceModel) {
    FXMLLoader loader = new FXMLLoader(FxmlTools.class.getResource(ADD_ORDER_FXML));
    Pane pane;
    try {
      pane = loader.load();
      AddOrderController orderController = loader.getController();
      orderController.passNewInvoiceModel(newInvoiceModel);
      Scene scene = new Scene(pane);
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.setResizable(false);
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Dodaj Produkt");
      stage.showAndWait();
    } catch (IOException ee1) {
      errorDialog(ee1.getMessage());
    }
  }

  /**
   * Dialog.
   * @param invoiceFx InvoiceFx.
   */
  public static void showInvoice(InvoiceFx invoiceFx) {
    FXMLLoader loader = new FXMLLoader(FxmlTools.class.getResource(SHOW_INVOICE_FXML));
    Pane pane;
    try {
      pane = loader.load();
      ShowInvoiceController showInvoiceController = loader.getController();
      showInvoiceController.passInvoiceFx(invoiceFx);
      Scene scene = new Scene(pane);
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.setResizable(false);
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Faktura");
      stage.showAndWait();
    } catch (IOException ee1) {
      errorDialog(ee1.getMessage());

    }
  }
}
