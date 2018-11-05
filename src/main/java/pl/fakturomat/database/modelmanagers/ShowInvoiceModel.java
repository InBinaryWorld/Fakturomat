package pl.fakturomat.database.modelmanagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.database.dao.OrderDao;
import pl.fakturomat.database.models.Order;
import pl.fakturomat.database.modelsfx.InvoiceFx;
import pl.fakturomat.database.modelsfx.OrderFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.OrderConverter;

import java.sql.SQLException;
import java.util.List;

public class ShowInvoiceModel {
  private ObservableList<OrderFx> orderFxList = FXCollections.observableArrayList();
  private InvoiceFx invoiceFx;
  private double totalAmount;


  /**
   * init.
   * @param invoiceFx invoiceFx.
   * @throws ApplicationException Error.
   * @throws SQLException Error.
   */
  public void init(InvoiceFx invoiceFx) throws ApplicationException, SQLException {
    this.invoiceFx = invoiceFx;
    OrderDao orderDao = new OrderDao();
    List<Order> list = orderDao.getDao().queryBuilder()
            .where().eq("INVOICE_ID", invoiceFx.getInvoiceId()).query();
    orderFxList.clear();
    list.forEach(order -> orderFxList.add(OrderConverter.convertToOrderFx(order)));

    totalAmount = 0;
    orderFxList.forEach(orderFx -> totalAmount += orderFx.getAmount());
  }

  public ObservableList<OrderFx> getOrderFxList() {
    return orderFxList;
  }

  public void setOrderFxList(ObservableList<OrderFx> orderFxList) {
    this.orderFxList = orderFxList;
  }

  public InvoiceFx getInvoiceFx() {
    return invoiceFx;
  }

  public void setInvoiceFx(InvoiceFx invoiceFx) {
    this.invoiceFx = invoiceFx;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }
}

