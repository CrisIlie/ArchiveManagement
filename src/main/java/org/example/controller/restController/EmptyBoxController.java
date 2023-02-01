package org.example.controller.restController;

import lombok.RequiredArgsConstructor;
import org.example.model.emptyBox.EmptyBoxRequest;
import org.example.model.emptyBox.EmptyBoxResponse;
import org.example.model.emptyBox.RequestUpdateStock;
import org.example.service.EmptyBoxService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("emptyBoxPage")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class EmptyBoxController {
    private final EmptyBoxService emptyBoxService;

    @PostMapping("create")
    public EmptyBoxResponse createEmptyBox(@RequestBody @Valid EmptyBoxRequest emptyBoxRequest){
        return emptyBoxService.createEmptyBox(emptyBoxRequest);
    }

    @GetMapping("find/{id}")
    public EmptyBoxResponse findById(@PathVariable Integer id){
        return emptyBoxService.findById(id);
    }

    @GetMapping
    public List<EmptyBoxResponse> getAllEmptyBoxes(){
        return emptyBoxService.getAllEmptyBoxes();
    }

    @PostMapping("update-stock")
    public void updateStock(@RequestBody @Valid RequestUpdateStock requestUpdateStock){
        emptyBoxService.updateStock(requestUpdateStock);
    }

}
