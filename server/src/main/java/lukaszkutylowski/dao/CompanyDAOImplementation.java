package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.SelectPayload;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyDAOImplementation implements CompanyDAO {

    private static final String SELECT_ALL =
            "SELECT employee.firstname, employee.lastname, " +
            "details.salary, details.city, department.department_name " +
            "FROM employee " +
            "JOIN details " +
            "ON employee.details_id = details.details_id " +
            "JOIN department " +
            "ON details.department_id = department.department_id;";

    @Override
    public List<SelectPayload> get() {
        ResultSet resultSet = DbQueryExecutor.executeSelect(SELECT_ALL);
        List<SelectPayload> results = new ArrayList<>();

        try {
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstName");
                String lastname = resultSet.getString("lastName");
                int salary = resultSet.getInt("salary");
                String city = resultSet.getString("city");
                String department = resultSet.getString("department_name");
                SelectPayload payload = new SelectPayload(firstname,lastname,salary,city,department);
                results.add(payload);
            }
        } catch (SQLException e) {}

        return results;
    }
}
