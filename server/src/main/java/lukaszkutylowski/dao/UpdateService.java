package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateService {

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

    private static final String UPDATE_EMPLOYEE =
            "UPDATE employee SET firstname = '%s', lastname = '%s' WHERE employee_id = %d";

    private static final String UPDATE_DETAILS =
            "UPDATE details SET salary = %d, city = '%s' WHERE details_id = %d";

    private static final String UPDATE_DEPARTMENT =
            "UPDATE department SET department_name = '%s' WHERE department_id = %d";

    public static Payload update(Payload payload, int id) {
        String firstname = payload.getFirstname();
        String lastname = payload.getLastname();
        int salary = payload.getSalary();
        String city = payload.getCity();
        String department = payload.getDepartment();

        String updateEmployee = String.format(UPDATE_EMPLOYEE, firstname, lastname, id);
        String updateDetails = String.format(UPDATE_DETAILS, salary, city, id + 100);
        String updateDepartment = String.format(UPDATE_DEPARTMENT, department, id + 200);

        DbQueryExecutor.executeQuery(updateEmployee);
        DbQueryExecutor.executeQuery(updateDetails);
        DbQueryExecutor.executeQuery(updateDepartment);

        String checkUpdated = String.format(SELECT_BY_ID, id);
        ResultSet resultSet = DbQueryExecutor.executeSelect(checkUpdated);

        try {
            if (resultSet.next()) {
                return GetByIdService.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
