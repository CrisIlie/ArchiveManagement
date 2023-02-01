package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.service.ClientService;
import org.example.service.EmptyBoxOrderService;
import org.example.service.EmptyBoxService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class EmptyBoxOrderWebController {

    private final EmptyBoxOrderService emptyBoxOrderService;

    private final EmptyBoxService emptyBoxService;

    private final UserService userService;

    @GetMapping("/emptyBoxOrder")
    public String goToEmptyBoxOrderPage(Model model){
        model.addAttribute("emptyBoxOrders", emptyBoxOrderService.findAll());
        return "emptyBoxOrderPage";
    }

    @GetMapping("/allEmptyBoxOrders")
    public String allEmptyBoxOrders(Model model){
        model.addAttribute("emptyBoxOrders", emptyBoxOrderService.findAll());
        model.addAttribute("emptyBoxes", emptyBoxService.getAllEmptyBoxes());
        return "emptyBoxOrderPage";
    }
}
