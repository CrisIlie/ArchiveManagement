package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.EmptyBox;
import org.example.exception.BusinessException;
import org.example.mapper.EmptyBoxMapper;
import org.example.model.emptyBox.EmptyBoxRequest;
import org.example.model.emptyBox.EmptyBoxResponse;
import org.example.model.emptyBox.RequestUpdateStock;
import org.example.repository.EmptyBoxRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmptyBoxService {

    private final EmptyBoxRepository emptyBoxRepository;

    private final EmptyBoxMapper emptyBoxMapper;

    public EmptyBoxResponse createEmptyBox(EmptyBoxRequest emptyBoxRequest) {
        checkDuplicate(emptyBoxRequest);
        EmptyBox emptyBox = emptyBoxMapper.map(emptyBoxRequest);
        return emptyBoxMapper.map(emptyBoxRepository.save(emptyBox));
    }

    private void checkDuplicate(EmptyBoxRequest emptyBoxRequest) {
        for (EmptyBox emptyBox : emptyBoxRepository.findAll()) {
            if (emptyBox.getBoxType().equalsIgnoreCase(emptyBoxRequest.getBoxType())) {
                throw new BusinessException("This box type already exists!");
            }
        }
    }

    public EmptyBoxResponse findById(Integer id){
        return emptyBoxMapper.map(emptyBoxRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Empty box type not found")
        ));
    }

    public List<EmptyBoxResponse> getAllEmptyBoxes(){
        return emptyBoxMapper.map(emptyBoxRepository.findAll());
    }

    public void updateStock(RequestUpdateStock requestUpdateStock){
        EmptyBox emptyBoxStockToUpdate = emptyBoxRepository.findById(requestUpdateStock.getId()).orElseThrow(
                () -> new BusinessException(String.format("Empty box type with id: %s not found", requestUpdateStock.getId()))
        );
        emptyBoxStockToUpdate.setStock(requestUpdateStock.getStock());
    }
}
