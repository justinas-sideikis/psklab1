package psklab1.remote;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ApplicationScoped
@Asynchronous
public class Remote implements Serializable, Remot {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @Futureable
    public Future<Integer> updateInRemote() {
        return executor.submit(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return new Random().nextInt(100);
        });
    }
}
