package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DeleteService {

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

    private static final String DELETE_EMPLOYEE =
            "DELETE FROM employee WHERE employee_id = %d;";

    private static final String DELETE_DETAILS =
            "DELETE FROM details WHERE details_id = %d;";

    private static final String DELETE_DEPARTMENT =
            "DELETE FROM department WHERE department_id = %d;";

    public static Payload delete(int id) {
        String deleteEmployee = String.format(DELETE_EMPLOYEE, id);
        String deleteDetails = String.format(DELETE_DETAILS, id + 100);
        String deleteDepartment = String.format(DELETE_DEPARTMENT, id + 200);

        List<String> queries = Arrays.asList(deleteEmployee, deleteDetails, deleteDepartment);
        DbQueryExecutor.executeQueryInOneTransaction(queries);

        String checkDeleted = String.format(SELECT_BY_ID, id);
        ResultSet resultSet = DbQueryExecutor.executeSelect(checkDeleted);

        try {
            if (!resultSet.next()) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return GetByIdService.getById(id);
    }
}
