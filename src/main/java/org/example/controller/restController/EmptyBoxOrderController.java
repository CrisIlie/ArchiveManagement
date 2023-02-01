package org.example.controller.restController;

import lombok.RequiredArgsConstructor;
import org.example.model.emptyBoxOrder.EmptyBoxOrderResponse;
import org.example.repository.EmptyBoxOrderRepository;
import org.example.service.EmptyBoxOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emptyBoxOrderPage")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class EmptyBoxOrderController {
    private final EmptyBoxOrderService emptyBoxOrderService;

    @GetMapping("find/{id}")
    public EmptyBoxOrderResponse findById(@PathVariable Integer id){
        return emptyBoxOrderService.findById(id);
    }

    @GetMapping
    public List<EmptyBoxOrderResponse> findAll(){
        return emptyBoxOrderService.findAll();
    }
}
