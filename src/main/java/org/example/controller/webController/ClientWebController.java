package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.model.IdRequest;
import org.example.model.Order.OrderResponseForClientDetail;
import org.example.model.box.BoxResponseForClientDetail;
import org.example.model.client.*;
import org.example.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/client")
public class ClientWebController {
    private final ClientService clientService;

    @GetMapping
    public String goToClientPage(){ return "clientPage";}

    @GetMapping("/allClients")
    public String goToAllClients(Model model){
        model.addAttribute("clients", clientService.findAll());
        return "allClientsPage";
    }

    @GetMapping("/details")
    public String viewDetails(@ModelAttribute(value = "id")IdRequest request, Model model){
        ClientResponse clientResponse = clientService.findById(request.getId());
        model.addAttribute("client", clientResponse);
        return "clientDetailsPage";
    }

    @GetMapping("/goToCreateClientPage")
    public String goToCreateClientPage(){return "clientCreatePage";}

    @GetMapping("/goToUpdateClientName")
    public String goToUpdateClientName(@ModelAttribute(value = "idRequest") IdRequest request, Model model){
        ClientResponse client = clientService.findById(request.getId());
        model.addAttribute("client", client);
        return "clientUpdateNamePage";
    }

    @GetMapping("/clientWithDetails")
    public String clientWithDetails(@ModelAttribute IdRequest request, Model model){
        ClientDetailResponseForOrder client = clientService.clientWithBoxOrders(request.getId());
        List<OrderResponseForClientDetail> orders = client.getOrders();
        List<BoxResponseForClientDetail> orderedBoxes = new ArrayList<>();
        for(OrderResponseForClientDetail order : orders){
            orderedBoxes.addAll(order.getOrderedBoxes());
        }
        model.addAttribute("boxesForClient", orderedBoxes);
        model.addAttribute("client", client);
        model.addAttribute("ordersForClient", orders);

        return "clientWithOrdersPage";
    }

    @PostMapping("/create-new-client")
    public String createClient(@ModelAttribute(value = "createClientRequest") CreateClientRequest request, Model model){
        ClientRequest clientRequest = ClientRequest.builder()
                .clientName(request.getClientName())
                .address(request.getAddress())
                .clientEmail(request.getEmail())
                .build();
        clientService.createClient(clientRequest);
        model.addAttribute("clients", clientService.getAllClients());
        return "allClientsPage";
    }

    @PostMapping("/deleteById")
    public String deleteById(@ModelAttribute(value="deleteRequest") IdRequest request, Model model){
        clientService.deleteById(request.getId());
        model.addAttribute("clients", clientService.getAllClients());
        return "allClientsPage";
    }
}
