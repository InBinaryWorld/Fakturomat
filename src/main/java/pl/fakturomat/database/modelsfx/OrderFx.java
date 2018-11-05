package pl.fakturomat.database.modelsfx;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrderFx {
  private ObjectProperty<InvoiceFx> invoiceFx = new SimpleObjectProperty<>();
  private DoubleProperty quantity = new SimpleDoubleProperty();
  private StringProperty name = new SimpleStringProperty();
  private StringProperty measure = new SimpleStringProperty();
  private DoubleProperty price = new SimpleDoubleProperty();
  private DoubleProperty tax = new SimpleDoubleProperty();
  private DoubleProperty amount = new SimpleDoubleProperty();

  /**
   * Constructor.
   */
  public OrderFx() {
    DoubleBinding doubleBinding = price.multiply(quantity)
            .add(price.multiply(quantity).multiply(tax).divide(100));

    DoubleBinding db = new DoubleBinding() {

      {
        super.bind(doubleBinding);
      }

      @Override
      protected double computeValue() {
        return ((double) ((int) (doubleBinding.get() * 100))) / 100;
      }
    };
    amount.bind(db);

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

  public double getAmount() {
    return amount.get();
  }

  public DoubleProperty amountProperty() {
    return amount;
  }

  public String getName() {
    return name.get();
  }

  public StringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getMeasure() {
    return measure.get();
  }

  public StringProperty measureProperty() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure.set(measure);
  }

  public double getPrice() {
    return price.get();
  }

  public DoubleProperty priceProperty() {
    return price;
  }

  public void setPrice(double price) {
    this.price.set(price);
  }

  public double getTax() {
    return tax.get();
  }

  public DoubleProperty taxProperty() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax.set(tax);
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
