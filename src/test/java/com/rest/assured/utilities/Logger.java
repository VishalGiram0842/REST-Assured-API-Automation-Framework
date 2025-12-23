package com.rest.assured.utilities;

import org.slf4j.LoggerFactory;

/**
 * Logger utility class for REST API Automation Framework
 * Provides logging methods for test execution tracking
 */
public class Logger {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);
    
    /**
     * Log info level messages
     * @param message the message to log
     */
    public static void info(String message) {
        LOGGER.info(message);
        System.out.println("[INFO] " + message);
    }
    
    /**
     * Log debug level messages
     * @param message the message to log
     */
    public static void debug(String message) {
        LOGGER.debug(message);
        System.out.println("[DEBUG] " + message);
    }
    
    /**
     * Log warning level messages
     * @param message the message to log
     */
    public static void warn(String message) {
        LOGGER.warn(message);
        System.out.println("[WARN] " + message);
    }
    
    /**
     * Log error level messages
     * @param message the message to log
     */
    public static void error(String message) {
        LOGGER.error(message);
        System.out.println("[ERROR] " + message);
    }
    
    /**
     * Log error level messages with exception
     * @param message the message to log
     * @param exception the exception to log
     */
    public static void error(String message, Exception exception) {
        LOGGER.error(message, exception);
        System.out.println("[ERROR] " + message + " - " + exception.getMessage());
    }
    
    /**
     * Log test step execution
     * @param stepName the name of the test step
     */
    public static void testStep(String stepName) {
        LOGGER.info("\n========== " + stepName + " ==========");
        System.out.println("\n========== " + stepName + " ==========");
    }
    
    /**
     * Log API request details
     * @param method HTTP method
     * @param endpoint API endpoint
     * @param requestBody request body
     */
    public static void logRequest(String method, String endpoint, String requestBody) {
        info("REQUEST METHOD: " + method);
        info("REQUEST ENDPOINT: " + endpoint);
        if (requestBody != null && !requestBody.isEmpty()) {
            info("REQUEST BODY: " + requestBody);
        }
    }
    
    /**
     * Log API response details
     * @param statusCode HTTP status code
     * @param responseBody response body
     */
    public static void logResponse(int statusCode, String responseBody) {
        info("RESPONSE STATUS CODE: " + statusCode);
        info("RESPONSE BODY: " + responseBody);
    }
    
    /**
     * Log assertion result
     * @param message assertion message
     */
    public static void logAssertion(String message) {
        info("ASSERTION: " + message);
    }
}
