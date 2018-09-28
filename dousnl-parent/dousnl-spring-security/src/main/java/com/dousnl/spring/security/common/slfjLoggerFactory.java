package com.dousnl.spring.security.common;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class slfjLoggerFactory {

    private static final Map<String, slfjLogger> loggers = new HashMap<String, slfjLogger>();
    private final String name;

    public slfjLoggerFactory(String name) {
        this.name = name;
    }

    synchronized public static Logger getLogger(String name) {
        slfjLogger log = loggers.get(name);
        if (log == null) {
            log = new slfjLogger(name);
            loggers.put(name, log);
        }
        return log;
    }

    public Map<String, slfjLogger> getLoggers() {
        return loggers;
    }

    public String getName() {
        return name;
    }

}
