package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.client.*;
import org.example.repository.ClientRepository;
import org.example.service.ClientService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("client")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    private final ClientRepository clientRepository;

    @PostMapping("create")
    public ClientResponse createClient(@RequestBody @Valid ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

    @GetMapping("find/{id}")
    public ClientResponse findById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @GetMapping
    public List<ClientResponse> findAll() {
        return clientService.findAll();
    }

    @PostMapping("update-client-address/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody @Valid RequestUpdateAddress requestUpdateAddress) {
        clientService.updateAddress(id, requestUpdateAddress);
    }

    @PostMapping("update-client-email/{id}")
    public void updateEmailClient(@PathVariable Integer id, @RequestBody @Valid RequestUpdateEmailClient requestUpdateEmailClient) {
        clientService.updateEmailClient(id, requestUpdateEmailClient);
    }

    @PostMapping("update-client-name/{id}")
    public void updateClientName(@PathVariable Integer id, @RequestBody @Valid RequestUpdateNameClient requestUpdateNameClient) {
        clientService.updateClientName(id, requestUpdateNameClient);
    }
}
