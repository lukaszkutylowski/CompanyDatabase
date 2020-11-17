package lukaszkutylowski.controller;

import lukaszkutylowski.model.Payload;
import lukaszkutylowski.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public HttpStatus save(@RequestBody Payload payload) {
        Payload savedPayload = companyService.save(payload);
        if (savedPayload != null) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_IMPLEMENTED;
        }
    }

    @GetMapping("/get/{id}")
    public Payload getById(@PathVariable int id) {
        Payload payload = null;
        payload = companyService.getById(id);
        return payload;
    }

    @PutMapping("/update/{id}")
    public HttpStatus update(@RequestBody Payload payload, @PathVariable int id) {
        Payload updatedPayload = companyService.update(payload, id);
        if (updatedPayload != null) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_MODIFIED;
        }
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable int id) {
        Payload deletedPayload = companyService.delete(id);
        if (deletedPayload == null) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_MODIFIED;
        }
    }
}
