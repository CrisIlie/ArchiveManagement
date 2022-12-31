package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Client;
import org.example.exception.BusinessException;
import org.example.mapper.ClientMapper;
import org.example.model.client.*;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientResponse createClient(ClientRequest clientRequest) {
        checkDuplicate(clientRequest);
        Client client = clientMapper.map(clientRequest);
        return clientMapper.map(clientRepository.save(client));
    }

    private void checkDuplicate(ClientRequest clientRequest) {
        for (Client client : clientRepository.findAll()) {
            if (client.getClientName().equalsIgnoreCase(clientRequest.getClientName())) {
                throw new BusinessException("This client already exists!");
            }
        }
    }

    public List<ClientResponse> findAll() {

        return clientMapper.map(clientRepository.findAll());
    }

    public ClientResponse findById(Integer id) {
        return clientMapper.map(clientRepository.findById(id).orElseThrow(
                () -> new BusinessException("Client id not found")
        ));
    }

    public void updateAddress(Integer id, RequestUpdateAddress requestUpdateAddress) {
        Client clientAddressToUpdate = clientRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Client with id: %s not found", id))
        );
        clientAddressToUpdate.setAddress(requestUpdateAddress.getAddress());
    }

    public void updateEmailClient(Integer id, RequestUpdateEmailClient requestUpdateEmailClient) {
        Client clientEmailToUpdate = clientRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Client with id: %s not found", id))
        );
        clientEmailToUpdate.setAddress(requestUpdateEmailClient.getClientEmail());
    }

    public void updateClientName(Integer id, RequestUpdateNameClient requestUpdateNameClient) {
        Client clientNameToUpdate = clientRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Client with id: %s not found", id))
        );
        clientNameToUpdate.setAddress(requestUpdateNameClient.getClientName());
    }

}
