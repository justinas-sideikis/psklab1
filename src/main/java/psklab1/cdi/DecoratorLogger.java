package psklab1.cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.logging.Logger;

@Decorator
public class DecoratorLogger implements TimestampLogger {
    @Inject @Delegate
    TimestampLogger logger;

    @Override
    public void logTimestamp() {
        System.out.println("Time will be logged");
        logger.logTimestamp();
    }
}
