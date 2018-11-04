package pl.fakturomat.dataBase.modelsFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SellerFx {
  private IntegerProperty sellerId = new SimpleIntegerProperty();
  private StringProperty name = new SimpleStringProperty();
  private StringProperty nip = new SimpleStringProperty();
  private StringProperty postCode = new SimpleStringProperty();
  private StringProperty city = new SimpleStringProperty();
  private StringProperty address = new SimpleStringProperty();
  private StringProperty phone = new SimpleStringProperty();

  public SellerFx() {
  }

  public int getSellerId() {
    return sellerId.get();
  }

  public IntegerProperty sellerIdProperty() {
    return sellerId;
  }

  public void setSellerId(int sellerId) {
    this.sellerId.set(sellerId);
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

  public String getNip() {
    return nip.get();
  }

  public StringProperty nipProperty() {
    return nip;
  }

  public void setNip(String nip) {
    this.nip.set(nip);
  }

  public String getPostCode() {
    return postCode.get();
  }

  public StringProperty postCodeProperty() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode.set(postCode);
  }

  public String getCity() {
    return city.get();
  }

  public StringProperty cityProperty() {
    return city;
  }

  public void setCity(String city) {
    this.city.set(city);
  }

  public String getAddress() {
    return address.get();
  }

  public StringProperty addressProperty() {
    return address;
  }

  public void setAddress(String address) {
    this.address.set(address);
  }

  public String getPhone() {
    return phone.get();
  }

  public StringProperty phoneProperty() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone.set(phone);
  }

  @Override
  public String toString() {
    return getName();
  }
}