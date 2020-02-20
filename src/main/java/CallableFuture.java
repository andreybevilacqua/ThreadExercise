import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static model.Order.*;

public class CallableFuture {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(10);

    try { // This will be a sequential operation, where each future has to wait until the previous one has finished.
      Future<String> future = service.submit(fetchOrder());
      String orderStatus = future.get(); // blocking

      Future<String> future1 = service.submit(enrichOrder());
      orderStatus = future1.get(); // blocking

      Future<String> future2 = service.submit(payment());
      orderStatus = future2.get(); // blocking

      Future<String> future3 = service.submit(dispatch());
      orderStatus = future3.get(); // blocking

      Future<String> future4 = service.submit(sendEmail());
      orderStatus = future4.get(); // blocking
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
