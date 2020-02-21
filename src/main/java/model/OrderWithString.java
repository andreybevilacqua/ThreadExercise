package model;

public class OrderWithString {

  public static Order getNewOrder() { return new Order(); }

  public static String fetchOrder() {
    return "Fetching the order";
  }

  public static String enrichOrder() {
    return "Enrich the order";
  }

  public static String payment() {
    return "Paying";
  }

  public static String dispatch() {
    return "Dispatching";
  }

  public static String sendEmail() {
    return "Sending email";
  }
}
