package pl.fakturomat.dataBase.dao;

import pl.fakturomat.dataBase.models.Product;

public class ProductDao extends CommonDao<Product>{
  public ProductDao() {
    super(Product.class);
  }
}
