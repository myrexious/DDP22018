/**
 * Abstract class Employee
 */
public abstract class Employee {
    
    private String name;
    private String role;
    protected int workHour;
    private String status;
    protected int salary;
    private static final int INTERN_MINIMUM_HOURS = 30;
    private static final int PART_TIME_MINIMUM_HOURS = 20;
    private static final int FULL_TIME_MINIMUM_HOURS = 40;
    protected static final double TAX_PERCENT = 0.15;
    protected static final double OVER_HOUR = 1.5;
    protected static final double BELOW_HOUR = 0.5;

    /**
     * Constructor of the abstract class employee
     * @param name the name of the employee
     * @param workHour the work hour of the employee
     * @param role the role of the employee
     * @param status the status of the employee
     */
    public Employee(String name, int workHour,String role, String status) {
        this.name = name;
        this.workHour = workHour;
        this.role = role;
        this.status = status;
    }

    
    /**
     * Count total salary based on their role and status
     * @return the salary
     */
    public double getTotalSalary() {
        double temp;
        if(this.getWorkHour() == this.minimumWorkHour()){
            temp = this.workHour*this.salary;
        } else if(this.getWorkHour() > this.minimumWorkHour()){
            temp = (this.minimumWorkHour()*this.salary) + ((this.workHour-this.minimumWorkHour()) * OVER_HOUR * this.salary);
        } else {
            temp = this.workHour * BELOW_HOUR * this.salary;
        }
        return temp * 0.85;
        /**
         * TODO implement this method --
         * Return the final salary based on the problem description.
         */
    }

    /**
     * Check the minimum hour the employee need to work
     * @return the minimum hour
     */
    public int minimumWorkHour() {
        if(this.status.equals("Part-time")){
            return PART_TIME_MINIMUM_HOURS;
        } else if(this.status.equals("Intern")){
            return INTERN_MINIMUM_HOURS;
        } else if(this.status.equals("Full-time")){
            return FULL_TIME_MINIMUM_HOURS;
        } else {
            return 0;
        }
        /**
         * TODO implement this method --
         * Check the job status of this object and 
         * return the appropriate minimum work hour based on the problem description.
         */
    }

    @Override
    public String toString() {
        return "[" + this.name + "]" + " - "
                + "[Work Hours: " + this.workHour + "]" + " - "
                + "[Job Role: " + this.role + "]" + " - "
                + "[Status: " + this.status + "]" + " - "
                + "[Salary: " + this.getTotalSalary() + "]";
    }

    public int getWorkHour() {
        return workHour;
    }
}
