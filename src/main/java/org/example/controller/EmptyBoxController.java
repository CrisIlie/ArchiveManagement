package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.client.ClientResponse;
import org.example.model.emptyBox.EmptyBoxRequest;
import org.example.model.emptyBox.EmptyBoxResponse;
import org.example.model.emptyBox.RequestUpdateStock;
import org.example.repository.EmptyBoxRepository;
import org.example.service.EmptyBoxService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("emptyBox")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class EmptyBoxController {
    private final EmptyBoxService emptyBoxService;

    private final EmptyBoxRepository emptyBoxRepository;

    @PostMapping("create")
    public EmptyBoxResponse createEmptyBox(@RequestBody @Valid EmptyBoxRequest emptyBoxRequest) {
        return emptyBoxService.createEmptyBox(emptyBoxRequest);
    }

    @GetMapping("find/{id}")
    public EmptyBoxResponse findById(@PathVariable Integer id) {
        return emptyBoxService.findById(id);
    }

    @GetMapping
    public List<EmptyBoxResponse> findAll() {
        return emptyBoxService.findAll();
    }

    @PostMapping("update-stock/{id}")
    public void updateStock(@PathVariable Integer id, @RequestBody @Valid RequestUpdateStock requestUpdateStock) {
        emptyBoxService.updateStock(id, requestUpdateStock);
    }
}
