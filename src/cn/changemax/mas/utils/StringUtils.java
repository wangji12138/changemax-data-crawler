package cn.changemax.mas.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
	
	/**
	 * 判断一个字符串不为空
	 * @param str
	 * @return 不为空返回true ，为null或""返回false
	 */
	public static boolean isNotEmpty(String str) {
		if(null != str && !"".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断一个字符串为空
	 * @param str
	 * @return 为空返回true ，不为空false
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	
	/**
	 * 将一个日期类型转换为字符串，方便显示
	 * @param date 要转换的日期数据
	 * @return string 格式化好的字符串日期
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 将一个字符串类型转换为日期格式，方便存储
	 * @param String 字符串日期
	 * @return date 转换好的日期数据
	 */
	public static Date getDate(String str) throws ParseException {
		if(isNotEmpty(str)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(str);
		} else {
			return null;
		}
	}
	public static Date getShortDate(String str) throws ParseException {
		if(isNotEmpty(str)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(str);
		} else {
			return null;
		}
	}
	
	/**
	 * 将字符串转为整数类型
	 * @param str 字符串数据
	 * @return int 为空返回0
	 */
	public static int convertToInt(String str) {
		if(isNotEmpty(str)) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
	}
    public static Integer convertToIntNull(String str) {
        if(isNotEmpty(str)) {
            return Integer.parseInt(str);
        } else {
            return null;
        }
    }
	/**
	 * 将字符串转为浮点类型
	 * @param str 字符串数据
	 * @return double 为空返回0
	 */
	public static Double convertToDouble(String str) {
		if(isNotEmpty(str)) {
			return Double.parseDouble(str);
		} else {
			return 0.0;
		}
	}
    public static Double convertToDoubleNull(String str) {
        if(isNotEmpty(str)) {
            return Double.parseDouble(str);
        } else {
            return null;
        }
    }
	
	/**
	 * 将string数值数据数组转为int数组
	 * @param strs[]
	 * @return int[]
	 */
	public static int[] convertToIntArray(String[] strs) {
		if(strs == null || strs.length == 0) {
			return null;
		}
		int[] ints = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			ints[i] = Integer.parseInt(strs[i]);
		}
		return ints;
	}
}
