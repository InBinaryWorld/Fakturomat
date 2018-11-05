package pl.fakturomat.database.dao;

import pl.fakturomat.database.models.Seller;

public class SellerDao extends CommonDao<Seller> {
  public SellerDao() {
    super(Seller.class);
  }
}
