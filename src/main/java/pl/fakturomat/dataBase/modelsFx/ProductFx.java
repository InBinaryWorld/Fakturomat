package pl.fakturomat.dataBase.modelsFx;

import javafx.beans.property.*;

public class ProductFx {
  private IntegerProperty productId = new SimpleIntegerProperty();
  private StringProperty name = new SimpleStringProperty();
  private StringProperty measure = new SimpleStringProperty();
  private DoubleProperty price = new SimpleDoubleProperty();
  private DoubleProperty tax = new SimpleDoubleProperty();

  public ProductFx() {
  }

  public int getProductId() {
    return productId.get();
  }

  public IntegerProperty productIdProperty() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId.set(productId);
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

  @Override
  public String toString() {
    return getName();
  }
}
