package pl.fakturomat.database.modelmanagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.database.dao.InvoiceDao;
import pl.fakturomat.database.dao.OrderDao;
import pl.fakturomat.database.models.Invoice;
import pl.fakturomat.database.models.Order;
import pl.fakturomat.database.modelsfx.InvoiceFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.InvoiceConverter;

import java.sql.SQLException;
import java.util.List;

public class InvoicesModel {
  private ObservableList<InvoiceFx> invoiceFxList = FXCollections.observableArrayList();

  /**
   * Init.
   * @throws ApplicationException Error.
   */
  public void init() throws ApplicationException {
    InvoiceDao invoiceDao = new InvoiceDao();
    List<Invoice> invoiceList = invoiceDao.queryForAll();
    invoiceFxList.clear();
    invoiceList.forEach(invoice -> invoiceFxList.add(InvoiceConverter.convertToInvoiceFx(invoice)));
  }

  public ObservableList<InvoiceFx> getInvoiceFxList() {
    return invoiceFxList;
  }

  public void setInvoiceFxList(ObservableList<InvoiceFx> invoiceFxList) {
    this.invoiceFxList = invoiceFxList;
  }

  /**
   * Delete.
   * @param invoiceFx invoiceFx.
   * @throws ApplicationException Error.
   * @throws SQLException Error.
   */
  public void deleteInvoice(InvoiceFx invoiceFx) throws ApplicationException, SQLException {
    OrderDao orderDao = new OrderDao();
    List<Order> orders = orderDao.getDao().queryBuilder()
            .where().eq("INVOICE_ID", invoiceFx.getInvoiceId()).query();
    for (Order order : orders) {
      orderDao.deleteById(order.getId());
    }
    InvoiceDao invoiceDao = new InvoiceDao();
    invoiceDao.deleteById(invoiceFx.getInvoiceId());
    init();
  }
}
