package model;

public class OrderWithString {

  public static Order getNewOrder() { return new Order(); }

  public String fetchOrder() {
    return "Fetching the order";
  }

  public String enrichOrder() {
    return "Enrich the order";
  }

  public String payment() {
    return "Paying";
  }

  public String dispatch() {
    return "Dispatching";
  }

  public String sendEmail() {
    return "Sending email";
  }
}
