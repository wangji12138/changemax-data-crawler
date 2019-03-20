package cn.changemax.mas.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.changemax.mas.exception.SortException;

/**
 * <p>
 * Title: SortUtils.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月13日
 * @version 1.0
 */
public class SortUtils {
	/**
	 * @param targetList 要排序的实体类List集合
	 * @param sortField  排序字段(实体类属性名)
	 * @param sortMode   true正序，false逆序
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("all")
	public static <T> void sortListBySortField(List<T> targetList, final String sortField, final boolean sortMode)
			throws NoSuchMethodException, SecurityException {
		if (targetList == null || targetList.size() < 2 || sortField == null || sortField.length() == 0) {
			return;
		}
		// 获取getXxx()方法名称
		String methodStr = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);
		Method method = targetList.get(0).getClass().getMethod(methodStr, null);

		Collections.sort(targetList, new Comparator() {
			@Override
			public int compare(Object obj1, Object obj2) {
				int retVal = 0;
				try {
					if (sortMode) {
						retVal = method.invoke(obj1, null).toString().compareTo(method.invoke(obj2, null).toString());
					} else {
						retVal = method.invoke(obj2, null).toString().compareTo(method.invoke(obj1, null).toString());
					}
				} catch (Exception e) {
					System.err.println("List<" + obj1.getClass().getName() + ">排序异常！");
					e.printStackTrace();
				}
				return retVal;
			}
		});
	}

	/**
	 * 
	 * <p>
	 * Title: sortMap
	 * </p>
	 * <p>
	 * Description:将map集中按文本热度值排序
	 * </p>
	 * 
	 * @param targetMap
	 * @param sortMode
	 * @return
	 * @throws SortException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("all")
	public static <K, V extends Comparable<? super V>> List<Map.Entry<K, Double>> sortMapByKField(
			Map<K, Double> targetMap, final String targetKField, final boolean sortMode)
			throws SortException, NoSuchMethodException, SecurityException {
		if (targetMap == null) {
			return null;
		}
		if (targetMap.size() < 2) {
			return new ArrayList<Map.Entry<K, Double>>((Collection<? extends Entry<K, Double>>) targetMap.entrySet());
		}

		if (StringUtils.isEmpty(targetKField)) {
			throw new SortException("targetKField为空！");
		}

		List<Map.Entry<K, Double>> targetList = new ArrayList<Map.Entry<K, Double>>(
				(Collection<? extends Entry<K, Double>>) targetMap.entrySet());

		// 获取getXxx()方法名称
		String targetKFieldMethodStr = "get" + targetKField.substring(0, 1).toUpperCase() + targetKField.substring(1);
		Method targetKFieldMethod = targetList.get(0).getKey().getClass().getMethod(targetKFieldMethodStr, null);
		Collections.sort(targetList, new Comparator<Map.Entry<K, Double>>() {
			public int compare(Entry<K, Double> entry1, Entry<K, Double> entry2) {
				int retVal = 0;

				try {
					if (sortMode) {
						retVal = targetKFieldMethod.invoke(entry1.getKey(), null).toString()
								.compareTo(targetKFieldMethod.invoke(entry2.getKey(), null).toString());
					} else {
						retVal = targetKFieldMethod.invoke(entry2.getKey(), null).toString()
								.compareTo(targetKFieldMethod.invoke(entry1.getKey(), null).toString());
					}
				} catch (Exception e) {
					System.err.println("Map<" + entry1.getKey().getClass().getName() + ">排序异常！");
					e.printStackTrace();
				}

				return retVal;
			}

		});
		return targetList;
	}

	/**
	 * 
	 * <p>
	 * Title: sortMap
	 * </p>
	 * <p>
	 * Description:将map集中按相似度值V排序
	 * </p>
	 * 
	 * @param targetMap
	 * @param sortMode
	 * @return
	 */
	@SuppressWarnings("all")
	public static <K, V extends Comparable<? super V>> List<Map.Entry<K, Double>> sortMapByDouble(
			Map<K, Double> targetMap, final boolean sortMode) {
		if (targetMap == null) {
			return null;
		}
		if (targetMap.size() < 2) {
			return new ArrayList<Map.Entry<K, Double>>((Collection<? extends Entry<K, Double>>) targetMap.entrySet());
		}

		List<Map.Entry<K, Double>> targetList = new ArrayList<Map.Entry<K, Double>>(
				(Collection<? extends Entry<K, Double>>) targetMap.entrySet());

		Collections.sort(targetList, new Comparator<Map.Entry<K, Double>>() {
			// 降序排序
			public int compare(Entry<K, Double> obj1, Entry<K, Double> obj2) {
				int retVal = 0;
				try {
					if (sortMode) {
						retVal = obj1.getValue().compareTo(obj2.getValue());
					} else {
						retVal = obj2.getValue().compareTo(obj1.getValue());
					}
				} catch (Exception e) {
					System.err.println("Map<" + ((Entry<K, Double>) obj1).getClass().getName() + ">排序异常！");
					e.printStackTrace();
				}
				return retVal;
			}

		});

		return targetList;

	}
}
