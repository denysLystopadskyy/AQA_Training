package Utils;

import org.apache.log4j.Logger;

/**
 * Created by denys.lystopadskyy on 6/9/2017.
 */
public class LogUtils {

    public static Logger logger = Logger.getLogger(LogUtils.class);

    public static void testStep(String message) {
        logger.info("Test step: " + message);
    }

    public static void info(String message) {
        logger.info(message);
    }
}
