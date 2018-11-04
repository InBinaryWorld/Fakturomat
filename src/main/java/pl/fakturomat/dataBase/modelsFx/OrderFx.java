package pl.fakturomat.dataBase.modelsFx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class OrderFx {
  ObjectProperty <InvoiceFx> invoiceFx = new SimpleObjectProperty<>();
  ObjectProperty<ProductFx> productFx = new SimpleObjectProperty<>();
  DoubleProperty quantity = new SimpleDoubleProperty();

  public OrderFx() {
  }

  public InvoiceFx getInvoiceFx() {
    return invoiceFx.get();
  }

  public ObjectProperty<InvoiceFx> invoiceFxProperty() {
    return invoiceFx;
  }

  public void setInvoiceFx(InvoiceFx invoiceFx) {
    this.invoiceFx.set(invoiceFx);
  }

  public ProductFx getProductFx() {
    return productFx.get();
  }

  public ObjectProperty<ProductFx> productFxProperty() {
    return productFx;
  }

  public void setProductFx(ProductFx productFx) {
    this.productFx.set(productFx);
  }

  public double getQuantity() {
    return quantity.get();
  }

  public DoubleProperty quantityProperty() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity.set(quantity);
  }
}
