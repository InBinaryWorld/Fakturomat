package pl.fakturomat.dataBase.modelManagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.ProductDao;
import pl.fakturomat.dataBase.models.Product;
import pl.fakturomat.dataBase.modelsFx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ProductConverter;

import java.util.List;

public class ProductModel {
   private static ObservableList<ProductFx> productFxList = FXCollections.observableArrayList();

  public static void init() throws ApplicationException {
    ProductDao productDao = new ProductDao();
    List<Product> productList = productDao.queryForAll();
    productFxList.clear();
    productList.forEach(product -> productFxList.add(ProductConverter.convertToProductFx(product)));
  }

  public static ObservableList<ProductFx> getClientFxList() {
    return productFxList;
  }
}
