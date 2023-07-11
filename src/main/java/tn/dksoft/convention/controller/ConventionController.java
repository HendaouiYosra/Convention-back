package tn.dksoft.convention.controller;
import org.springframework.http.ResponseEntity;
import tn.dksoft.convention.entity.Convention;
import tn.dksoft.convention.service.ConventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConventionController {

    @Autowired
    private ConventionService conventionService;

    @PostMapping("/convention")
    public Convention saveConvention(@RequestBody Convention convention) {
        return conventionService.saveConvention(convention);
    }
    @GetMapping("/convention/{id}")
    public Convention getConventionById(@PathVariable("id") Long id) {
        return conventionService.getConventionById(id);
    }

    @GetMapping("/convention")
    public List<Convention> getAllConventions() {
        return conventionService.fetchAllConventions();
    }


    @PutMapping("/convention/{id}")
    public Convention updateConvention(@PathVariable("id") Long id, @RequestBody Convention convention) {
        return conventionService.updateConventionById(id, convention);
    }

    @DeleteMapping("/convention/{id}")
    public void deleteConvention(@PathVariable("id") Long id) {
        conventionService.deleteConventionById(id);
    }
}
