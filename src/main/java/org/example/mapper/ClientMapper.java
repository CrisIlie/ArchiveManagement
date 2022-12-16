package org.example.mapper;

import org.example.entity.Client;
import org.example.model.client.*;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client map(ClientRequest clientRequest);

    ClientResponse map(Client client);

    List<ClientResponse> map(List<Client> allClients);

    Client map(RequestUpdateNameClient requestUpdateNameClient);

    Client map(RequestUpdateEmailClient requestUpdateEmailClient);

    Client map(RequestUpdateAddress requestUpdateAddress);
}
