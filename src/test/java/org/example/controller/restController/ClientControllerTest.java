package org.example.controller.restController;

import org.example.model.client.ClientRequest;
import org.example.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ClientControllerTest {

    @Test
    void createClient(){
        ClientService clientService = Mockito.mock(ClientService.class);
        ClientController clientController = new ClientController(clientService);
        ClientRequest client = new ClientRequest();
        client.setClientName("Client name test");
        client.setAddress("Client address test");
        client.setClientEmail("Client email test");
        clientController.createClient(client);
    }

    @Test
    void getAllClients(){
        ClientService clientService = Mockito.mock(ClientService.class);
        ClientController clientController = new ClientController(clientService);
        clientController.getAllClients();
    }

    @Test
    void findById(){}
}
