package cn.changemax.mas.utils;

import java.util.List;

/**
 * <p>
 * Title: ListUtils.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月12日
 * @version 1.0
 */
public class ListUtils {
	/**
	 * 判断一个集合为空
	 * 
	 * @param str
	 * @return 为空返回true ，不为空false
	 */
	public static boolean isEmpty(List<?> list) {
		return !isNotEmpty(list);
	}

	/**
	 * 判断一个集合不为空且内容不为空
	 * 
	 * @param str
	 * @return 不为空返回true ，为null或大小等于0返回false
	 */
	public static boolean isNotEmpty(List<?> list) {
		if (null != list && !(list.size() == 0)) {
			return true;
		}
		return false;
	}

}
