package com.revature.utils;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LogUtil {
	public static void logException(Exception e, Class<?> c) {
		Logger log = Logger.getLogger(c);
		log.error(e.getClass()+": "+e.getMessage());
		for(StackTraceElement s : e.getStackTrace()) {
			log.warn(s.getLineNumber()+": "+s.getClassName());
		}
	}
	public static void rollback(Exception e, Connection conn, Class<?> c) {
		logException(e, c);
		try {
			conn.rollback();
		} catch (Exception e1) {
			logException(e1, c);
		}
	}
}
