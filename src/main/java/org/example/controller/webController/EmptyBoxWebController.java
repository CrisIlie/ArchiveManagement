package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.model.IdRequest;
import org.example.model.emptyBox.EmptyBoxRequest;
import org.example.model.emptyBox.EmptyBoxResponse;
import org.example.model.emptyBox.RequestUpdateStock;
import org.example.service.EmptyBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class EmptyBoxWebController {

    private final EmptyBoxService emptyBoxService;

    @GetMapping("/emptyBox")
    public String goToEmptyBoxPage(){
        return "emptyBoxPage";
    }

    @GetMapping("/allEmptyBoxes")
    public String goToAllEmptyBoxesPage(Model model){
        model.addAttribute("emptyBoxes", emptyBoxService.getAllEmptyBoxes());
        return "allEmptyBoxes";
    }

    @GetMapping("/goToCreateEmptyBoxPage")
    public String goToCreateEmptyBoxPage(){
        return "createEmptyBoxPage";
    }


    @PostMapping("/create-new-empty-box")
    public String createEmptyBox(@ModelAttribute EmptyBoxRequest emptyBoxRequest, Model model){
        emptyBoxService.createEmptyBox(emptyBoxRequest);
        model.addAttribute("emptyBoxes", emptyBoxService.getAllEmptyBoxes());
        return "allEmptyBoxes";
    }


    @PostMapping("/update-stock")
    public String updateStock(@ModelAttribute RequestUpdateStock request, Model model){
        emptyBoxService.updateStock(request);
        model.addAttribute("emptyBoxes", emptyBoxService.getAllEmptyBoxes());
        return "allEmptyBoxes";
    }

}
