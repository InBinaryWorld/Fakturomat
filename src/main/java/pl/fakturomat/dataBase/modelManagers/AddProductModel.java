package pl.fakturomat.dataBase.modelManagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.fakturomat.dataBase.dao.ProductDao;
import pl.fakturomat.dataBase.models.Product;
import pl.fakturomat.dataBase.modelsFx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ProductConverter;

public class AddProductModel {
  private ObjectProperty<ProductFx> productFx = new SimpleObjectProperty<>(new ProductFx());

  public AddProductModel() {
  }

  public void saveProductInDataBase() throws ApplicationException {
    ProductDao productDao =  new ProductDao();
    Product product = ProductConverter.convertToProduct(getProductFx());
    productDao.create(product);
  }

  public ProductFx getProductFx() {
    return productFx.get();
  }

  public ObjectProperty<ProductFx> productFxProperty() {
    return productFx;
  }

  public void setProductFx(ProductFx productFx) {
    this.productFx.set(productFx);
  }
}
