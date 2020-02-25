package service;

import lombok.SneakyThrows;
import model.Company;
import model.Employee;
import model.Employer;

import java.util.concurrent.CompletableFuture;

import static service.ObjectFactory.*;
import static java.util.concurrent.CompletableFuture.completedFuture;

public final class EmployerService {

  private static final EmployerService INSTANCE = new EmployerService();

  private EmployerService(){}

  public static EmployerService getInstance(){return INSTANCE;}

  @SneakyThrows
  public CompletableFuture<Employer> getEmployerDataCompletableFuture() {
    System.out.println("Thread of this process: " + Thread.currentThread());
    Thread.sleep(2000);
    return completedFuture(createEmployer());
  }

  @SneakyThrows
  public CompletableFuture<Company> getCompanyDataCompletableFuture() {
    System.out.println("Thread of this process: " + Thread.currentThread());
    Thread.sleep(4000);
    return completedFuture(createCompany());
  }

  @SneakyThrows
  public CompletableFuture<Employee> getEmployeeDataCompletableFuture() {
    System.out.println("Thread of this process: " + Thread.currentThread());
    Thread.sleep(4000);
    return completedFuture(createEmployee());
  }

  public Employer getEmployerData() {
    try {
      Thread.sleep(2000);
      return createEmployer();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return createEmployer();
  }

  public Company getCompanyData() {
    try {
      Thread.sleep(4000);
      return createCompany();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return createCompany();
  }

  public Employee getEmployeeData() {
    try {
      Thread.sleep(4000);
      return createEmployee();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return createEmployee();
  }
}
