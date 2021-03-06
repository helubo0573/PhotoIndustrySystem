package com.stone.photoindustry.core.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtil extends tool.util.DateUtil
{

	@SuppressWarnings("deprecation")
	public static Date dateAddMins(Date date, int minCnt)
	{
		Date d = new Date(date.getTime());
		d.setMinutes(d.getMinutes() + minCnt);
		return d;
	}

	public static int minuteBetween(Date date1, Date date2)
	{
		DateFormat sdf = new SimpleDateFormat(DATEFORMAT_STR_001);
		Calendar cal = Calendar.getInstance();
		try
		{
			Date d1 = sdf.parse(DateUtil.dateStr4(date1));
			Date d2 = sdf.parse(DateUtil.dateStr4(date2));
			cal.setTime(d1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(d2);
			long time2 = cal.getTimeInMillis();
			return Integer.parseInt(String.valueOf((time2 - time1) / 60000));
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public static Date getDayStartTime(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
		return cal.getTime();
	}

	public static Date getDayEndTime(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
		return cal.getTime();
	}

	public static Date parse(String date, String type)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(type);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(date, pos);
		return strtodate;

	}

	public static List<Date> dateSplit(Date startDate, Date endDate) throws Exception
	{
		if (!startDate.before(endDate))
			throw new Exception("开始时间应该在结束时间之后");
		Long spi = endDate.getTime() - startDate.getTime();
		Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

		List<Date> dateList = new ArrayList<Date>();
		dateList.add(endDate);
		for (int i = 1; i <= step; i++)
		{
			dateList.add(new Date(dateList.get(i - 1).getTime() - (24 * 60 * 60 * 1000)));// 比上一天减一
		}
		return dateList;
	}

	public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException
	{
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max))
		{
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}

		return result;
	}

	@SuppressWarnings("static-access")
	public static Date getDateBefore(int day, Date date)
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, day);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime();
		return date;
	}

	@SuppressWarnings("deprecation")
	public static Date dateAddDays(Date date, int days)
	{
		Date d = new Date(date.getTime());
		d.setDate(d.getDate() + days);
		return d;
	}

	public static String dateStr(String millisecond, String fmt)
	{
		Date date = new Date();
		date.setTime(Long.valueOf(millisecond));
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);// 格式化为年月
		return sdf.format(date);
	}
}
