package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Box;
import org.example.entity.statusEnum.BoxStatusEnum;
import org.example.exception.BusinessException;
import org.example.mapper.BoxMapper;
import org.example.model.box.*;
import org.example.repository.BoxRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoxService {

    private final BoxRepository boxRepository;

    private final BoxMapper boxMapper;

    public BoxResponse createBox(BoxRequest boxRequest) {
        for (Box box : boxRepository.findAll()) {
            if (box.getClientBoxCode().equals(boxRequest.getClientBoxCode())) {
                throw new BusinessException("This box already exists!");
            }
        }
        validateClientBoxCode(boxRequest.getClientBoxCode());
        Box box = boxMapper.map(boxRequest);
        box.setStatus(BoxStatusEnum.IN_ARCHIVE);
        return boxMapper.map(boxRepository.save(box));
    }

    public void validateClientBoxCode(String string) {
        if (string.isBlank() || string.length() < 6) {
            throw new BusinessException("Invalid client box code!");
        }
    }

    public List<BoxResponse> getAllBoxes(){
        return boxMapper.map(boxRepository.findAll());
    }
    public BoxResponse findById(Integer id) {
        return boxMapper.map(boxRepository.findById(id).orElseThrow(
                () -> new BusinessException("Box id not found")
        ));
    }
    public List<BoxResponse> findAll() {
        return boxMapper.map(boxRepository.findAll());
    }


    public void updateBoxType(Integer id, RequestUpdateBoxType requestUpdateBoxType) {
        Box boxToUpdate = boxRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Box with id: %s not found", id))
        );
        boxToUpdate.setBoxType(requestUpdateBoxType.getBoxType());
    }

    public void updateStorageTime(Integer id, RequestUpdateStorageTime requestUpdateStorageTime) {
        Box boxStorageTimeToUpdate = boxRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Box with id: %s not found", id))
        );
        boxStorageTimeToUpdate.setStorageTime(requestUpdateStorageTime.getStorageTime());
    }

    public void updateSummary(Integer id, RequestUpdateSummary requestUpdateSummary) {
        Box boxSummaryToUpdate = boxRepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format("Box with id: %s not found", id))
        );
        boxSummaryToUpdate.setBoxSummary(requestUpdateSummary.getBoxSummary());
    }

    public void deleteBox(Integer id){
        Box boxToDelete = boxRepository.findById(id).orElseThrow(()-> new BusinessException("Box not found"));
        boxRepository.delete(boxToDelete);
    }


}

