package lukaszkutylowski.controller;

import lukaszkutylowski.model.Payload;
import lukaszkutylowski.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public List<Payload> get() {
        return companyService.get();
    }

    @PostMapping("/save")
    public Payload save(@RequestBody Payload payload) {
        return companyService.save(payload);
    }
}
