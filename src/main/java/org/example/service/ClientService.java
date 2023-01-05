package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Box;
import org.example.entity.Client;
import org.example.exception.BusinessException;
import org.example.mapper.ClientMapper;
import org.example.model.box.BoxResponse;
import org.example.model.box.BoxResponseForClientDetail;
import org.example.model.client.*;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public ClientResponse createClient(ClientRequest clientRequest) {
        for (Client client : clientRepository.findAll()) {
            if (client.getClientName().equalsIgnoreCase(clientRequest.getClientName())) {
                throw new BusinessException("This client already exists!");
            }
        }
        Client client = clientMapper.map(clientRequest);
        return clientMapper.map(clientRepository.save(client));
    }


    public List<ClientResponse> findAll() {

        return clientMapper.map(clientRepository.findAll());
    }

    public ClientResponse findById(Integer id) {
        return clientMapper.map(clientRepository.findById(id).orElseThrow(
                () -> new BusinessException("Client id not found")
        ));
    }


    public ClientDetailResponse findByIdWithDetails(Integer id) {
        return clientMapper.mapDetails(clientRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Client not found")
        ));
//        Client client = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Client not found"));
//        ClientDetailResponse clientDetailResponse = new ClientDetailResponse();
//        clientDetailResponse.setClientName(client.getClientName());
//        clientDetailResponse.setBoxes(new ArrayList<>());
//        for (Box box : client.getBoxes()) {
//            BoxResponse boxResponse= new BoxResponse();
//            boxResponse.setClientBoxCode(box.getClientBoxCode());
//            boxResponse.setDepartmentName(box.getDepartmentName());
//            boxResponse.setBoxType(box.getBoxType());
//            boxResponse.setBoxSummary(box.getBoxSummary());
//            boxResponse.setBeginningDate(box.getBeginningDate());
//            boxResponse.setEndDate(box.getEndDate());
//            boxResponse.setStorageTime(box.getStorageTime());
//            clientDetailResponse.getBoxes().add(boxResponse);
//        }
//        return clientDetailResponse;
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

    public void deleteById(Integer id) {             // de pus conditie sa se poata sterge doar daca nu are nicio cutie inregistrata pe el clientul
        Client clientToDelete = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Client not found"));
        clientRepository.deleteById(clientToDelete.getId());
    }
}
