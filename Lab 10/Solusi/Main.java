import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * Class Main
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String filename = "data_karyawan.csv";
        Company company = null;
        try {
            company = CompanyParser.parseCompany(filename);
        } catch (IOException e) {
            System.out.println("File data_karyawan not found");
            return;
        }
        List<Employee> all = company.allEmployee();
        List<Employee> filterSalary = company.filterSalary(500);
        List<Employee> filterOverHours = company.filterOverHours();

        writeToFile("all.txt", getContentString(all));
        writeToFile("filterSalary.txt", getContentString(filterSalary));
        writeToFile("overperformedEmployees.txt", getContentString(filterOverHours));
    }

    /**
     * Method to get the result string from the list
     * @param employees the list that will be converted to result string
     * @return the result string
     */
    private static String getContentString(List<Employee> employees) {
        StringBuilder result = new StringBuilder();
        double totalCost = 0;
        for (Employee employee: employees) {
            result.append(employee).append("\n");
            totalCost += employee.getTotalSalary();
            // TODO update the value of totalCost.
        }
        result.append("Total cost : " + totalCost);
        // TODO append the result with the total cost info. HINT: see example output.
        return result.toString();
    }

    /**
     * Method to write a string to a file
     * @param fileName the filename that will be created
     * @param content the content that want to be written
     */
    private static void writeToFile(String fileName, String content) throws FileNotFoundException {
        File files = new File(fileName);
        PrintWriter write = new PrintWriter(files);
        write.println(content);
        write.close();
        /**
         * TODO implement this method
         * Write the content from the given parameter 
         * to a file which name is the fileName (see material section for hints).
         */
    }
}
