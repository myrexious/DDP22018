public class AssemblerProgrammer extends Employee {
    
    /**
     * Constructor of the Assembler Programmer class employee
     * @param name the name of the employee
     * @param workHour the work hour of the employee
     * @param role the role of the employee
     * @param status the status of the employee
     */
    public AssemblerProgrammer(String name, int workHour, String role, String status) {
        super(name, workHour, role, status);
        this.salary = 100;
        // TODO set the salary per hour based on the problem description
    }
}
