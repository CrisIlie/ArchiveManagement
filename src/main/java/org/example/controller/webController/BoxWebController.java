package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.model.IdRequest;
import org.example.model.box.BoxRequest;
import org.example.model.box.BoxResponse;
import org.example.model.client.ClientRequest;
import org.example.service.BoxService;
import org.example.service.ClientService;
import org.example.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class BoxWebController {

    private final BoxService boxService;

    private final ClientService clientService;

    private final DepartmentService departmentService;

    @GetMapping("/box")
    public String goToBoxesPage(){ return "boxPage";}

    @GetMapping("/allBoxes")
    public String goToAllBoxes(Model model){
        model.addAttribute("boxes", boxService.getAllBoxes());
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allDepartments", departmentService.getAllDepartments());
        return "allBoxesPage";
    }
    @GetMapping("/goToCreateBoxPage")
    public String goToCreateBoxPage(Model model){
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "boxCreatePage";}

    @PostMapping("/create-new-box")
    public String createBox(@ModelAttribute BoxRequest boxRequest, Model model){
        boxService.createBox(boxRequest);
        model.addAttribute("allClients", clientService.getAllClients());
        model.addAttribute("allDepartments", departmentService.getAllDepartments());
        model.addAttribute("boxes", boxService.getAllBoxes());
        return "allBoxesPage";
    }
    @GetMapping("/details")
    public String viewDetails(@ModelAttribute(value = "id") IdRequest request, Model model){
        BoxResponse boxResponse = boxService.findById(request.getId());
        model.addAttribute("box", boxResponse);
        return "boxDetailsPage";
    }


    @GetMapping("/goToUpdateBoxPage")
    public String goToUpdateBoxPage(@ModelAttribute IdRequest request, Model model) {
        model.addAttribute("box", boxService.findById(request.getId()));
        return "updateBoxPage";
    }

    @PostMapping("update-box")
    public String updateBox(@ModelAttribute BoxRequest boxRequest,
                               Model model) {
        boxService.updateBox(boxRequest);
        model.addAttribute("boxes", boxService.getAllBoxes());
        return "allBoxesPage";
    }

    @PostMapping("delete")
    public String deleteBox(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model){
        boxService.deleteBox(request.getId());
        model.addAttribute("boxes", boxService.getAllBoxes());
        return "allBoxesPage";
    }
}
