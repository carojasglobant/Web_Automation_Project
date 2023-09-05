package org.saucedemo;

import org.slf4j.LoggerFactory;

public class Reporter {
   private static org.slf4j.Logger getLogger() { return LoggerFactory.getLogger(Reporter.class); }

   public static void logInfo(String text) { getLogger().info(text); }

   public static void logError(String text) { getLogger().error(text); }

   public static void logWarning(String text) { getLogger().warn(text); }
}
