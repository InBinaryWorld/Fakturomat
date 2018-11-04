package pl.fakturomat.dataBase.modelManagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.ProductDao;
import pl.fakturomat.dataBase.models.Product;
import pl.fakturomat.dataBase.modelsFx.OrderFx;
import pl.fakturomat.dataBase.modelsFx.ProductFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ProductConverter;

import java.util.List;

public class AddOrderModel {
  private ObjectProperty<OrderFx> orderFx = new SimpleObjectProperty<>(new OrderFx());
  private ObservableList<ProductFx> productFxList = FXCollections.observableArrayList();
  private NewInvoiceModel newInvoiceModel;

  public AddOrderModel() {
  }

  public void saveOrderInList() throws ApplicationException {
    newInvoiceModel.getOrderFxList().add(getOrderFx());
  }

  public void init() throws ApplicationException {
    ProductDao productDao = new ProductDao();
    List<Product> products = productDao.queryForAll();
    productFxList.clear();
    products.forEach(product -> productFxList.add(ProductConverter.convertToProductFx(product)));
  }

  public ObservableList<ProductFx> getProductFxList() {
    return productFxList;
  }

  public void setProductFxList(ObservableList<ProductFx> productFxList) {
    this.productFxList = productFxList;
  }

  public NewInvoiceModel getNewInvoiceModel() {
    return newInvoiceModel;
  }

  public void setNewInvoiceModel(NewInvoiceModel newInvoiceModel) {
    this.newInvoiceModel = newInvoiceModel;
  }

  public OrderFx getOrderFx() {
    return orderFx.get();
  }

  public ObjectProperty<OrderFx> orderFxProperty() {
    return orderFx;
  }

  public void setOrderFx(OrderFx orderFx) {
    this.orderFx.set(orderFx);
  }
}
