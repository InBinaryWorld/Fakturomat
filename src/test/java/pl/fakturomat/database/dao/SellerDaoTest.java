package pl.fakturomat.database.dao;

import org.junit.Test;
import pl.fakturomat.database.models.Client;
import pl.fakturomat.database.models.Seller;
import pl.fakturomat.tools.ApplicationException;

import java.util.List;

import static org.junit.Assert.*;

public class SellerDaoTest {
  @Test
  public void databaseSellerTest() {
    Seller client2 = new Seller();
    client2.setPhone("695248353");
    client2.setAddress("ul.Kobyły 45");
    client2.setCity("Seattle");
    client2.setPostCode("01-921");
    client2.setNip("92750419390");
    client2.setName("Voyage");
    SellerDao sellerDao = new SellerDao();
    try {
      sellerDao.create(client2);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }

    List<Seller> list = null;
    try {
      list = sellerDao.queryForAll();
    } catch (ApplicationException e) {
      e.printStackTrace();
      assertTrue(list.get(0).getName().equals(client2.getName()));
    }
  }

}