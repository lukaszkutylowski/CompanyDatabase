package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAllService {

    private static final String SELECT_ALL =
                    "SELECT * " +
                    "FROM employee " +
                    "JOIN details " +
                    "ON employee.details_id = details.details_id " +
                    "JOIN department " +
                    "ON details.department_id = department.department_id;";

    public static List<Payload> get() {
        List<Payload> results = new ArrayList<>();
        ResultSet resultSet = DbQueryExecutor.executeSelect(SELECT_ALL);
        try {
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String firstname = resultSet.getString("firstName");
                String lastname = resultSet.getString("lastName");
                int details_id = resultSet.getInt("details_id");
                int salary = resultSet.getInt("salary");
                String city = resultSet.getString("city");
                int department_id = resultSet.getInt("department_id");
                String department_name = resultSet.getString("department_name");
                Payload payload = new Payload(employee_id,firstname,lastname,details_id,salary,city,department_id,department_name);
                results.add(payload);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
