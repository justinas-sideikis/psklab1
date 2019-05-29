package psklab1.cdi;

import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Stateless
public class TimestampLoggerImpl implements TimestampLogger {
    @Override
    public void logTimestamp() {
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
    }
}
