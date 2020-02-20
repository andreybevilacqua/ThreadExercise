package service;

import model.Order;

import java.util.concurrent.*;

public class Callable_Future {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(10);

    try { // This will be a sequential operation, where each future has to wait until the previous one has finished.
      Future<String> future = service.submit(Order.fetchOrder());
      String orderStatus = future.get(); // blocking

      Future<String> future1 = service.submit(Order.enrichOrder());
      orderStatus = future1.get(); // blocking

      Future<String> future2 = service.submit(Order.payment());
      orderStatus = future2.get(); // blocking

      Future<String> future3 = service.submit(Order.dispatch());
      orderStatus = future3.get(); // blocking

      Future<String> future4 = service.submit(Order.sendEmail());
      orderStatus = future4.get(); // blocking
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
