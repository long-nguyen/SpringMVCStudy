package co.au.vog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {
	private static final Logger logger = LoggerFactory.getLogger(Log.class);

	public static void d(String msg) {
		logger.debug(msg);
	}
	
	public static void i(String msg) {
		logger.info(msg);
	}
	
	public static void e(String msg) {
		logger.error(msg);
	}
}
