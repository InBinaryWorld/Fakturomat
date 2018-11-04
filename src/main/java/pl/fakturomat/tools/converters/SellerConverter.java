package pl.fakturomat.tools.converters;

import pl.fakturomat.dataBase.models.Seller;
import pl.fakturomat.dataBase.modelsFx.SellerFx;

public abstract class SellerConverter {
  public static SellerFx convertToSellerFx(Seller seller){
    SellerFx sellerFx = new SellerFx();
    sellerFx.setSellerId(seller.getSellerID());
    sellerFx.setName(seller.getName());
    sellerFx.setNip(seller.getNip());
    sellerFx.setPostCode(seller.getPostCode());
    sellerFx.setCity(seller.getCity());
    sellerFx.setAddress(seller.getAddress());
    sellerFx.setPhone(seller.getPhone());
    return sellerFx;
  }

  public static Seller convertToSeller(SellerFx sellerFx){
    Seller seller = new Seller();
    seller.setSellerID(sellerFx.getSellerId());
    seller.setName(sellerFx.getName());
    seller.setNip(sellerFx.getNip());
    seller.setPostCode(sellerFx.getPostCode());
    seller.setCity(sellerFx.getCity());
    seller.setAddress(sellerFx.getAddress());
    seller.setPhone(sellerFx.getPhone());
    return seller;
  }


}
