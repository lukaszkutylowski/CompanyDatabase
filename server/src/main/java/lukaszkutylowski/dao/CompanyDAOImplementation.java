package lukaszkutylowski.dao;

import lukaszkutylowski.database.DbQueryExecutor;
import lukaszkutylowski.model.Payload;
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

    private static final String SELECT_DEPARTMENT_ID =
            "SELECT department_id FROM department WHERE department_name = '%s';";

    private static final String SELECT_DETAILS_ID =
            "SELECT details_id FROM details WHERE department_id = '%d';";

    private static final String PUT_DEPARTMENT =
            "INSERT INTO department (department_name) VALUES ('%s');";

    private static final String PUT_DETAILS =
            "INSERT INTO details (salary, city, department_id) VALUES (%d, '%s', %d);";

    private static final String PUT_EMPLOYEE =
            "INSERT INTO employee (firstname, lastname, details_id) VALUES ('%s', '%s', %d);";

    @Override
    public List<Payload> get() {
        ResultSet resultSet = DbQueryExecutor.executeSelect(SELECT_ALL);
        List<Payload> results = new ArrayList<>();

        try {
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstName");
                String lastname = resultSet.getString("lastName");
                int salary = resultSet.getInt("salary");
                String city = resultSet.getString("city");
                String department = resultSet.getString("department_name");
                Payload payload = new Payload(firstname,lastname,salary,city,department);
                results.add(payload);
            }
        } catch (SQLException e) {}

        return results;
    }

    @Override
    public Payload save(Payload payload) {

        String firstname = payload.getFirstname();
        String lastname = payload.getLastname();
        int salary = payload.getSalary();
        String city = payload.getCity();
        String department = payload.getDepartment();

        String putDepartmentQuery = String.format(PUT_DEPARTMENT, department);
        DbQueryExecutor.executeQuery(putDepartmentQuery);

        String selectDepartmentId = String.format(SELECT_DEPARTMENT_ID, department);
        ResultSet results = DbQueryExecutor.executeSelect(selectDepartmentId);
        int department_id = 0;
        try {
            results.next();
            department_id = results.getInt("department_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String putDetailsQuery = String.format(PUT_DETAILS, salary, city, department_id);
        DbQueryExecutor.executeQuery(putDetailsQuery);

        String selectDetailsId = String.format(SELECT_DETAILS_ID, department_id);
        results = DbQueryExecutor.executeSelect(selectDetailsId);
        int details_id = 0;
        try {
            results.next();
            details_id = results.getInt("details_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String putEmployeeQuery = String.format(PUT_EMPLOYEE, firstname, lastname, details_id);
        DbQueryExecutor.executeQuery(putEmployeeQuery);

        return payload;
    }
}
