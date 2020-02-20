import model.Company;
import model.Employee;
import model.Employer;
import service.EmployerService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static service.EmployerService.getInstance;

public class CompletableFutureTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    EmployerService service = getInstance();

    CompletableFuture<Employer> employerCompletableFuture = service.getEmployerDataCompletableFuture();
    System.out.println("1");
    CompletableFuture<Company> companyCompletableFuture = service.getCompanyDataCompletableFuture();
    System.out.println("2");
    CompletableFuture<Employee> employeeCompletableFuture = service.getEmployeeDataCompletableFuture();
    System.out.println("3");

    CompletableFuture.allOf(employerCompletableFuture, companyCompletableFuture, employeeCompletableFuture).join();

    System.out.println("Employer name: ---> " + employerCompletableFuture.get().getName());
    System.out.println("Company name: ---> " + companyCompletableFuture.get().getName());
    System.out.println("Employee name: ---> " + employeeCompletableFuture.get().getName());
  }
}
