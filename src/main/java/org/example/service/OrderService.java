package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Box;
import org.example.entity.Order;
import org.example.exception.BusinessException;
import org.example.mapper.OrderMapper;
import org.example.model.Order.OrderRequest;
import org.example.model.Order.OrderResponse;
import org.example.repository.BoxRepository;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final BoxRepository boxRepository;
    private final ClientRepository clientRepository;


    public OrderResponse createBoxOrder(OrderRequest orderRequest){
        Order boxOrder = orderMapper.map(orderRequest);
        boxOrder.setClient(clientRepository.findById(orderRequest.getClientId()).orElseThrow(
                ()-> new BusinessException("Client not found")
        ));
        boxOrder.setBoxOrderDate(orderRepository.findByBoxOrderDate(orderRequest.getBoxOrderDate()));
        Set<Box> orderedBoxes = new HashSet<>();
        for(Integer id : orderRequest.getOrderedBoxesIds()){
            Box box = boxRepository.findById(id).orElseThrow( () -> new BusinessException("Box not found"));
            orderedBoxes.add(box);
        }
        boxOrder.getOrderedBoxes().addAll(orderedBoxes);

        return orderMapper.map(orderRepository.save(boxOrder));
    }


    public OrderResponse findById(Integer id){
        return orderMapper.map(orderRepository.findById(id).orElseThrow(()-> new BusinessException(
                "Box order not found")));
    }

    public List<OrderResponse> findAll(){
        return orderMapper.map(orderRepository.findAll());
    }

    }

