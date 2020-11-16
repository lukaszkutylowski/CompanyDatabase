package lukaszkutylowski.service;

import lukaszkutylowski.dao.CompanyDAO;
import lukaszkutylowski.model.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public List<Payload> get() {
        return companyDAO.get();
    }

    @Override
    public Payload save(Payload payload) {
        return companyDAO.save(payload);
    }
}
