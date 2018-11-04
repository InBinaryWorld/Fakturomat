package pl.fakturomat.dataBase.modelManagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.ClientDao;
import pl.fakturomat.dataBase.dao.SellerDao;
import pl.fakturomat.dataBase.models.Client;
import pl.fakturomat.dataBase.models.Seller;
import pl.fakturomat.dataBase.modelsFx.ClientFx;
import pl.fakturomat.dataBase.modelsFx.InvoiceFx;
import pl.fakturomat.dataBase.modelsFx.OrderFx;
import pl.fakturomat.dataBase.modelsFx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ClientConverter;
import pl.fakturomat.tools.converters.SellerConverter;

import java.util.List;

public class NewInvoiceModel {

  private static ObservableList<ClientFx> clientFxList = FXCollections.observableArrayList();
  private static ObservableList<SellerFx> sellerFxList = FXCollections.observableArrayList();
  private static ObservableList<OrderFx> orderFxList = FXCollections.observableArrayList();
  private static ObjectProperty<InvoiceFx> invoiceFx = new SimpleObjectProperty<>(new InvoiceFx());

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

  public ObservableList<ClientFx> getClientFxList() {
    return clientFxList;
  }

  public void setClientFxList(ObservableList<ClientFx> clientFxList) {
    NewInvoiceModel.clientFxList = clientFxList;
  }

  public ObservableList<SellerFx> getSellerFxList() {
    return sellerFxList;
  }

  public void setSellerFxList(ObservableList<SellerFx> sellerFxList) {
    NewInvoiceModel.sellerFxList = sellerFxList;
  }

  public ObservableList<OrderFx> getOrderFxList() {
    return orderFxList;
  }

  public void setOrderFxList(ObservableList<OrderFx> orderFxList) {
    NewInvoiceModel.orderFxList = orderFxList;
  }

  public InvoiceFx getInvoiceFx() {
    return invoiceFx.get();
  }

  public ObjectProperty<InvoiceFx> invoiceFxProperty() {
    return invoiceFx;
  }

  public void setInvoiceFx(InvoiceFx invoiceFx) {
    NewInvoiceModel.invoiceFx.set(invoiceFx);
  }
}
