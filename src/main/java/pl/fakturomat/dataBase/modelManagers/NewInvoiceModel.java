package pl.fakturomat.dataBase.modelManagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.ClientDao;
import pl.fakturomat.dataBase.dao.InvoiceDao;
import pl.fakturomat.dataBase.dao.OrderDao;
import pl.fakturomat.dataBase.dao.SellerDao;
import pl.fakturomat.dataBase.models.Client;
import pl.fakturomat.dataBase.models.Invoice;
import pl.fakturomat.dataBase.models.Seller;
import pl.fakturomat.dataBase.modelsFx.ClientFx;
import pl.fakturomat.dataBase.modelsFx.InvoiceFx;
import pl.fakturomat.dataBase.modelsFx.OrderFx;
import pl.fakturomat.dataBase.modelsFx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ClientConverter;
import pl.fakturomat.tools.converters.InvoiceConventer;
import pl.fakturomat.tools.converters.OrderConventer;
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

  public void saveInDatabase() throws ApplicationException, SQLException {
    InvoiceDao invoiceDao = new InvoiceDao();
    invoiceDao.create(InvoiceConventer.convertToInvoice(getInvoiceFx()));

    List<Invoice> list = invoiceDao.getDao().queryBuilder().orderBy("INVOICE_ID", false).limit((long) 1).query();
    getInvoiceFx().setInvoiceId(list.get(0).getId());

    OrderDao orderDao = new OrderDao();
    for (OrderFx orderFx:orderFxList) {
      orderDao.create(OrderConventer.convertToOrder(orderFx));
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
