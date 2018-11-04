package pl.fakturomat.tools.converters;

import pl.fakturomat.dataBase.models.Client;
import pl.fakturomat.dataBase.modelsFx.ClientFx;

public abstract class ClientConverter {
  public static ClientFx convertToClientFx(Client client){
    ClientFx clientFx = new ClientFx();
    clientFx.setClientId(client.getClientID());
    clientFx.setName(client.getName());
    clientFx.setNip(client.getNip());
    clientFx.setPostCode(client.getPostCode());
    clientFx.setCity(client.getCity());
    clientFx.setAddress(client.getAddress());
    clientFx.setPhone(client.getPhone());
    return clientFx;
  }

  public static Client convertToClient(ClientFx clientFx){
    Client client = new Client();
    client.setClientID(clientFx.getClientId());
    client.setName(clientFx.getName());
    client.setNip(clientFx.getNip());
    client.setPostCode(clientFx.getPostCode());
    client.setCity(clientFx.getCity());
    client.setAddress(clientFx.getAddress());
    client.setPhone(clientFx.getPhone());
    return client;
  }


}
