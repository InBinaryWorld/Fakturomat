package pl.fakturomat.tools.converters;

import pl.fakturomat.database.models.Order;
import pl.fakturomat.database.modelsfx.OrderFx;

public abstract class OrderConverter {
  /**
   * Converter.
   * @param order Order.
   * @return OrderFx.
   */
  public static OrderFx convertToOrderFx(Order order) {
    OrderFx orderFx = new OrderFx();
    orderFx.setName(order.getName());
    orderFx.setMeasure(order.getMeasure());
    orderFx.setPrice(order.getPrice());
    orderFx.setTax(order.getTax());
    orderFx.setInvoiceFx(InvoiceConverter.convertToInvoiceFx(order.getInvoice()));
    orderFx.setQuantity(order.getQuantity());
    return orderFx;
  }

  /**
   * Converter.
   * @param orderFx OrderFx.
   * @return Order.
   */
  public static Order convertToOrder(OrderFx orderFx) {
    Order order = new Order();
    order.setName(orderFx.getName());
    order.setMeasure(orderFx.getMeasure());
    order.setPrice(orderFx.getPrice());
    order.setTax(orderFx.getTax());
    order.setInvoice(InvoiceConverter.convertToInvoice(orderFx.getInvoiceFx()));
    order.setQuantity(orderFx.getQuantity());
    order.setAmount(orderFx.getAmount());
    return order;
  }
}
