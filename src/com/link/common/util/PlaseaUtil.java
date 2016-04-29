package com.link.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * 一些常用方法工具类
 * @author 朱素海
 *
 */
public class PlaseaUtil {

	/**
	 * 从session里取值
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getStringValueFromSession(HttpServletRequest request,String name){
		
		Object v = request.getSession().getAttribute(name);
		if(v == null){
			return null;
		}else{
			return (String)v;
		}
		
	}
	
	public static Integer getIntValueFromSession(HttpServletRequest request,String name){
		
		Object v = request.getSession().getAttribute(name);
		if(v == null){
			return null;
		}else{
			return (Integer)v;
		}
		
	}
	
	/**
	 * 判断string是否为空或空字符串
	 * @param string
	 * @return 是返回true，否则false
	 */
	public static boolean isNullOrNullString(String string){
		if(string == null || string.length() == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断两个日期是否是同一天
	 * @param d1
	 * @param d2
	 */
	public static boolean isSameDay(Calendar d1,Calendar d2){
		if(d1.get(Calendar.YEAR) == d2.get(Calendar.YEAR)
				&& d1.get(Calendar.MONTH) == d2.get(Calendar.MONTH)
				&& d1.get(Calendar.DATE ) == d2.get(Calendar.DATE )){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断两个日期是否是同一年
	 * @param d1
	 * @param d2
	 */
	public static boolean isSameYear(Calendar d1,Calendar d2){
		if(d1.get(Calendar.YEAR) == d2.get(Calendar.YEAR)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {

		Date d1 = new Date();
		
		try {
			Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-04-09");
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);
			System.out.println(isSameDay(c1,c2));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
