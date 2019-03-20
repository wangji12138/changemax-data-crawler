package cn.changemax.mas.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.hankcs.hanlp.HanLP;

/**
 * <p>
 * Title: WordUtils.java
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
public class WordUtils {

	private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则

	// 去除中文
	public static String removeChinese(String str) {
		Pattern pat = Pattern.compile(REGEX_CHINESE);
		Matcher mat = pat.matcher(str);
		return mat.replaceAll("");
	}

	public static List<String> getSplitWords(String sentence) {
		return HanLP.segment(sentence).stream().map(a -> a.word)
				.filter(s -> !"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ".contains(s))
				.collect(Collectors.toList());
	}

	public static List<String> getKeywordWords(String sentence) {
		return HanLP.extractKeyword(sentence, sentence.length());
	}

	public static String removePunctuation(String s) {
		return s.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& amp;*（）——+|{}【】‘；：”“’。，、？|-]", "");
	}

}
