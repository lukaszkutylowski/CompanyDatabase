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

    @Override
    public Payload getById(int id) {
        return companyDAO.getById(id);
    }

    @Override
    public Payload update(Payload payload, int id) {
        return companyDAO.update(payload, id);
    }

    @Override
    public Payload delete(int id) {
        return companyDAO.delete(id);
    }
}
