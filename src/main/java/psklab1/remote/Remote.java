package psklab1.remote;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
@Asynchronous
public class Remote implements Serializable, Remot {

    @Futureable
    public Future<Integer> updateInRemote() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
        }
        final Integer remoteSystemID = new Random().nextInt(100);
        return new AsyncResult<>(remoteSystemID);
    }
}
