package service;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest3 {

  public static void main(String[] args) {
    CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
    int value = 8;

    getReady(completableFuture);
    completableFuture.complete(value);
  }

  public static void getReady(CompletableFuture<Integer> future) {
    future.thenApply(integer -> integer * 5)
        .thenApply(integer -> integer + 20)
        .thenAccept(System.out::println);
  }
}
