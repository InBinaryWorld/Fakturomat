package pl.fakturomat.tools;

import pl.fakturomat.database.DbManager;
import pl.fakturomat.database.dao.ClientDao;
import pl.fakturomat.database.dao.InvoiceDao;
import pl.fakturomat.database.dao.OrderDao;
import pl.fakturomat.database.dao.ProductDao;
import pl.fakturomat.database.dao.SellerDao;
import pl.fakturomat.database.models.Client;
import pl.fakturomat.database.models.Invoice;
import pl.fakturomat.database.models.Order;
import pl.fakturomat.database.models.Product;
import pl.fakturomat.database.models.Seller;
import pl.fakturomat.tools.converters.DateConverters;

import java.time.LocalDate;

public abstract class FillDatabase {
  /**
   * Fill.
   */
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
    invoice1.setData(DateConverters.convertToDate(LocalDate.now()));

    Order order1 = new Order();
    order1.setQuantity(2);
    order1.setMeasure(product1.getMeasure());
    order1.setName(product1.getName());
    order1.setPrice(product1.getPrice());
    order1.setTax(product1.getTax());
    order1.setInvoice(invoice1);

    ClientDao clientDao = new ClientDao();
    try {
      clientDao.create(client1);
      clientDao.create(client2);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }

    SellerDao sellerDao = new SellerDao();
    try {
      sellerDao.create(seller1);
      sellerDao.create(seller2);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }

    ProductDao productDao = new ProductDao();
    try {
      productDao.create(product1);
      productDao.create(product2);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }

    InvoiceDao invoiceDao = new InvoiceDao();
    try {
      invoiceDao.create(invoice1);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }


    OrderDao orderDao = new OrderDao();
    try {
      orderDao.create(order1);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }

    DbManager.closeConnectionSource();
  }
}
