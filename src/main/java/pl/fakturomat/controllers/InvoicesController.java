package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.database.modelmanagers.InvoicesModel;
import pl.fakturomat.database.modelsfx.InvoiceFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

import java.sql.SQLException;
import java.time.LocalDate;

public class InvoicesController {

  @FXML
  public Button deleteBtn;
  @FXML
  private TableView<InvoiceFx> tableView;
  @FXML
  private TableColumn<InvoiceFx, Integer> idClm;
  @FXML
  private TableColumn<InvoiceFx, String> sellerClm;
  @FXML
  private TableColumn<InvoiceFx, String> clientClm;
  @FXML
  private TableColumn<InvoiceFx, LocalDate> dateClm;
  @FXML
  private Button showBtn;

  private InvoicesModel invoicesModel = new InvoicesModel();

  /**
   * Initialize.
   */
  public void initialize() {
    try {
      invoicesModel.init();
    } catch (ApplicationException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
    initTableView();
    initBindings();

  }

  private void initBindings() {
    showBtn.disableProperty().bind(tableView.itemsProperty().isNull().or(
            tableView.getSelectionModel().selectedItemProperty().isNull()));
    deleteBtn.disableProperty().bind(tableView.itemsProperty().isNull().or(
            tableView.getSelectionModel().selectedItemProperty().isNull()));
  }

  private void initTableView() {
    tableView.setItems(invoicesModel.getInvoiceFxList());
    idClm.setCellValueFactory(cellData -> cellData.getValue().invoiceIdProperty().asObject());
    sellerClm.setCellValueFactory(cellData -> cellData.getValue().getSellerFx().nameProperty());
    clientClm.setCellValueFactory(cellData -> cellData.getValue().getClientFx().nameProperty());
    dateClm.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
  }

  /**
   * Show Invoice.
   */
  @FXML
  void showAction() {
    DialogTools.showInvoice(tableView.getSelectionModel().getSelectedItem());
  }

  /**
   * Delete invoice.
   */
  public void deleteAction() {
    try {
      invoicesModel.deleteInvoice(tableView.getSelectionModel().getSelectedItem());
    } catch (ApplicationException | SQLException ee1) {
      DialogTools.errorDialog(ee1.getMessage());
    }
  }
}
