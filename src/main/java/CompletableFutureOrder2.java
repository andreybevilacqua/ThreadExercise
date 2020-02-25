import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureOrder2 {

  public static void main(String[] args) {
    System.out.println("Starting process...");
    CompletableFuture
        .supplyAsync(() -> longNetworkProcess(3000)) // execute here my process in a separate async thread
        .thenAccept(integer -> System.out.println("The result is: " + integer));
    System.out.println("Ending process...");

    System.out.println("Sleep a bit to see the result...");
    sleepABit();

    System.out.println("Running now a process that doesn't return anything");
    CompletableFuture.runAsync(() -> veryLongNetworkProcess(3000));
    sleepABit();
  }

  @SneakyThrows
  static int longNetworkProcess(int value) {
    System.out.println("Thread of the long net process: " + Thread.currentThread());
    Thread.sleep(value);
    return value * 10;
  }

  @SneakyThrows
  static void veryLongNetworkProcess(int value) {
    System.out.println("Thread of the very long net process: " + Thread.currentThread());
    Thread.sleep(value);
    System.out.println("Finished the very long network process");
  }

  @SneakyThrows
  private static void sleepABit() {
    Thread.sleep(4000);
  }
}
