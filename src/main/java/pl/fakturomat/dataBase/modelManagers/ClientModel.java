package pl.fakturomat.dataBase.modelManagers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.fakturomat.dataBase.dao.ClientDao;
import pl.fakturomat.dataBase.models.Client;
import pl.fakturomat.dataBase.modelsFx.ClientFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ClientConverter;

import java.util.List;

public class ClientModel {
   private static ObservableList<ClientFx> clientFxList = FXCollections.observableArrayList();
  
  public void init() throws ApplicationException {
    ClientDao clientDao = new ClientDao();
    List<Client> clientList = clientDao.queryForAll();
    clientFxList.clear();
    clientList.forEach(client -> clientFxList.add(ClientConverter.convertToClientFx(client)));
  }

  public static ObservableList<ClientFx> getClientFxList() {
    return clientFxList;
  }
}
