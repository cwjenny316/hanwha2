package com.hanwha.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	public static Date transDate(String sdate) {
		Date sql_date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date d = sdf.parse(sdate);
			sql_date = new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return sql_date;
	}

}
