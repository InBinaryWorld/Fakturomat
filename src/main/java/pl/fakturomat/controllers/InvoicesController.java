package pl.fakturomat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.fakturomat.dataBase.modelManagers.InvoicesModel;
import pl.fakturomat.dataBase.models.Invoice;
import pl.fakturomat.dataBase.modelsFx.InvoiceFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.DialogTools;

import java.time.LocalDate;

public class InvoicesController {

  @FXML
  private TableView<InvoiceFx> tableView;

  @FXML
  private TableColumn<InvoiceFx, Integer> idColumn;

  @FXML
  private TableColumn<InvoiceFx, String> sellerColumn;

  @FXML
  private TableColumn<InvoiceFx, String> clientColumn;

  @FXML
  private TableColumn<InvoiceFx, LocalDate> dateColumn;

  @FXML
  private Button showButton;

  private InvoicesModel invoicesModel =new InvoicesModel();


  public void initialize(){
    try {
      invoicesModel.init();
    } catch (ApplicationException e) {
      DialogTools.errorDialog(e.getMessage());
    }
    initTableView();
    initBindings();

  }

  private void initBindings() {
    showButton.disableProperty().bind(tableView.itemsProperty().isNull().or(tableView.getSelectionModel().selectedItemProperty().isNull()));
  }

  private void initTableView() {
    tableView.setItems(invoicesModel.getInvoiceFxList());
    idColumn.setCellValueFactory(cellData -> cellData.getValue().invoiceIdProperty().asObject());
    sellerColumn.setCellValueFactory(cellData -> cellData.getValue().getSellerFx().nameProperty());
    clientColumn.setCellValueFactory(cellData -> cellData.getValue().getClientFx().nameProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
  }

  @FXML
  void showAction() {
    DialogTools.showInvoice(tableView.getSelectionModel().getSelectedItem());
  }

}
