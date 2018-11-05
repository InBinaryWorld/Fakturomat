package pl.fakturomat.database.modelmanagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.database.dao.ProductDao;
import pl.fakturomat.database.models.Product;
import pl.fakturomat.database.modelsfx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ProductConverter;

import java.util.List;

public class ProductModel {
  private static ObservableList<ProductFx> productFxList = FXCollections.observableArrayList();

  /**
   * init.
   * @throws ApplicationException Error.
   */
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
