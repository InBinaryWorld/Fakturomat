package pl.fakturomat.database.dao;

import pl.fakturomat.database.models.Client;

public class ClientDao extends CommonDao<Client> {

  public ClientDao() {
    super(Client.class);
  }
}
