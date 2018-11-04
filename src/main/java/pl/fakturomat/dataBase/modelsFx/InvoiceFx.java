package pl.fakturomat.dataBase.modelsFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class InvoiceFx {

  private IntegerProperty invoiceId = new SimpleIntegerProperty();
  private ObjectProperty<ClientFx> clientFx = new SimpleObjectProperty<>();
  private ObjectProperty<SellerFx> sellerFx = new SimpleObjectProperty<>();
  private ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

  public InvoiceFx() {
  }

  public int getInvoiceId() {
    return invoiceId.get();
  }

  public IntegerProperty invoiceIdProperty() {
    return invoiceId;
  }

  public void setInvoiceId(int invoiceId) {
    this.invoiceId.set(invoiceId);
  }

  public ClientFx getClientFx() {
    return clientFx.get();
  }

  public ObjectProperty<ClientFx> clientFxProperty() {
    return clientFx;
  }

  public void setClientFx(ClientFx clientFx) {
    this.clientFx.set(clientFx);
  }

  public SellerFx getSellerFx() {
    return sellerFx.get();
  }

  public ObjectProperty<SellerFx> sellerFxProperty() {
    return sellerFx;
  }

  public void setSellerFx(SellerFx sellerFx) {
    this.sellerFx.set(sellerFx);
  }

  public LocalDate getDate() {
    return date.get();
  }

  public ObjectProperty<LocalDate> dateProperty() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date.set(date);
  }

  @Override
  public String toString() {
    return getInvoiceId()+ " - " + getDate();
  }
}
