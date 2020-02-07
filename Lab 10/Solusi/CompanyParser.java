import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class CompanyParser.
 *
 * This class contains the function to parse the CSV file into a Company object with all the employees.
 */
public class CompanyParser {
    
    private static final String COMMA_DELIMITER = ",";

    /**
     * Method to parse CSV file into a Menu object.
     * The CSV format accepted by this function is:
     * emp_name,work_hour,job_role,stats
     *
     * @param filename (String) CSV input file name;
     * @return Company object with all the employees within the given file.
     * @throws IOException
     */
    public static Company parseCompany(String filename) throws IOException {
        Company company = new Company();
        try{
            
            BufferedReader file = new BufferedReader(new FileReader(filename));
            file.readLine();
            ArrayList<String[]> fileLine = new ArrayList<>();
            while(true){
                String temp = file.readLine();
                if(temp==null){
                    break;
                } else {
                    fileLine.add(temp.split(COMMA_DELIMITER));
                }
            }
            
            for(String[] emp : fileLine){
                if(emp[2]=="Web Developer"){
                    company.addEmployee(new WebDeveloper(emp[0], Integer.parseInt(emp[1]), emp[2], emp[3]));
                } else if(emp[2]=="UI/UX Designer"){
                    company.addEmployee(new UIUXDesigner(emp[0], Integer.parseInt(emp[1]), emp[2], emp[3]));
                } else {
                    company.addEmployee(new AssemblerProgrammer(emp[0], Integer.parseInt(emp[1]), emp[2], emp[3]));
                }
        }
        return company;
            
        } catch (IOException e) {
            System.out.println("File tak ditemukan.");
            return null;
        }
        /**
         * TODO implement this method.
         * Create a Company object.
         * Read the file content with BufferedReader and FileReader (see material section for hints).
         * For each line read except the first line, 
         * create an appropriate object (AssemblerProgrammer, UIUXDesigner, or WebDeveloper) from the given info.
         * Then, add the object to the company object's list of employees. HINT: use addEmployee() method.
         */
    }
}
