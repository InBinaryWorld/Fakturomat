package pl.fakturomat.database.dao;

import com.sun.source.tree.AssertTree;
import org.junit.Before;
import org.junit.Test;
import pl.fakturomat.database.DbManager;
import pl.fakturomat.database.models.Client;
import pl.fakturomat.tools.ApplicationException;

import java.util.List;

import static org.junit.Assert.*;

public class ClientDaoTest {

  private ClientDao clientDao;



  @Test
  public void databaseClientTest() {
    Client client2 = getClient();
    clientDao = new ClientDao();
    try {
      clientDao.create(client2);
    } catch (ApplicationException ee1) {
      ee1.printStackTrace();
    }

    List<Client> list = null;
    try {
      list = clientDao.queryForAll();
    } catch (ApplicationException e) {
      e.printStackTrace();
      assertTrue(list.get(0).getName().equals(client2.getName()));
    }
  }

  private Client getClient() {
    Client client2 = new Client();
    client2.setPhone("695248353");
    client2.setAddress("ul.Kobyły 45");
    client2.setCity("Seattle");
    client2.setPostCode("01-921");
    client2.setNip("92750419390");
    client2.setName("Voyage");
    return client2;
  }

}