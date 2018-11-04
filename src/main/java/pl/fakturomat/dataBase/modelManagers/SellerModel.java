package pl.fakturomat.dataBase.modelManagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.SellerDao;
import pl.fakturomat.dataBase.models.Seller;
import pl.fakturomat.dataBase.modelsFx.SellerFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.SellerConverter;

import java.util.List;

public class SellerModel {
   private static ObservableList<SellerFx> sellerFxList = FXCollections.observableArrayList();
  
  public void init() throws ApplicationException {
    SellerDao sellerDao = new SellerDao();
    List<Seller> sellerList = sellerDao.queryForAll();
    sellerFxList.clear();
    sellerList.forEach(seller -> sellerFxList.add(SellerConverter.convertToSellerFx(seller)));
  }

  public static ObservableList<SellerFx> getSellerFxList() {
    return sellerFxList;
  }
}
