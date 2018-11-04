package pl.fakturomat.dataBase.modelManagers;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.fakturomat.dataBase.dao.ClientDao;
import pl.fakturomat.dataBase.models.Client;
import pl.fakturomat.dataBase.modelsFx.ClientFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ClientConverter;

public class AddClientModel {
  private  ObjectProperty<ClientFx> clientFx = new SimpleObjectProperty<>(new ClientFx());

  public AddClientModel() {
  }

  public void saveClientInDataBase() throws ApplicationException {
    ClientDao clientDao = new ClientDao();
    Client client = ClientConverter.convertToClient(getClientFx());
    clientDao.createOrUpdate(client);
  }

  public ClientFx getClientFx() {
    return clientFx.get();
  }

  public ObjectProperty<ClientFx> clientFxProperty() {
    return clientFx;
  }

  public void setClientFx(ClientFx clientFx) {
    this.clientFx.set(clientFx);
  }
}
