package pl.fakturomat.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ORDER")
public class Order implements BaseModel {

  @DatabaseField(columnName = "ORDER_ID", generatedId = true, unique = true, canBeNull = false)
  private int id;

  @DatabaseField(columnName = "INVOICE_ID", foreign = true,
          foreignAutoRefresh = true, canBeNull = false)
  private Invoice invoice;

  @DatabaseField(columnName = "NAME", canBeNull = false)
  private String name;

  @DatabaseField(columnName = "QUANTITY", canBeNull = false)
  private double quantity;

  @DatabaseField(columnName = "UNIT_OF_MEASURE", canBeNull = false)
  private String measure;

  @DatabaseField(columnName = "PRICE", canBeNull = false)
  private double price;

  @DatabaseField(columnName = "TAX", canBeNull = false)
  private double tax;

  @DatabaseField(columnName = "AMOUNT", canBeNull = false)
  private double amount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

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
