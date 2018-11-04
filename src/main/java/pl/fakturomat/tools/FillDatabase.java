package pl.fakturomat.tools;

import jdk.jfr.DataAmount;
import pl.fakturomat.dataBase.DbManager;
import pl.fakturomat.dataBase.dao.*;
import pl.fakturomat.dataBase.models.*;
import pl.fakturomat.tools.converters.DateConventers;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public abstract class FillDatabase {
  public static void fillDatabase() {
    Client client1 = new Client();
    client1.setPhone("695245233");
    client1.setAddress("ul.Blady 2");
    client1.setCity("Maroko");
    client1.setPostCode("21-436");
    client1.setNip("65936419392");
    client1.setName("Jarsky sp. z o.o.");

    Client client2 = new Client();
    client2.setPhone("695248353");
    client2.setAddress("ul.Kobyły 45");
    client2.setCity("Seattle");
    client2.setPostCode("01-921");
    client2.setNip("92750419390");
    client2.setName("Voyage");

    Seller seller1 = new Seller();
    seller1.setPhone("462452363");
    seller1.setAddress("ul.Nowa 7");
    seller1.setCity("Wrocłąw");
    seller1.setPostCode("28-496");
    seller1.setNip("25536419392");
    seller1.setName("Loki");

    Seller seller2 = new Seller();
    seller2.setPhone("8324322363");
    seller2.setAddress("ul.Brzozowa 15");
    seller2.setCity("Waszawa");
    seller2.setPostCode("00-029");
    seller2.setNip("63536419362");
    seller2.setName("Pistacja");

    Product product1 = new Product();
    product1.setTax(23);
    product1.setPrice(10);
    product1.setName("Pizza mrożona");
    product1.setMeasure("szt.");

    Product product2 = new Product();
    product2.setTax(8);
    product2.setPrice(1);
    product2.setName("Lizak");
    product2.setMeasure("szt.");

    Invoice invoice1 = new Invoice();
    invoice1.setId(1);
    invoice1.setClient(client1);
    invoice1.setSeller(seller1);
    invoice1.setData(DateConventers.convertToDate(LocalDate.now()));

    Order order1 = new Order();
    order1.setQuantity(2);
    order1.setMeasure(product1.getMeasure());
    order1.setName(product1.getName());
    order1.setPrice(product1.getPrice());
    order1.setTax(product1.getTax());
    order1.setInvoice(invoice1);

    ClientDao clientDao =new ClientDao();
    try {
      clientDao.createOrUpdate(client1);
      clientDao.createOrUpdate(client2);
    } catch (ApplicationException e) {
      e.printStackTrace();
    }

    SellerDao sellerDao = new SellerDao();
    try {
      sellerDao.createOrUpdate(seller1);
      sellerDao.createOrUpdate(seller2);
    } catch (ApplicationException e) {
      e.printStackTrace();
    }

    ProductDao productDao = new ProductDao();
    try {
      productDao.createOrUpdate(product1);
      productDao.createOrUpdate(product2);
    } catch (ApplicationException e) {
      e.printStackTrace();
    }

    InvoiceDao invoiceDao = new InvoiceDao();
    try {
      invoiceDao.createOrUpdate(invoice1);
    } catch (ApplicationException e) {
      e.printStackTrace();
    }



    OrderDao orderDao = new OrderDao();
    try {
      orderDao.createOrUpdate(order1);
    } catch (ApplicationException e) {
      e.printStackTrace();
    }

    DbManager.closeConnectionSource();
  }
}