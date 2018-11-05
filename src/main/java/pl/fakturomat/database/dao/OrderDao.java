package pl.fakturomat.database.dao;

import pl.fakturomat.database.models.Order;

public class OrderDao extends CommonDao<Order> {
  public OrderDao() {
    super(Order.class);
  }
}
