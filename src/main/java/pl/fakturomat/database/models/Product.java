package pl.fakturomat.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PRODUCTS")
public class Product implements BaseModel {

  @DatabaseField(columnName = "PRODUCT_ID", generatedId = true, canBeNull = false)
  private int productId;

  @DatabaseField(columnName = "NAME", canBeNull = false)
  private String name;

  @DatabaseField(columnName = "UNIT_OF_MEASURE", canBeNull = false)
  private String measure;

  @DatabaseField(columnName = "PRICE", canBeNull = false)
  private double price;

  @DatabaseField(columnName = "TAX", canBeNull = false)
  private double tax;

  public Product() {
  }

  public String getMeasure() {
    return measure;
  }

  public void setMeasure(String measure) {
    this.measure = measure;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}
