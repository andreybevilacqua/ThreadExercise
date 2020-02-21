import model.Order;
import model.OrderWithString;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static model.OrderWithString.*;

public class CompletableFutureOrder {

  public static void main(String[] args) {
    for(int i = 0; i < 1; i++) {

      // The new thread created on .supplyAsync will execute all subsequent methods in the chain
      CompletableFuture.supplyAsync(OrderWithString::getNewOrder)
          .thenApply(string -> Order.fetchOrder())
          .thenApply(string -> Order.enrichOrder())
          .thenApply(string -> Order.payment())
          .thenApply(string -> Order.dispatch())
          .thenApplyAsync(string -> Order.dispatch()) // this one will run on another thread.
          .thenAccept(string -> System.out.println(Order.sendEmail()));

      ExecutorService cpuBound = Executors.newFixedThreadPool(4);
      ExecutorService ioBound = Executors.newCachedThreadPool();

      CompletableFuture.supplyAsync(OrderWithString::new, ioBound) // run it in my ioBound thread pool
          .thenApplyAsync(string -> {
            System.out.println(fetchOrder());
            return fetchOrder();
            }, cpuBound) // here run it in my other cpuBound thread pool
          .thenApplyAsync(string -> {
            System.out.println(enrichOrder());
            return enrichOrder();
            }, cpuBound)
          .thenApplyAsync(string -> {
            System.out.println(payment());
            return payment();
            }, cpuBound)
          .thenApplyAsync(string -> {
            System.out.println(dispatch());
            return dispatch();
            }, cpuBound)
          .thenAccept(string -> System.out.println(sendEmail()));
    }
  }
}
