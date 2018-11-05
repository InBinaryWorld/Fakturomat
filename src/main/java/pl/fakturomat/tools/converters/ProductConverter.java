package pl.fakturomat.tools.converters;

import pl.fakturomat.database.models.Product;
import pl.fakturomat.database.modelsfx.ProductFx;

public abstract class ProductConverter {
  /**
   * Converter.
   * @param product Product.
   * @return ProductFx.
   */
  public static ProductFx convertToProductFx(Product product) {
    ProductFx productFx = new ProductFx();
    productFx.setProductId(product.getProductId());
    productFx.setName(product.getName());
    productFx.setMeasure(product.getMeasure());
    productFx.setPrice(product.getPrice());
    productFx.setTax(product.getTax());
    return productFx;
  }

  /**
   * Converter.
   * @param productFx productFx.
   * @return Product.
   */
  public static Product convertToProduct(ProductFx productFx) {
    Product product = new Product();
    product.setProductId(productFx.getProductId());
    product.setName(productFx.getName());
    product.setMeasure(productFx.getMeasure());
    product.setPrice(productFx.getPrice());
    product.setTax(productFx.getTax());
    return product;
  }

}
