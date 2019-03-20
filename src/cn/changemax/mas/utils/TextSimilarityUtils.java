package cn.changemax.mas.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.changemax.mas.exception.TextSimilarityException;
import cn.changemax.mas.po.MedicalQa;

/**
 * <p>
 * Title: TextSimilarityUtils.java
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
public class TextSimilarityUtils {

	/**
	 * 
	 * <p>
	 * Title: getSimilarity
	 * </p>
	 * <p>
	 * Description:获取相识度集
	 * </p>
	 * 
	 * @param                  <T>
	 * 
	 * @param textContent
	 * @param splitWordList
	 * @param keywordList
	 * @param obtainObjectList
	 * @param minSimilarity1
	 * @param minSimilarity2
	 * @param getAttributeName
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<T, Double> getSimilarityMapByObtainObjectList(String textContent, List<String> splitWordList,
			List<String> keywordList, List<T> obtainObjectList, double minSimilarity1, double minSimilarity2,
			final String sortField, final boolean isName) throws Exception {
		// 对预分析对象集进行限定
		if (ListUtils.isEmpty(obtainObjectList)) {
			return null;
		}

		// 对预分析对象get文本方法进行限定
		if (StringUtils.isEmpty(sortField)) {
			throw new TextSimilarityException("预分析对象get文本方法为空！");
		}

		// 对文本对象进行限定
		if (StringUtils.isEmpty(textContent)) {
			throw new TextSimilarityException("分析文本为空！");
		}

		// 对文本集对象进行限定
		if (ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new TextSimilarityException("分析文本分词或者关键词集为空！");
		}

		// 对最低相似度进行限定
		if (!isName) {
			minSimilarity1 = (minSimilarity1 >= 1.0 || minSimilarity1 <= 0.7) ? (minSimilarity1 >= 1.0 ? 1.0 : 0.7)
					: minSimilarity1;
		}
		minSimilarity2 = (minSimilarity2 >= 1.0 || minSimilarity2 <= 0.5) ? (minSimilarity2 >= 1.0 ? 1.0 : 0.5)
				: minSimilarity2;

		Map<T, Double> obtainObjectMap = new HashMap<T, Double>();

		// 获取getXxx()方法名称
		String sortFieldMethodStr = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);
		Method sortFieldMethod = obtainObjectList.get(0).getClass().getMethod(sortFieldMethodStr, null);

		int textContentLength = textContent.length();
		int currentObjectAttributeNameLength = 0;
		for (Object currentObject : obtainObjectList) {
			String currentObjectAttributeName = (String) sortFieldMethod.invoke(currentObject, null);

			if (isName) {
				double currentSimilarity2 = SimilarityUtil.getSimilarityByKeyword(keywordList,
						currentObjectAttributeName);
				if (currentSimilarity2 >= minSimilarity2) {
					obtainObjectMap.put((T) currentObject, currentSimilarity2);
				}
			} else {
				double currentSimilarity = SimilarityUtil.getSimilarity(splitWordList, currentObjectAttributeName);
				currentObjectAttributeNameLength = WordUtils.removePunctuation(currentObjectAttributeName).length();
				int maxLengthDifference = ((int) Math.ceil((double) textContentLength / (double) 2));

				if (Math.abs(currentObjectAttributeNameLength - textContentLength) <= maxLengthDifference) { // 获取长度相差不大于原句长一半的
					if (currentSimilarity > minSimilarity1) {
						double currentSimilarity2 = SimilarityUtil.getSimilarityByKeyword(keywordList,
								currentObjectAttributeName);

						if (currentSimilarity2 >= minSimilarity2) {

							obtainObjectMap.put((T) currentObject, currentSimilarity);
						}
					}
				}
			}

		}
		return obtainObjectMap;
	}

	/**
	 * 
	 * <p>
	 * Title: getSimilarity
	 * </p>
	 * <p>
	 * Description:获取相识度集
	 * </p>
	 * 
	 * @param                  <T>
	 * 
	 * @param textContent
	 * @param obtainObjectList
	 * @param minSimilarity1
	 * @param minSimilarity2
	 * @param getAttributeName
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<T, Double> getSimilarityMapByObtainObjectList(String textContent, List<T> obtainObjectList,
			final double minSimilarity1, final double minSimilarity2, final String sortField, final boolean isName)
			throws Exception {
		// 对预分析对象集进行限定
		if (ListUtils.isEmpty(obtainObjectList)) {
			return null;
		}

		// 对预分析对象get文本方法进行限定
		if (sortField == null) {
			throw new TextSimilarityException("预分析对象get文本方法为空！");
		}

		// 对文本对象进行限定
		if (StringUtils.isEmpty(textContent)) {
			throw new TextSimilarityException("分析文本为空！");
		}

		List<String> splitWordList = WordUtils.getSplitWords(textContent);
		List<String> keywordList = WordUtils.getKeywordWords(textContent);

		return getSimilarityMapByObtainObjectList(textContent, splitWordList, keywordList, obtainObjectList,
				minSimilarity1, minSimilarity2, sortField, isName);

	}

}
