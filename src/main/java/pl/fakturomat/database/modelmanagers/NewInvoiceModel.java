package pl.fakturomat.database.modelmanagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.database.dao.ClientDao;
import pl.fakturomat.database.dao.InvoiceDao;
import pl.fakturomat.database.dao.OrderDao;
import pl.fakturomat.database.dao.SellerDao;
import pl.fakturomat.database.models.Client;
import pl.fakturomat.database.models.Invoice;
import pl.fakturomat.database.models.Seller;
import pl.fakturomat.database.modelsfx.ClientFx;
import pl.fakturomat.database.modelsfx.InvoiceFx;
import pl.fakturomat.database.modelsfx.OrderFx;
import pl.fakturomat.database.modelsfx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ClientConverter;
import pl.fakturomat.tools.converters.InvoiceConverter;
import pl.fakturomat.tools.converters.OrderConverter;
import pl.fakturomat.tools.converters.SellerConverter;

import java.sql.SQLException;
import java.util.List;

public class NewInvoiceModel {

  private ObservableList<ClientFx> clientFxList = FXCollections.observableArrayList();
  private ObservableList<SellerFx> sellerFxList = FXCollections.observableArrayList();
  private ObservableList<OrderFx> orderFxList = FXCollections.observableArrayList();
  private ObjectProperty<InvoiceFx> invoiceFx = new SimpleObjectProperty<>(new InvoiceFx());

  public NewInvoiceModel() {
  }

  /**
   * Init.
   * @throws ApplicationException Error.
   */
  public void init() throws ApplicationException {
    ClientDao clientDao = new ClientDao();
    List<Client> clientList = clientDao.queryForAll();
    clientFxList.clear();
    clientList.forEach(client -> clientFxList.add(ClientConverter.convertToClientFx(client)));

    SellerDao sellerDao = new SellerDao();
    List<Seller> sellerList = sellerDao.queryForAll();
    sellerFxList.clear();
    sellerList.forEach(seller -> sellerFxList.add(SellerConverter.convertToSellerFx(seller)));

  }

  /**
   * Save.
   * @throws ApplicationException Error.
   * @throws SQLException Error.
   */
  public void saveInDatabase() throws ApplicationException, SQLException {
    InvoiceDao invoiceDao = new InvoiceDao();
    invoiceDao.create(InvoiceConverter.convertToInvoice(getInvoiceFx()));

    List<Invoice> list = invoiceDao.getDao().queryBuilder()
            .orderBy("INVOICE_ID", false).limit((long) 1).query();
    getInvoiceFx().setInvoiceId(list.get(0).getId());

    OrderDao orderDao = new OrderDao();
    for (OrderFx orderFx : orderFxList) {
      orderDao.create(OrderConverter.convertToOrder(orderFx));
    }
  }

  public ObservableList<ClientFx> getClientFxList() {
    return clientFxList;
  }


  public ObservableList<SellerFx> getSellerFxList() {
    return sellerFxList;
  }


  public ObservableList<OrderFx> getOrderFxList() {
    return orderFxList;
  }

  public InvoiceFx getInvoiceFx() {
    return invoiceFx.get();
  }

  public ObjectProperty<InvoiceFx> invoiceFxProperty() {
    return invoiceFx;
  }

}
