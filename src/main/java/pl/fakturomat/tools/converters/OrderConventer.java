package pl.fakturomat.tools.converters;

import pl.fakturomat.dataBase.models.Order;
import pl.fakturomat.dataBase.modelsFx.OrderFx;

public abstract class OrderConventer {
  public static OrderFx convertToOrderFx(Order order){
    OrderFx orderFx = new OrderFx();
    orderFx.setName(order.getName());
    orderFx.setMeasure(order.getMeasure());
    orderFx.setPrice(order.getPrice());
    orderFx.setTax(order.getTax());
    orderFx.setInvoiceFx(InvoiceConventer.convertToInvoiceFx(order.getInvoice()));
    orderFx.setQuantity(order.getQuantity());
    return orderFx;
  }

  public static Order convertToProduct(OrderFx orderFx){
    Order order = new Order();
    order.setName(orderFx.getName());
    order.setMeasure(orderFx.getMeasure());
    order.setPrice(orderFx.getPrice());
    order.setTax(orderFx.getTax());
    order.setInvoice(InvoiceConventer.convertToInvoice(orderFx.getInvoiceFx()));
    order.setQuantity(orderFx.getQuantity());
    return order;
  }
}
