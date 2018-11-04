package pl.fakturomat.dataBase.modelManagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.fakturomat.dataBase.dao.SellerDao;
import pl.fakturomat.dataBase.models.Seller;
import pl.fakturomat.dataBase.modelsFx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.SellerConverter;

public class AddSellerModel {
  private ObjectProperty<pl.fakturomat.dataBase.modelsFx.SellerFx> SellerFx = new SimpleObjectProperty<>(new SellerFx());

  public AddSellerModel() {
  }

  public void saveSellerInDataBase() throws ApplicationException {
    SellerDao sellerDao = new SellerDao();
    Seller seller = SellerConverter.convertToSeller(getSellerFx());
    sellerDao.create(seller);
  }

  public SellerFx getSellerFx() {
    return SellerFx.get();
  }

  public ObjectProperty<SellerFx> sellerFxProperty() {
    return SellerFx;
  }

  public void setSellerFx(SellerFx sellerFx) {
    this.SellerFx.set(sellerFx);
  }
}
