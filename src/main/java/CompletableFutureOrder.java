import model.Order;
import model.OrderWithString;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureOrder {

  public static void main(String[] args) {
    for(int i = 0; i < 100; i++) {

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
          .thenApplyAsync(string -> Order.fetchOrder(), cpuBound) // here run it in my other cpuBound thread pool
          .thenApplyAsync(string -> Order.enrichOrder(), cpuBound)
          .thenApplyAsync(string -> Order.payment(), cpuBound)
          .thenApplyAsync(string -> Order.dispatch(), cpuBound)
          .thenAccept(string -> System.out.println(Order.sendEmail()));
    }
  }
}
