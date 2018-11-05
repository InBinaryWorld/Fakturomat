package pl.fakturomat.database.modelmanagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.fakturomat.database.dao.SellerDao;
import pl.fakturomat.database.models.Seller;
import pl.fakturomat.database.modelsfx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.SellerConverter;

public class AddSellerModel {
  private ObjectProperty<SellerFx> sellerFx = new SimpleObjectProperty<>(new SellerFx());

  public AddSellerModel() {
  }

  /**
   * Save.
   * @throws ApplicationException Error.
   */
  public void saveSellerInDataBase() throws ApplicationException {
    SellerDao sellerDao = new SellerDao();
    Seller seller = SellerConverter.convertToSeller(getSellerFx());
    sellerDao.create(seller);
  }

  public SellerFx getSellerFx() {
    return sellerFx.get();
  }

  public ObjectProperty<SellerFx> sellerFxProperty() {
    return sellerFx;
  }

  public void setSellerFx(SellerFx sellerFx) {
    this.sellerFx.set(sellerFx);
  }
}
