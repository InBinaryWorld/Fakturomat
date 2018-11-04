package pl.fakturomat.dataBase.dao;

import pl.fakturomat.dataBase.models.Client;

public class ClientDao extends CommonDao<Client> {
  public ClientDao() {
    super(Client.class);
  }
}
