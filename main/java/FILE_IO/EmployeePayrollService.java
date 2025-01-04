package FILE_IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private List<EmployeePayrollData> employeePayrolllist;

    public EmployeePayrollService(){

    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrolllist){
        this.employeePayrolllist = employeePayrolllist;

    }

    public static void main(String args[]) {
        ArrayList<EmployeePayrollData> employeePayrolllist = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrolllist);
        Scanner sc = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(sc);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }
    public void readEmployeePayrollData(Scanner sc){

        System.out.println("Enter Employee ID : ");
        int id = sc.nextInt();

        System.out.println("Enter Employee Name : ");
        String name = sc.next();

        System.out.println("Enter Employee Salary : ");
        double salary = sc.nextDouble();

        employeePayrolllist.add(new EmployeePayrollData(id, name, salary));
    }

    //Read payroll data for testing
//    public long readEmployeePayrollDataToTest(IOService ioService){
//        if(ioService.equals(IOService.FILE_IO))
//            this.employeePayrolllist = new EmployeePayrollFileIOService().readData();
//        return employeePayrolllist.size();
//    }

    // Write employee data based on IO service
    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("Writing Employee Payroll Roster to Console:\n" + employeePayrolllist);
        } else if (ioService.equals(IOService.FILE_IO)) {
            new EmployeePayrollFileIOService().writeData(employeePayrolllist);
        }
    }

    // Print data from file
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            new EmployeePayrollFileIOService().printData();
        }
    }

    // Count entries in file
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO)) {
            return new EmployeePayrollFileIOService().countEntries();
        }
        return employeePayrolllist.size();
    }
}