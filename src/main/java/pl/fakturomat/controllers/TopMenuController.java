package pl.fakturomat.controllers;

import javafx.fxml.FXML;

public class TopMenuController {

  private static final String NEW_INVOICE_FXML = "/fxml/NewInvoice.fxml";
  private static final String SHOW_INVOICE_FXML = "/fxml/ShowInvoice.fxml";
  private static final String ADD_CLIENTS_FXML = "/fxml/Clients.fxml";
  private static final String ADD_SELLER_FXML = "/fxml/Sellers.fxml";
  private static final String PRODUCTS_FXML = "/fxml/Products.fxml";
  private MainController mainController;

  @FXML
  void NewInvoiceAction() {
    mainController.setCenter(NEW_INVOICE_FXML);
  }

  @FXML
  void ShowInvoiceAction() {
    mainController.setCenter(SHOW_INVOICE_FXML);
  }

  @FXML
  void addClientAction() {
    mainController.setCenter(ADD_CLIENTS_FXML);
  }

  @FXML
  void addSellerAction() {
    mainController.setCenter(ADD_SELLER_FXML);
  }

  @FXML
  void productsAction() {
    mainController.setCenter(PRODUCTS_FXML);
  }

  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }


}
