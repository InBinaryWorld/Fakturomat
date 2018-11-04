package pl.fakturomat.dataBase.modelManagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.InvoiceDao;
import pl.fakturomat.dataBase.models.Invoice;
import pl.fakturomat.dataBase.modelsFx.InvoiceFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.InvoiceConventer;

import java.util.List;

public class InvoicesModel {
  private ObservableList<InvoiceFx> invoiceFxList = FXCollections.observableArrayList();

  public void init() throws ApplicationException {
    InvoiceDao invoiceDao = new InvoiceDao();
    List<Invoice> invoiceList = invoiceDao.queryForAll();
    invoiceFxList.clear();
    invoiceList.forEach(invoice -> invoiceFxList.add(InvoiceConventer.convertToInvoiceFx(invoice)));
  }

  public ObservableList<InvoiceFx> getInvoiceFxList() {
    return invoiceFxList;
  }

  public void setInvoiceFxList(ObservableList<InvoiceFx> invoiceFxList) {
    this.invoiceFxList = invoiceFxList;
  }
}
