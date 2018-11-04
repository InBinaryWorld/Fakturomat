package pl.fakturomat.dataBase.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SELLER")
public class Seller implements BaseModel {

  @DatabaseField(columnName = "SELLER_ID", generatedId = true, canBeNull = false)
  private int sellerID;

  @DatabaseField(columnName = "NAME", unique = true, canBeNull = false)
  private String name;

  @DatabaseField(columnName = "NIP", unique = true, canBeNull = false)
  private String nip;

  @DatabaseField(columnName = "POST_CODE", canBeNull = false)
  private String postCode;

  @DatabaseField(columnName = "CITY", canBeNull = false)
  private String city;

  @DatabaseField(columnName = "ADDRESS", canBeNull = false)
  private String address;

  @DatabaseField(columnName = "TELEPHONE_NR")
  private String phone;

  public Seller() {
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getSellerID() {
    return sellerID;
  }

  public void setSellerID(int sellerID) {
    this.sellerID = sellerID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNip() {
    return nip;
  }

  public void setNip(String nip) {
    this.nip = nip;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}

