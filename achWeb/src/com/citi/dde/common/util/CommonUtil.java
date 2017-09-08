package com.citi.dde.common.util;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
/**
 * @author ak99879
 * This class consists of generic methods used through out the application
 * 
 */


@org.springframework.stereotype.Component
public class CommonUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2426345053818911024L;
	@Autowired	Environment property;
	
	
	Map<String, Map<String, String>> totalParamMap = null;
	private Logger log = LogManager.getLogger(CommonUtil.class);
	
	public static boolean checkNull(String obj){
		boolean result = obj != null ? true : false;
		return result;
	}
	
	/**
	 * Return boolean value if string has prefix = "CSP"
	 */
	public static boolean isParent(String menuId) {
		return menuId.startsWith(CsConstants.PARENT_PREFIX);
	}
	
	
	/**
	 * Return String value of a Object. If it is null returns default value.
	 */
	public static String getValue(final Object obj, final String defValue){
		return null == toString(obj) ? defValue : toString(obj);
	}
	
	
	/**
	 * Return String value of a Object. If it is null returns default value.
	 */
	public static int getInt(final Object obj, final int defValue){
		return null == obj ? defValue : Integer.parseInt(obj.toString());
	}
	
	public static String toString(final Object obj){
		return null == obj ? null : obj.toString();
	}
	
	/**
	 * Return Integer value of a Object if the object is Instance Of BigDecimal. If it is null returns default value.
	 * 
	 */
	public static int getBigDecimalIntValue(final Object obj, final int defValue){
		if ((null != obj) && (obj instanceof BigDecimal)) {
			return ((BigDecimal) obj).intValue();
		} else {
			return defValue;
		}
	}
	

	/**
	 * Return Integer value of a Object if the object is Instance Of BigDecimal. If it is null returns default value.
	 * 
	 */
	public static BigDecimal getBigDecimal(final Object obj, final BigDecimal defValue){
		if ((null != obj) && (obj instanceof BigDecimal)) {
			return ((BigDecimal) obj);
		} else {
			return defValue;
		}
	}
	
	
	/**
	 * Return Long value of a Object if the object is Instance Of BigDecimal. If it is null returns default value.
	 
	 */
	public static Short getBigDecimalShortValue(final Object obj, final Short defValue){
		if ((null != obj) && (obj instanceof BigDecimal)) {
			return ((BigDecimal) obj).shortValue();
		} else {
			return defValue;
		}
	}
	
	
	public static String  getDate(final Object obj){
		if ((null != obj) && (obj instanceof Timestamp)) {
			Timestamp stamp = (Timestamp) obj;
			String date =new SimpleDateFormat("dd MMM yyyy hh:mm:ss").format(stamp);
			return date;
		} else {
			return CsConstants.EMPTY_STRING;
		}
	}
	
	public static Integer getBigDecimalIntegerValue(final Object obj, final Integer defValue){
		if ((null != obj) && (obj instanceof BigDecimal)) {
			return ((BigDecimal) obj).intValue();
		} else {
			return defValue;
		}
	}
	
	public static Long getBigDecimalLongValue(final Object obj, final Long defValue){
		if ((null != obj) && (obj instanceof BigDecimal)) {
			return ((BigDecimal) obj).longValue();
		} else {
			return defValue;
		}
	}
	
	public static String trim(String str){
		if(str== null){
			return str;
		}
		return str.replaceAll("^\\s+", CsConstants.EMPTY_STRING).replaceAll("\\s+$", CsConstants.EMPTY_STRING);
	}	
		
}
