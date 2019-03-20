package cn.changemax.mas.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.hankcs.hanlp.HanLP;

/**
 * <p>
 * Title: TextUtils.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月2日
 * @version 1.0
 */
public class SimilarityUtil {

	public static void main(String[] args) {
		String str1 = "平凡世界";
		String str2 = "世界平凡";
		List<String> s1 = new ArrayList<String>();
		s1.add("平凡");
		s1.add("世界");

		System.out.println(getSimilarityByKeyword(s1, str2));

	}

	/**
	 * 
	 * <p>
	 * Title: getSimilarity
	 * </p>
	 * <p>
	 * Description: 获取分词和句子的相似度
	 * </p>
	 * 
	 * @param sent1Words
	 * @param sentence2
	 * @return
	 */
	public static double getSimilarityByKeyword(List<String> keywordList1, String sentence2) {
		List<String> keywordList2 = HanLP.extractKeyword(sentence2, sentence2.length());

		List<String> allWords = mergeList(keywordList1, keywordList2);

		int[] statistic1 = statistic(allWords, keywordList1);
		int[] statistic2 = statistic(allWords, keywordList2);

		double dividend = 0;
		double divisor1 = 0;
		double divisor2 = 0;
		for (int i = 0; i < statistic1.length; i++) {
			dividend += statistic1[i] * statistic2[i];
			divisor1 += Math.pow(statistic1[i], 2);
			divisor2 += Math.pow(statistic2[i], 2);
		}
		return dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2));
	}

	/**
	 * 
	 * <p>
	 * Title: getSimilarity
	 * </p>
	 * <p>
	 * Description: 获取分词和句子的相似度
	 * </p>
	 * 
	 * @param sent1Words
	 * @param sentence2
	 * @return
	 */
	public static double getSimilarity(List<String> sent1Words, String sentence2) {
		List<String> sent2Words = WordUtils.getSplitWords(sentence2);

		List<String> allWords = mergeList(sent1Words, sent2Words);

		int[] statistic1 = statistic(allWords, sent1Words);
		int[] statistic2 = statistic(allWords, sent2Words);

		double dividend = 0;
		double divisor1 = 0;
		double divisor2 = 0;
		for (int i = 0; i < statistic1.length; i++) {
			dividend += statistic1[i] * statistic2[i];
			divisor1 += Math.pow(statistic1[i], 2);
			divisor2 += Math.pow(statistic2[i], 2);
		}
		return dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2));
	}

	/**
	 * 获得两个句子的相似度
	 *
	 * @param sentence1
	 * @param sentence2
	 * @return
	 */
	public static double getSimilarity(String sentence1, String sentence2) {
		List<String> sent1Words = WordUtils.getSplitWords(sentence1);
		List<String> sent2Words = WordUtils.getSplitWords(sentence2);

		List<String> allWords = mergeList(sent1Words, sent2Words);

		int[] statistic1 = statistic(allWords, sent1Words);
		int[] statistic2 = statistic(allWords, sent2Words);

		double dividend = 0;
		double divisor1 = 0;
		double divisor2 = 0;
		for (int i = 0; i < statistic1.length; i++) {
			dividend += statistic1[i] * statistic2[i];
			divisor1 += Math.pow(statistic1[i], 2);
			divisor2 += Math.pow(statistic2[i], 2);
		}

		return dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2));
	}

	private static int[] statistic(List<String> allWords, List<String> sentWords) {
		int[] result = new int[allWords.size()];
		for (int i = 0; i < allWords.size(); i++) {
			result[i] = Collections.frequency(sentWords, allWords.get(i));
		}
		return result;
	}

	private static List<String> mergeList(List<String> list1, List<String> list2) {
		List<String> result = new ArrayList<>();
		result.addAll(list1);
		result.addAll(list2);
		return result.stream().distinct().collect(Collectors.toList());
	}

}
