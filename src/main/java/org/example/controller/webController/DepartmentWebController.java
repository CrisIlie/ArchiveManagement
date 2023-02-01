package org.example.controller.webController;

import lombok.RequiredArgsConstructor;
import org.example.model.IdRequest;
import org.example.model.department.DepartmentRequest;
import org.example.model.department.DepartmentResponse;
import org.example.service.ClientService;
import org.example.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class DepartmentWebController {

    private final DepartmentService departmentService;

    private final ClientService clientService;

    @GetMapping("/department")
    public String goToDepartmentPage() {
        return "departmentPage";
    }

    @GetMapping("/allDepartments")
    public String goToAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("clients", clientService.getAllClients());
        return "allDepartmentsPage";
    }

    @GetMapping("/goToCreateDepartmentPage")
    public String goToCreateDepartmentPage(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("clients", clientService.getAllClients());
        return "createDepartmentPage";
    }

    @PostMapping("/create-new-department")
    public String createDepartment(@ModelAttribute DepartmentRequest request, Model model) {
        departmentService.createDepartment(request);
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "allDepartmentsPage";
    }

    @GetMapping("/goToUpdateDepartmentPage")
    public String goToUpdateDepartmentPage(@ModelAttribute IdRequest request, Model model) {
        model.addAttribute("department", departmentService.findById(request.getId()));
        return "updateDepartmentPage";
    }

    @PostMapping("update-department")
    public String updateDepartment(@ModelAttribute DepartmentRequest departmentRequest,
                               Model model) {
        departmentService.updateDepartment(departmentRequest);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("clients", clientService.getAllClients());
        return "allDepartmentsPage";
    }

    @GetMapping("/goToUpdateDepartmentNamePage")
    public String goToUpdateDepartmentNamePage(@ModelAttribute(value = "idRequest") IdRequest request, Model model) {
        DepartmentResponse department = departmentService.findById(request.getId());
        model.addAttribute("department", department);
        return "departmentUpdateNamePage";
    }

    @PostMapping("/deleteById")
    public String deleteById(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        departmentService.deleteById(request.getId());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "allDepartmentsPage";
    }
}
