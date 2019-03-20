package cn.changemax.mas.utils;

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
 * @date 2018年12月10日
 * @version 1.0
 */
public class KeywordUtils {

//	1、问事物、时间、处所、数量：谁、何、什么，哪儿、哪里，几时、几、多少
//	2、问方式、性状、原因：怎、怎么、怎的、怎样、怎么样、怎么着、如何、为什么
	public static String[] questionKeywordArray = { "谁", "何", "什么", "哪儿", "哪里", "几时", "几", "多少", "怎", "怎么", "怎样", "怎么样",
			"如何", "为什么" };

	public static String[] diseaseFieldKeywordArray = { "别名", "并发症", "传染", "治愈率", "发病率", "医保", "易发人群", "相关症状", "治疗费用",
			"治疗周期", "治疗方法", "科室", "并发症", "就诊指南", "介绍", "早期症状", "症状", "晚期症状", "治疗方法" };

	public static String[] symptomFieldKeywordArray = { "科室", "原因", "疾病", "介绍", "就诊指南", "医保", "易发人群", "相关症状", "临床症状" };

}
