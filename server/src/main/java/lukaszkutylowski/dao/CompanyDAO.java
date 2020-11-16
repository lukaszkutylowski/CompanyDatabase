package lukaszkutylowski.dao;

import lukaszkutylowski.model.Payload;

import java.util.List;

public interface CompanyDAO {
    List<Payload> get();
    Payload save(Payload payload);
//    Employee get(int id);
//    void save(Employee employee);
//    void  delete(int id);
}
