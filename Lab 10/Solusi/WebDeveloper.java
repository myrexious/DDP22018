public class WebDeveloper extends Employee {

    /**
     * Constructor of the Web developer class employee
     * @param name the name of the employee
     * @param workHour the work hour of the employee
     * @param role the role of the employee
     * @param status the status of the employee
     */
    public WebDeveloper(String name, int workHour, String role, String status) {
        super(name, workHour,role, status);
        this.salary = 40;
        // TODO set the salary per hour based on the problem description
    }
}
