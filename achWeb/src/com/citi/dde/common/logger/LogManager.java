package com.citi.dde.common.logger;

import java.io.File;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;

import com.citi.dde.common.exception.DFPException;

/**
 * This class is used to manage the log for DFP application
 * 
 * @author jn94625
 *
 */
public class LogManager {

	public LogManager() {
	}

	/**
	 * Find path and Loads "system.properties" file from "config" folder.
	 *
	 * @param class_parameters_map
	 *            contains file path.
	 * @param path
	 *            returns associated value with key.
	 * @throws DFPException
	 */
	public void create(Map<String, String> class_parameters_map, String path) throws DFPException {

		String propertyFile = path + File.separator + class_parameters_map.get("configfilename");
		init(propertyFile);
	}

	/*********************************************************************************************************/

	/**
	 * Default implementation.
	 */
	public void init() {
	}

	/*********************************************************************************************************/
	/**
	 * Loads all properties into static Properties file .
	 *
	 * @param fileName
	 *            returns associated value with key.
	 * @throws DFPException
	 */
	public void init(String fileName) throws DFPException {

		DOMConfigurator.configure(fileName);
		DFPLogger.logInfo(LogManager.class, "init::CS Log Manager :: Initialized");
	}
	/*********************************************************************************************************/
}
