package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Box;
import org.example.model.box.*;
import org.example.repository.BoxRepository;
import org.example.service.BoxService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("box")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class BoxController {

    private final BoxService boxService;
    private final BoxRepository boxRepository;

    @PostMapping("create")
    public BoxResponse createBox(@RequestBody @Valid BoxRequest boxRequest) {
        return boxService.createBox(boxRequest);
    }

    @GetMapping("find/{id}")
    public BoxResponse findById(@PathVariable Integer id) {
        return boxService.findById(id);
    }

    @GetMapping
    public List<BoxResponse> findAll() {
        return boxService.findAll();
    }

    @PostMapping("update-box-type/{id}")
    public void updateBoxType(@PathVariable Integer id, @RequestBody @Valid RequestUpdateBoxType requestUpdateBoxType) {
        boxService.updateBoxType(id, requestUpdateBoxType);
    }

    @PostMapping("update-box-department/{id}")
    public void updateDepartment(@PathVariable Integer id, @RequestBody @Valid RequestUpdateDepartment requestUpdateDepartment) {
        boxService.updateDepartment(id, requestUpdateDepartment);
    }

    @PostMapping("update-box-storage-time/{id}")
    public void updateStorageTime(@PathVariable Integer id, @RequestBody @Valid RequestUpdateStorageTime requestUpdateStorageTime) {
        boxService.updateStorageTime(id, requestUpdateStorageTime);
    }

    @PostMapping("update-box-summary/{id}")
    public void updateSummary(@PathVariable Integer id, @RequestBody @Valid RequestUpdateSummary requestUpdateSummary){
        boxService.updateSummary(id, requestUpdateSummary);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBox(@PathVariable Integer id){
        boxService.deleteBox(id);
    }
}
