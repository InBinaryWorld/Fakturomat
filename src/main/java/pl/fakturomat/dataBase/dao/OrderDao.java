package pl.fakturomat.dataBase.dao;

import pl.fakturomat.dataBase.models.Order;

public class OrderDao extends CommonDao <Order> {
  public OrderDao() {
    super(Order.class);
  }
}
