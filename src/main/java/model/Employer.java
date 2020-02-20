package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Employer {

  private final Company company;
  private final String name;
  private final List<Employee> employees;
}
