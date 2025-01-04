package FILE_IO;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static final String PAYROLL_FILE_NAME = "payroll-file.txt";

    // Write employee payroll data to file
    public void writeData(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String empDataString = employee.toString().concat("\n");
            empBuffer.append(empDataString);
        });

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // To read data
//    public List<EmployeePayrollData> readData(){
//        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
//        try {
//            Files.lines(new File("payroll-file.txt").toPath())
//                    .map(line -> line.trim())
//                    .forEach(line -> System.out.println(line));
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return employeePayrollDataList;
//    }

    // Print data from the file
    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Count the number of entries in the file
    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}
