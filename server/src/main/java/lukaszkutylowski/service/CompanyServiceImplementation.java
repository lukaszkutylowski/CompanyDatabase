package lukaszkutylowski.service;

import lukaszkutylowski.dao.CompanyDAO;
import lukaszkutylowski.model.SelectPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public List<SelectPayload> get() {
        return companyDAO.get();
    }
}
