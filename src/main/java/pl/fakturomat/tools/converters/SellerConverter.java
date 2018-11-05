package pl.fakturomat.tools.converters;

import pl.fakturomat.database.models.Seller;
import pl.fakturomat.database.modelsfx.SellerFx;

public abstract class SellerConverter {
  /**
   * Converter.
   * @param seller Seller.
   * @return SellerFx.
   */
  public static SellerFx convertToSellerFx(Seller seller) {
    SellerFx sellerFx = new SellerFx();
    sellerFx.setSellerId(seller.getSellerId());
    sellerFx.setName(seller.getName());
    sellerFx.setNip(seller.getNip());
    sellerFx.setPostCode(seller.getPostCode());
    sellerFx.setCity(seller.getCity());
    sellerFx.setAddress(seller.getAddress());
    sellerFx.setPhone(seller.getPhone());
    return sellerFx;
  }

  /**
   * Converter.
   * @param sellerFx SellerFx.
   * @return Seller.
   */
  public static Seller convertToSeller(SellerFx sellerFx) {
    Seller seller = new Seller();
    seller.setSellerId(sellerFx.getSellerId());
    seller.setName(sellerFx.getName());
    seller.setNip(sellerFx.getNip());
    seller.setPostCode(sellerFx.getPostCode());
    seller.setCity(sellerFx.getCity());
    seller.setAddress(sellerFx.getAddress());
    seller.setPhone(sellerFx.getPhone());
    return seller;
  }


}
