package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveService {

    private static final String SELECT_DEPARTMENT_ID =
            "SELECT department.department_id FROM department WHERE department_name = '%s';";

    private static final String SELECT_DETAILS_ID =
            "SELECT details.details_id FROM details WHERE details.department_id = '%d';";


    private static final String PUT_DEPARTMENT =
            "INSERT INTO department (department_name) VALUES ('%s');";

    private static final String PUT_DETAILS =
            "INSERT INTO details (salary, city, department_id) VALUES (%d, '%s', %d);";

    private static final String PUT_EMPLOYEE =
            "INSERT INTO employee (firstname, lastname, details_id) VALUES ('%s', '%s', %d);";

    private static final String SELECT_BY_IDS =
                    "SELECT * " +
                    "FROM employee " +
                    "JOIN details " +
                    "ON employee.details_id = details.details_id " +
                    "JOIN department " +
                    "ON details.department_id = department.department_id " +
                    "WHERE details.details_id = %d " +
                    "AND department.department_id = %d;";

    public static Payload save(Payload payload) {
        String firstname = payload.getFirstname();
        String lastname = payload.getLastname();
        int salary = payload.getSalary();
        String city = payload.getCity();
        String department = payload.getDepartment();

        putDepartment(department);

        int department_id = getDepartmentId(department);

        putDetails(salary, city, department_id);

        int details_id = getDetailsId(department_id);
        
        putEmployee(firstname, lastname, details_id);

        return checkSavedPayload(department_id, details_id);
    }

    private static void putDepartment(String department) {
        String putDepartmentQuery = String.format(PUT_DEPARTMENT, department);
        DbQueryExecutor.executeQuery(putDepartmentQuery);
    }

    private static int getDepartmentId(String department) {
        ResultSet results;
        String selectDepartmentId = String.format(SELECT_DEPARTMENT_ID, department);
        results = DbQueryExecutor.executeSelect(selectDepartmentId);
        int department_id = 0;
        try {
            results.next();
            department_id = results.getInt("department_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department_id;
    }

    private static void putDetails(int salary, String city, int department_id) {
        String putDetailsQuery = String.format(PUT_DETAILS, salary, city, department_id);
        DbQueryExecutor.executeQuery(putDetailsQuery);
    }

    private static int getDetailsId(int department_id) {
        ResultSet results;
        String selectDetailsId = String.format(SELECT_DETAILS_ID, department_id);
        results = DbQueryExecutor.executeSelect(selectDetailsId);
        int details_id = 0;
        try {
            results.next();
            details_id = results.getInt("details_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details_id;
    }

    private static void putEmployee(String firstname, String lastname, int details_id) {
        String putEmployeeQuery = String.format(PUT_EMPLOYEE, firstname, lastname, details_id);
        DbQueryExecutor.executeQuery(putEmployeeQuery);
    }

    private static Payload checkSavedPayload(int department_id, int details_id) {
        Payload savedPayload = null;
        String selectByIds = String.format(SELECT_BY_IDS, details_id, department_id);
        ResultSet resultSet = DbQueryExecutor.executeSelect(selectByIds);
        try {
            resultSet.next();
            int id = resultSet.getInt("employee_id");
            savedPayload = GetByIdService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedPayload;
    }
}
