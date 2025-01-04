package FILE_IO;

import org.junit.Assert;
import org.junit.Test;
import static FILE_IO.EmployeePayrollService.IOService.FILE_IO;
import java.util.Arrays;

import static org.junit.Assert.*;

public class EmployeePayrollServiceTest {

    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries(){
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "Srinivas", 100000.0),
                new EmployeePayrollData(2, "Sirisha", 200000.0),
                new EmployeePayrollData(3, "Ashika", 300000.0)
        };

        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assert.assertEquals(3, entries);
    }

//    @Test
//    public void givenFileOnReadingFromShouldMatchEmployeeCount(){
//        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
//        long entries = employeePayrollService.readEmployeePayrollDataToTest(FILE_IO);
//        Assert.assertEquals(3, entries);
//    }

}
