package psklab1.cdi;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.time.LocalDateTime;

@Alternative
@Stateless
public class DateLoggerImpl implements TimestampLogger {
    @Override
    public void logTimestamp() {
        System.out.println(LocalDateTime.now().toString());
    }
}
