package lukaszkutylowski.model;

public class Payload {

    private int employee_id;
    private String firstname;
    private String lastname;
    private int details_id;
    private int salary;
    private String city;
    private int department_id;
    private String department;

    public Payload(){}

    public Payload(String firstname, String lastname, int salary, String city, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.city = city;
        this.department = department;
    }

    public Payload(int employee_id, String firstname, String lastname, int details_id, int salary, String city, int department_id, String department) {
        this.employee_id = employee_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.details_id = details_id;
        this.salary = salary;
        this.city = city;
        this.department_id = department_id;
        this.department = department;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getDetails_id() {
        return details_id;
    }

    public void setDetails_id(int details_id) {
        this.details_id = details_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
