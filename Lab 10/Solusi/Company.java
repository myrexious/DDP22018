import java.util.ArrayList;
import java.util.List;

/**
 * Class Company
 *
 * This class' objects represent the Company containing all the employees that work there.
 */
public class Company {
    
    private ArrayList<Employee> employees;

    /**
     * Constructor of Company object
     */
    public Company() {
        this.employees = new ArrayList<>();
    }

    /**
     * Method to add employee to this company
     * @param employee the employee that want to be added
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Get all employees in Company
     * @return List<Employee> All Employees contained
     */
    public List<Employee> allEmployee() {
        return new ArrayList<>(employees);
    }

    /**
     *Get all employees that exceeded the param salary
     * @param salary Minimum salary as a filter
     * @return List<Employee> All Employees filtered and their salary exceeded the salary
     */
    public List<Employee> filterSalary(double salary) {
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getTotalSalary() > salary) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    /**
     * All employees that worked Over Hours
     * @return List<Employee> All Employees that worked over hours.
     */
    public List<Employee> filterOverHours() {
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getWorkHour() > employee.minimumWorkHour()) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
        /**
         * TODO implement this method
         * Get employees whose work hour is longer than their minimum work hour.
         * The implementation should be similar to filterSalary().
         */
    }
}
