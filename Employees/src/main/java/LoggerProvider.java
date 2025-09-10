import java.util.logging.Logger;

public class LoggerProvider {
    private static final Logger logger = Logger.getLogger("GlobalLogger");

    public static Logger getLogger() {
        return logger;
    }
}
