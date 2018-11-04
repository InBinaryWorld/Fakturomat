package pl.fakturomat.tools.converters;

import pl.fakturomat.dataBase.models.Product;
import pl.fakturomat.dataBase.models.Seller;
import pl.fakturomat.dataBase.modelsFx.ProductFx;
import pl.fakturomat.dataBase.modelsFx.SellerFx;

public abstract class ProductConverter {
  public static ProductFx convertToProductFx(Product product){
    ProductFx productFx = new ProductFx();
    productFx.setProductId(product.getProductId());
    productFx.setName(product.getName());
    productFx.setMeasure(product.getMeasure());
    productFx.setPrice(product.getPrice());
    productFx.setTax(product.getTax());
    return productFx;
  }

    public static Product convertToProduct(ProductFx productFX){
      Product product = new Product();
      product.setProductId(productFX.getProductId());
      product.setName(productFX.getName());
      product.setMeasure(productFX.getMeasure());
      product.setPrice(productFX.getPrice());
      product.setTax(productFX.getTax());
      return product;
    }

}
