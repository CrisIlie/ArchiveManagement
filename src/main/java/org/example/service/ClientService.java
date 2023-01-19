package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Box;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.entity.User;
import org.example.exception.BusinessException;
import org.example.mapper.ClientMapper;
import org.example.model.Order.OrderResponseForClientDetail;
import org.example.model.box.BoxResponse;
import org.example.model.box.BoxResponseForClientDetail;
import org.example.model.client.*;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;
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


    public ClientDetailResponseForBox findByIdWithDetails(Integer id) {

        Client client = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Client not found"));
        ClientDetailResponseForBox clientDetailResponseForBox = new ClientDetailResponseForBox();
        clientDetailResponseForBox.setClientName(client.getClientName());
        clientDetailResponseForBox.setBoxes(new ArrayList<>());
        for (Box box : client.getBoxes()) {
            BoxResponse boxResponse = new BoxResponse();
            boxResponse.setClientBoxCode(box.getClientBoxCode());
            boxResponse.setBoxType(box.getBoxType());
            boxResponse.setBoxSummary(box.getBoxSummary());
            boxResponse.setBeginningDate(box.getBeginningDate());
            boxResponse.setEndDate(box.getEndDate());
            boxResponse.setStorageTime(box.getStorageTime());
            boxResponse.setStatus(box.getStatus());
            boxResponse.setNomenclatureId(box.getNomenclatureId());
            boxResponse.setClient_id(box.getClient().getId());
            boxResponse.setDepartment_id(box.getDepartment().getId());

            clientDetailResponseForBox.getBoxes().add(boxResponse);
        }
        return clientDetailResponseForBox;
    }


//    public ClientDetailResponseForOrder findAllBoxOrders(Integer id){
//        Client client = clientRepository.findById(id).orElseThrow(()-> new BusinessException("Client not found"));
//        ClientDetailResponseForOrder clientDetailResponseForOrder = new ClientDetailResponseForOrder();
//        clientDetailResponseForOrder.setClientName(client.getClientName());
//        clientDetailResponseForOrder.setAllBoxOrders(new ArrayList<>());
//
//        for (Order order : client.getOrders()){
//            orderResponse boxOrderResponse = new BoxOrderResponse();
//            orderResponse.setClientId(boxOrder.getClient().getId());
//            orderResponse.setOrderId(boxOrder.getOrder().getId());
//            orderResponse.setBoxId(boxOrder.getBox().getId());
//
//            clientDetailResponseForOrder.getAllOrders().add(orderResponse);
//        }
//        return clientDetailResponseForOrder;
//    }

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

    public void deleteById(Integer id) {
        Client clientToDelete = clientRepository.findById(id).orElseThrow(() -> new BusinessException("Client not found"));
        clientRepository.deleteById(clientToDelete.getId());
    }

    public List<ClientResponse> getAllClients() {
        return clientMapper.map(clientRepository.findAll());
    }

    public ClientDetailResponseForOrder clientWithBoxOrders(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new BusinessException("Client not found"));
        return createClientDetailsResponse(client);
    }

    private ClientDetailResponseForOrder createClientDetailsResponse(Client client){
        ClientDetailResponseForOrder clientDetailResponseForOrder = new ClientDetailResponseForOrder();
        clientDetailResponseForOrder.setClientName(client.getClientName());
        clientDetailResponseForOrder.setOrders(new ArrayList<>());
        for(Order order : client.getBoxOrders()){
            OrderResponseForClientDetail orderResponseForClientDetail = new OrderResponseForClientDetail();
            orderResponseForClientDetail.setBoxOrderDate(order.getBoxOrderDate());
            orderResponseForClientDetail.setDelivered(order.getDelivered());
            orderResponseForClientDetail.setOrderedBoxes(new ArrayList<>());
            for (Box box : order.getOrderedBoxes()){
                BoxResponseForClientDetail boxResponseForClientDetail = new BoxResponseForClientDetail();
                boxResponseForClientDetail.setClientBoxCode(box.getClientBoxCode());
                orderResponseForClientDetail.getOrderedBoxes().add(boxResponseForClientDetail);
            }
            clientDetailResponseForOrder.getOrders().add(orderResponseForClientDetail);
        }
        return clientDetailResponseForOrder;
    }
}
