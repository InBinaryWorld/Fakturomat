package pl.fakturomat.database.dao;

import pl.fakturomat.database.models.Product;

public class ProductDao extends CommonDao<Product> {
  public ProductDao() {
    super(Product.class);
  }
}
