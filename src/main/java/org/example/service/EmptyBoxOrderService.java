package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.exception.BusinessException;
import org.example.mapper.EmptyBoxOrderMapper;
import org.example.model.emptyBoxOrder.EmptyBoxOrderResponse;
import org.example.repository.EmptyBoxOrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmptyBoxOrderService {

    private final EmptyBoxOrderRepository emptyBoxOrderRepository;

    private final EmptyBoxOrderMapper emptyBoxOrderMapper;

    public EmptyBoxOrderResponse findById(Integer id){
        return emptyBoxOrderMapper.map(emptyBoxOrderRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Empty box order not found")
        ));
    }

    public List<EmptyBoxOrderResponse> findAll(){
        return emptyBoxOrderMapper.map(emptyBoxOrderRepository.findAll());
    }

}
