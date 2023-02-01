package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.model.Order.OrderRequest;
import org.example.service.BoxService;
import org.example.service.ClientService;
import org.example.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderWebController {

    private final OrderService orderService;

    private final ClientService clientService;

    private final BoxService boxService;

    @GetMapping("/order")
    public String goToOrdersPage(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "orderPage";
    }

    @GetMapping("/allBoxOrders")
    public String allBoxOrders(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allBoxes", boxService.getAllBoxes());
        return "allBoxOrdersPage";
    }

    @GetMapping("/goToCreateBoxOrderPage")
    public String goToCreateBoxOrderPage(Model model){
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("boxes", boxService.getAllBoxes());
        return "orderCreatePage";
    }

    @PostMapping("/create-new-box-order")
    public String createNewBoxOrder(@ModelAttribute OrderRequest orderRequest, Model model){
        orderService.createBoxOrder(orderRequest);
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allBoxes", boxService.getAllBoxes());
        model.addAttribute("orders", orderService.getAllOrders());
        return "allBoxOrdersPage";
    }

}
