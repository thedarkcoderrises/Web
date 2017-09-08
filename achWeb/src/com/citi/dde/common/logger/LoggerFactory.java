package com.citi.dde.common.logger;


import java.util.HashMap;
import org.apache.log4j.Logger;
/**
 * This is supportive class for DFP logger
 * @author jn94625
 *
 */
public class LoggerFactory
{

	private static HashMap<Class,Logger> loggingServiceMap	=	new HashMap<Class,Logger>();
	private static Object loggingServiceSemaphore 			=	new Object();
	private static LoggerFactory instance 					=	null;

	private LoggerFactory()
	{
		super();
	}
/*********************************************************************************************************/

	public static LoggerFactory getInstance()
	{
		synchronized(instance)
		{
			if (instance == null)
				instance = new LoggerFactory();
			return instance;
		}
	}
/*********************************************************************************************************/

	/**
	 * Get an instance of the Service, if available from the Hashmap
	 * else create one and put into the HashMap for future reference avoiding
	 * loading of multiple instances
	 */
	public static Logger getService(Class clazz)
	{

		Logger logger = null;

		if (loggingServiceMap.containsKey(clazz))
		{
			logger = (Logger) loggingServiceMap
					.get(clazz);
		}
		else
		{
			synchronized (loggingServiceSemaphore)
			{
					logger = Logger.getLogger(clazz.getName());
					loggingServiceMap.put(clazz, logger);
			}
		}
		return logger;
	}
/*********************************************************************************************************/

}
