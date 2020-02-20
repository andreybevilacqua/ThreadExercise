package model;

import java.util.concurrent.Callable;

public class Order {

  public static Order getNewOrder() { return new Order(); }

  public static Callable<String> fetchOrder() {
    return () -> "Fetching the order";
  }

  public static Callable<String> enrichOrder() {
    return () -> "Enrich the order";
  }

  public static Callable<String> payment() {
    return () -> "Paying";
  }

  public static Callable<String> dispatch() {
    return () -> "Dispatching";
  }

  public static Callable<String> sendEmail() {
    return () -> "Sending email";
  }
}
