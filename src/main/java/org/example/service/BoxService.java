package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Box;
import org.example.entity.Department;
import org.example.entity.statusEnum.BoxStatusEnum;
import org.example.exception.BusinessException;
import org.example.mapper.BoxMapper;
import org.example.model.box.*;
import org.example.repository.BoxRepository;
import org.example.repository.ClientRepository;
import org.example.repository.DepartmentRepository;
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
    private final ClientRepository clientRepository;
    private final DepartmentRepository departmentRepository;

    public BoxResponse createBox(BoxRequest boxRequest) {
        for (Box box : boxRepository.findAll()) {
            if (box.getClientBoxCode().equals(boxRequest.getClientBoxCode())) {
                throw new BusinessException("This box already exists!");
            }
        }
        validateClientBoxCode(boxRequest.getClientBoxCode());
        Box boxToSave = boxMapper.map(boxRequest);
        boxToSave.setClient(clientRepository.findById(boxRequest.getClientId()).orElseThrow(()-> new BusinessException("Client not found")));
        Department department = departmentRepository.findById(boxRequest.getDepartmentId()).orElseThrow(()->new BusinessException("Department not found"));
        boxToSave.setDepartment(department);

//        boxToSave.setStatus(BoxStatusEnum.IN_ARCHIVE);
        return boxMapper.map(boxRepository.save(boxToSave));
    }

    public void validateClientBoxCode(String string) {
        if (string.isBlank() || string.length() < 6) {
            throw new BusinessException("Invalid client box code! Box code must be minimum 6 characters long");
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

    public void updateBox(BoxRequest boxRequest){
        for (Box box: boxRepository.findAll()){
            if(box.getClientBoxCode().equalsIgnoreCase(boxRequest.getClientBoxCode())){
                throw new BusinessException("This box already exists!");
            }
        }

        Box boxToUpdate = boxRepository.findById(boxRequest.getId()).orElseThrow(()-> new BusinessException("Box not found!"));
        boxToUpdate.setClientBoxCode(boxRequest.getClientBoxCode());
        boxToUpdate.setBoxType(boxRequest.getBoxType());
        boxToUpdate.setBoxSummary(boxRequest.getBoxSummary());
        boxToUpdate.setBeginningDate(boxRequest.getBeginningDate());
        boxToUpdate.setEndDate(boxRequest.getEndDate());
        boxToUpdate.setStorageTime(boxRequest.getStorageTime());
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

