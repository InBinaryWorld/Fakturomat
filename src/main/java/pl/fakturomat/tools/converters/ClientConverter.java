package pl.fakturomat.tools.converters;

import pl.fakturomat.database.models.Client;
import pl.fakturomat.database.modelsfx.ClientFx;

public abstract class ClientConverter {
  /**
   * Convener.
   * @param client Client.
   * @return ClientFx.
   */
  public static ClientFx convertToClientFx(Client client) {
    ClientFx clientFx = new ClientFx();
    clientFx.setClientId(client.getClientId());
    clientFx.setName(client.getName());
    clientFx.setNip(client.getNip());
    clientFx.setPostCode(client.getPostCode());
    clientFx.setCity(client.getCity());
    clientFx.setAddress(client.getAddress());
    clientFx.setPhone(client.getPhone());
    return clientFx;
  }

  /**
   * Convert.
   * @param clientFx ClientFx.
   * @return Client.
   */
  public static Client convertToClient(ClientFx clientFx) {
    Client client = new Client();
    client.setClientId(clientFx.getClientId());
    client.setName(clientFx.getName());
    client.setNip(clientFx.getNip());
    client.setPostCode(clientFx.getPostCode());
    client.setCity(clientFx.getCity());
    client.setAddress(clientFx.getAddress());
    client.setPhone(clientFx.getPhone());
    return client;
  }


}
