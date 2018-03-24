package log4j;
import org.apache.log4j.Logger;
public class log4jtest {
    private static Logger logger = Logger.getLogger(log4jtest.class);
    public static void main(String[] args) {

        // 记录debug级别的信息
        logger.debug("这里是DEBUG信息");
        // 记录info级别的信息
        logger.info("这里是INFO信息.");
        // 记录error级别的信息
        logger.error("这里是ERROR信息");
    }
}
