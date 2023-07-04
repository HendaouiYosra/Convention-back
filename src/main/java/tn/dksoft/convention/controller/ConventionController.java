package tn.dksoft.convention.controller;
import tn.dksoft.convention.entity.Convention;
import tn.dksoft.convention.service.ConventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConventionController {

    @Autowired
    private ConventionService employeeService;

    @PostMapping("/employee")
    public Convention saveConvention(@RequestBody Convention employee) {
        return employeeService.saveConvention(employee);
    }

    @GetMapping("/employee")
    public List<Convention> getAllConventions() {
        return employeeService.fetchAllConventions();
    }

    @GetMapping("/employee/{id}")
    public Convention getConventionById(@PathVariable("id") Long id) {
        return employeeService.getConventionById(id);
    }

    @PutMapping("/employee/{id}")
    public Convention updateConvention(@PathVariable("id") Long id, @RequestBody Convention employee) {
        return employeeService.updateConventionById(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteConvention(@PathVariable("id") Long id) {
        return employeeService.deleteDepartmentById(id);
    }
}
