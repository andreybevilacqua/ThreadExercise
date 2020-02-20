import model.Order;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureOrder {

  public static void main(String[] args) {
    for(int i = 0; i < 100; i++) {

      CompletableFuture.supplyAsync(Order::fetchOrder)
          .thenApply(stringCallable -> Order.enrichOrder())
          .thenApply(stringCallable -> Order.payment())
          .thenApply(stringCallable -> Order.dispatch())
          .thenAccept(stringCallable -> System.out.println(Order.sendEmail()));
    }
  }
}
