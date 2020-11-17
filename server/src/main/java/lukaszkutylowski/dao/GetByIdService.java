package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetByIdService {

    private static final String SELECT_BY_ID =
                    "SELECT " +
                    "employee.employee_id, " +
                    "employee.firstname, " +
                    "employee.lastname, " +
                    "employee.details_id, " +
                    "details.salary, " +
                    "details.city, " +
                    "details.department_id, " +
                    "department.department_name " +
                    "FROM employee " +
                    "LEFT JOIN details " +
                    "ON employee.details_id = details.details_id " +
                    "LEFT JOIN department " +
                    "ON details.department_id = department.department_id " +
                    "WHERE employee_id = %d;";

    public static Payload getById(int id) {
        Payload payload = new Payload();

        String getById = String.format(SELECT_BY_ID, id);
        ResultSet resultSet = DbQueryExecutor.executeSelect(getById);

        try {
            resultSet.next();
            payload.setEmployee_id(resultSet.getInt("employee_id"));
            payload.setFirstname(resultSet.getString("firstname"));
            payload.setLastname(resultSet.getString("lastname"));
            payload.setDetails_id(resultSet.getInt("details_id"));
            payload.setSalary(resultSet.getInt("salary"));
            payload.setCity(resultSet.getString("city"));
            payload.setDepartment_id(resultSet.getInt("department_id"));
            payload.setDepartment(resultSet.getString("department_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payload;
    }
}
