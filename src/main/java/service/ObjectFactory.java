package service;

import model.Company;
import model.Employee;
import model.Employer;

import java.util.Collections;

public class ObjectFactory {

  public static Employer createEmployer() {
    return new Employer(createCompany(), "Employer name", Collections.singletonList(createEmployee()));
  }

  public static Company createCompany() {
    return new Company("Company name", "Company address");
  }


  public static Employee createEmployee() {
    return new Employee("Employee name", 25);
  }
}
