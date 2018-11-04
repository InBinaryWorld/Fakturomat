package pl.fakturomat.dataBase.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ORDER")
public class Order implements BaseModel {

  @DatabaseField(columnName = "ORDER_ID",generatedId = true ,unique = true)
  private int id;

  @DatabaseField(columnName = "INVOICE_ID", foreign = true ,foreignAutoRefresh = true ,uniqueCombo = true)
  private Invoice invoice;

  @DatabaseField(columnName = "NAME",uniqueCombo = true)
  private String name;

  @DatabaseField(columnName = "UNIT_OF_MEASURE")
  private String measure;

  @DatabaseField(columnName = "PRICE")
  private double price;

  @DatabaseField(columnName = "TAX")
  private double tax;

  @DatabaseField(columnName = "QUANTITY")
  private double quantity;

  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMeasure() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure = measure;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }
}
