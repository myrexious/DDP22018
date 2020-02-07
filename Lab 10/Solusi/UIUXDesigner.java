public class UIUXDesigner extends Employee {

    /**
     * Constructor of the UI/UX Designer class employee
     * @param name the name of the employee
     * @param workHour the work hour of the employee
     * @param role the role of the employee
     * @param status the status of the employee
     */
    public UIUXDesigner(String name, int workHour, String role,String status) {
        super(name, workHour,role, status);
        this.salary = 30;
        // TODO set the salary per hour based on the problem description
    }
}
