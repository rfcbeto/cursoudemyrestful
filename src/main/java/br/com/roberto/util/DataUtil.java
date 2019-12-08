package br.com.roberto.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String ddMMyyyhhmmss() {
		String pattern = "dd/MM/yyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());
	}
	
	public static String ddMMyyyhhmmss24H() {
		String pattern = "dd/MM/yyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());
	}
}
