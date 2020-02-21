package model;

public class OrderWithString {

  public static Order getNewOrder() { return new Order(); }

  public static String fetchOrder() {
    sleep(2000);
    return "Fetching the order";
  }

  public static String enrichOrder() {
    sleep(2000);
    return "Enrich the order";
  }

  public static String payment() {
    sleep(2000);
    return "Paying";
  }

  public static String dispatch() {
    sleep(2000);
    return "Dispatching";
  }

  public static String sendEmail() {
    sleep(4000);
    return "Sending email";
  }

  private static void sleep(int i) {
    try {
      Thread.sleep(i);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
