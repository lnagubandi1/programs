public class EmployeeObject {
    int emp_id;
    String emp_name;
    int emp_age;
    String emp_gender;
    String emp_dep;
    int year_of_joining;
    double emp_salary;


    public EmployeeObject(int emp_id, String name, int age, String gender, String department, int year_of_joining,
                          double salary) {
        this.emp_id = emp_id;
        this.emp_name = name;
        this.emp_age = age;
        this.emp_gender = gender;
        emp_dep = department;
        this.year_of_joining = year_of_joining;
        this.emp_salary = salary;
    }


    public int getEmp_id() {
        return emp_id;
    }


    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }


    public String getEmp_name() {
        return emp_name;
    }


    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }


    public int getEmp_age() {
        return emp_age;
    }


    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }


    public String getEmp_gender() {
        return emp_gender;
    }


    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }


    public String getEmp_dep() {
        return emp_dep;
    }


    public void setEmp_dep(String emp_dep) {
        this.emp_dep = emp_dep;
    }


    public int getYear_of_joining() {
        return year_of_joining;
    }


    public void setYear_of_joining(int year_of_joining) {
        this.year_of_joining = year_of_joining;
    }


    public double getEmp_salary() {
        return emp_salary;
    }


    public void setEmp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }


}