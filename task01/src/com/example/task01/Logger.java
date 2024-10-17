package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger {
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String Name;
    private ErrorLevel Level;

    public Logger(String name) {
        Name = name;
        Level = ErrorLevel.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, ErrorLevel level) {
        Name = name;
        Level = level;
        loggers.put(name, this);
    }

    public static Logger getLogger(String name) {
        if (loggers.get(name) == null) loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public String getName() {
        return Name;
    }

    public ErrorLevel getLevel() {
        return Level;
    }

    public void setLevel(ErrorLevel level) {
        Level = level;
    }

    public void log(ErrorLevel level, String message) {
        if (Level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printMessage = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, Name, message);
            System.out.println(printMessage);
        }
    }

    public void log(ErrorLevel level, String format, Object... objects) {
        if (Level.ordinal() <= level.ordinal()) System.out.println(MessageFormat.format(format, objects));
    }

    public void debug(String message) {
        log(ErrorLevel.DEBUG, message);
    }

    public void debug(String format, Object... objects) {
        log(ErrorLevel.DEBUG, format, objects);
    }

    public void info(String message) {
        log(ErrorLevel.INFO, message);
    }

    public void info(String format, Object... objects) {
        log(ErrorLevel.INFO, format, objects);
    }

    public void warning(String message) {
        log(ErrorLevel.WARNING, message);
    }

    public void warning(String format, Object... objects) {
        log(ErrorLevel.WARNING, format, objects);
    }

    public void error(String message) {
        log(ErrorLevel.ERROR, message);
    }

    public void error(String format, Object... objects) {
        log(ErrorLevel.ERROR, format, objects);
    }
}