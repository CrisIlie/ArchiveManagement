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


    @GetMapping("/goToCreateClientPage")
    public String goToCreateClientPage(){return "clientCreatePage";}

    @PostMapping("/create-new-client")
    public String createClient(@ModelAttribute ClientRequest clientRequest, Model model){
        clientService.createClient(clientRequest);
        model.addAttribute("clients", clientService.getAllClients());
        return "allClientsPage";
    }

    @GetMapping("/goToUpdateClientName")
    public String goToUpdateClientName(@ModelAttribute IdRequest request, Model model){
        ClientResponse client = clientService.findById(request.getId());
        model.addAttribute("client", client);
        return "clientUpdateNamePage";
    }

    @PostMapping("/update-name")
    public String updateClientName(@ModelAttribute RequestUpdateNameClient request,
                                  Model model) {
        clientService.updateClientName(request);
        model.addAttribute("clients", clientService.getAllClients());
        return "allClientsPage";
    }

    @GetMapping("/details")
    public String viewDetails(@ModelAttribute IdRequest request, Model model){
        ClientResponse clientResponse = clientService.findById(request.getId());
        model.addAttribute("client", clientResponse);
        return "clientDetailsPage";
    }

    @GetMapping("/goToUpdateClientPage")
    public String goToUpdateClientPage(@ModelAttribute IdRequest request, Model model) {
        model.addAttribute("client", clientService.findById(request.getId()));
        return "updateClientPage";
    }

    @PostMapping("update-client")
    public String updateClient(@ModelAttribute ClientRequest clientRequest,
                                   Model model) {
        clientService.updateClient(clientRequest);
        model.addAttribute("clients", clientService.getAllClients());
        return "allClientsPage";
    }

    @GetMapping("/clientWithOrdersDetails")
    public String clientWithOrdersDetails(@ModelAttribute IdRequest request, Model model){
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

    @GetMapping("/clientWithBoxDetails")
    public String clientWithBoxDetails(@ModelAttribute IdRequest request, Model model){
        ClientDetailResponseForBox client = clientService.findByIdWithDetails(request.getId());
        model.addAttribute("client", client);
        return "clientWithDetailsPage";
    }


    @PostMapping("/deleteById")
    public String deleteById(@ModelAttribute(value="deleteRequest") IdRequest request, Model model){
        clientService.deleteById(request.getId());
        model.addAttribute("clients", clientService.getAllClients());
        return "allClientsPage";
    }
}
