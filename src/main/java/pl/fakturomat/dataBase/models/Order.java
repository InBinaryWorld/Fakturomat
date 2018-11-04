package pl.fakturomat.dataBase.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ORDER")
public class Order implements BaseModel {

  @DatabaseField(columnName = "INVOICE_ID", foreign = true ,foreignAutoRefresh = true)
  private Invoice invoice;

  @DatabaseField(columnName = "PRODUCT_ID", foreign = true, foreignAutoRefresh = true)
  private Product product;

  @DatabaseField(columnName = "QUANTITY")
  private double quantity;
}
