package org.nvadiga.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nvadiga on 10/6/2017.
 */
public class BaseLogger {
    public org.slf4j.Logger logger;

    public BaseLogger(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public void logInfo(String message){
        logger.info(message);
    }

    public void logDebug(String message){
        logger.debug(message);
    }

    public void logError(String message){
        logger.error(message);
    }
}
