package com.citi.dde.common.logger;

import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import java.util.Calendar;

/**
 * This class is used to logger for DFP application
 * 
 * @author jn94625
 *
 */
public class DFPLogger {

	private static DFPLogger instance = null;

	public static Properties props = null;

	private DFPLogger() {
		super();
	}

	/*********************************************************************************************************/

	public static DFPLogger getInstance() {
		synchronized (instance) {
			if (instance == null)
				instance = new DFPLogger();
			return instance;
		}
	}

	/*********************************************************************************************************/
	public static void logDebug(Class callingObject, String debugMessage) {
		log(callingObject, null, debugMessage, null, Level.DEBUG);
	}

	/*********************************************************************************************************/
	public static void logInfo(Class callingObject, String message) {
		log(callingObject, null, message, null, Level.INFO);
	}

	/*********************************************************************************************************/
	public static void logWarn(Class callingObject, String message) {
		log(callingObject, null, message, null, Level.WARN);
	}

	/*********************************************************************************************************/
	public static void logError(Class callingObject, Throwable thrown, String debugMessage) {
		log(callingObject, null, debugMessage, thrown, Level.ERROR);
	}

	/*********************************************************************************************************/
	public static void logFatal(Class callingObject, Throwable thrown, String methodName, String logStatement) {
		log(callingObject, methodName, logStatement, thrown, Level.FATAL);
	}

	/*********************************************************************************************************/
	private static void log(Class callingObject, String methodName, String logStatement, Throwable thrown,
			Priority priority) {

		if (callingObject == null) {
			callingObject = (new Object()).getClass();
		}
		Logger logger = getLogger(callingObject);

		if (logger.isEnabledFor(priority)) {
			StringBuffer loggedMessage = (new StringBuffer()).append(Calendar.getInstance().getTime()).append(" ")
					.append(callingObject).append(" --> ").append(logStatement);
			if (thrown == null) {
				logger.log(priority, loggedMessage.toString());
			} else {
				logger.log(priority, loggedMessage.toString(), thrown);
			}
		}
	}

	/*********************************************************************************************************/
	private static Logger getLogger(Class callingObject) {
		Logger logger = LoggerFactory.getService(callingObject);
		return logger;
	}
	/*********************************************************************************************************/
}
