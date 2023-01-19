package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.model.IdRequest;
import org.example.model.box.BoxRequest;
import org.example.model.box.BoxResponse;
import org.example.model.box.CreateBoxRequest;
import org.example.service.BoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/welcome")
@Controller
public class BoxWebController {

    private final BoxService boxService;

    @GetMapping("/box")
    public String goToBoxesPage(){ return "boxPage";}

    @GetMapping("/box/allBoxes")
    public String goToAllBoxes(Model model){
        model.addAttribute("boxes", boxService.getAllBoxes());
        return "allBoxesPage";
    }


    @GetMapping("/box/details")
    public String viewDetails(@ModelAttribute(value = "id") IdRequest request, Model model){
        BoxResponse boxResponse = boxService.findById(request.getId());
        model.addAttribute("box", boxResponse);
        return "boxDetailsPage";
    }

    @GetMapping("/box/goToCreateBoxPage")
    public String goToCreateBoxPage(){return "boxCreatePage";}

    @PostMapping("/box/create-new-box")
    public String createBox(@ModelAttribute(value = "createBoxRequest") CreateBoxRequest request, Model model){
        BoxRequest boxRequest = BoxRequest.builder()
                .boxType(request.getBoxType())
                .clientBoxCode(request.getClientBoxCode())
                .boxSummary(request.getBoxSummary())
                .nomenclatureId((request.getNomenclatureId()))
                .beginningDate(request.getBeginningDate())
                .endDate(request.getEndDate())
                .storageTime(request.getStorageTime())
                .clientId(request.getClient_id())
                .departmentId(request.getDepartment_id())
                .build();
        boxService.createBox(boxRequest);
        model.addAttribute("boxes", boxService.getAllBoxes());
        return "allBoxesPage";
    }

}
