import org.riversun.promise.Promise;
import service.EmployerService;

public class PromiseTest {

  public static void main(String[] args) {
    EmployerService service = EmployerService.getInstance();

    Promise.resolve("Something")
        .then(new Promise((action, data) -> System.out.println(service.getCompanyData().getName())))
        .then(new Promise((action, data) -> System.out.println("Here is the action -> " + action)))
        .then(new Promise((action, data) -> System.out.println("Here is the data -> " + data)))
        .then(new Promise((action, data) -> System.out.println(service.getEmployeeData().getName())))
        .then(new Promise((action, data) -> System.out.println(service.getEmployerData().getName())))
        .start();
    System.out.println("Using Promise in Java");
  }
}
