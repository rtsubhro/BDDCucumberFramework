package utils;

import java.util.Date;

/*
 * Utility class for setting Date and Timestamp format
 */
public class DateUtils {

	public static String getTimeStamp() {

		Date date = new Date();

		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
