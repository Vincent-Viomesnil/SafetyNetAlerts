package com.safetynetalerts.webapp.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


public class TestLogger {

    private static Logger logger;

    @Test
    public void TestLogger(){
        logger = LogManager.getLogger(TestLogger.class);
        logger.debug("This is DEBUG");
        logger.error("This is ERROR");
    }
}
