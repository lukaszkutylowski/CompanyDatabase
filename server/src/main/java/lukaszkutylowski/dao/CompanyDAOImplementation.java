package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CompanyDAOImplementation implements CompanyDAO {

    @Override
    public List<Payload> get() {
        return GetAllService.get();
    }

    @Override
    public Payload save(Payload payload) {
        return SaveService.save(payload);
    }

    @Override
    public Payload getById(int id) {
        return GetByIdService.getById(id);
    }

    @Override
    public Payload update(Payload payload, int id) {
        return UpdateService.update(payload, id);
    }

    @Override
    public Payload delete(int id) {
        return DeleteService.delete(id);
    }
}
