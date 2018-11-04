package pl.fakturomat.dataBase.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "INVOICE")
public class Invoice implements BaseModel {

  @DatabaseField(columnName = "INVOICE_ID",generatedId = true ,unique = true)
  private int id;

  @DatabaseField(columnName = "SELLER_ID" ,foreign = true, canBeNull = false , foreignAutoRefresh = true)
  private Seller seller;

  @DatabaseField(columnName = "CLIENT_ID" ,foreign = true, canBeNull = false ,foreignAutoRefresh = true)
  private Client client;

  @DatabaseField(columnName = "DATE" ,canBeNull = false, dataType = DataType.DATE_STRING, format = "yyyy-MM-dd")
  private Date data;

  public Invoice() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Seller getSeller() {
    return seller;
  }

  public void setSeller(Seller seller) {
    this.seller = seller;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }
}
