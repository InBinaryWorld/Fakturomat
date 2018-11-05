package pl.fakturomat.database.modelmanagers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.fakturomat.database.dao.ClientDao;
import pl.fakturomat.database.models.Client;
import pl.fakturomat.database.modelsfx.ClientFx;
import pl.fakturomat.tools.ApplicationException;
import pl.fakturomat.tools.converters.ClientConverter;

public class AddClientModel {
  private ObjectProperty<ClientFx> clientFx = new SimpleObjectProperty<>(new ClientFx());

  public AddClientModel() {
  }

  /**
   * Save client.
   * @throws ApplicationException Error.
   */
  public void saveClientInDataBase() throws ApplicationException {
    ClientDao clientDao = new ClientDao();
    Client client = ClientConverter.convertToClient(getClientFx());
    clientDao.create(client);
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
