package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    private final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logtest() {
        String name = "Spring";
        System.out.println("name = " + name);
        logger.info("info log={}", name);
        logger.trace("trace log={}", name);
        logger.debug("debug log={}", name);
        logger.info("info log={}", name);
        logger.warn("warn log={}", name);
        logger.error("error log={}", name);
        return "ok";
    }

}
