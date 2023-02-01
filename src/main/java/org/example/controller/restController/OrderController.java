package org.example.controller.restController;

import lombok.RequiredArgsConstructor;
import org.example.model.Order.OrderRequest;
import org.example.model.Order.OrderResponse;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("orderPage")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderService orderService;

    @PostMapping("create")
    public OrderResponse createBoxOrder(@RequestBody @Valid OrderRequest orderRequest){
        return orderService.createBoxOrder(orderRequest);
    }

    @GetMapping("find/{id}")
    public OrderResponse findById(@PathVariable("id") Integer id){
        return orderService.findById(id);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }
}
