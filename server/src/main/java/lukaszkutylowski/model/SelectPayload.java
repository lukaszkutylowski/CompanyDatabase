package lukaszkutylowski.model;

public class SelectPayload {
    private String firstname;
    private String lastname;
    private int salary;
    private String city;
    private String department;

    public SelectPayload(){}

    public SelectPayload(String firstname, String lastname, int salary, String city, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.city = city;
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
}
