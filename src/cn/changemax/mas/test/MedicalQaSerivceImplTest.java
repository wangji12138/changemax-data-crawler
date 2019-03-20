package cn.changemax.mas.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.Qa;
import cn.changemax.mas.service.MedicalQaService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: MedicalQaSerivceImplTest.java
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
public class MedicalQaSerivceImplTest {

	private MedicalQaService medicalQaService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		medicalQaService = (MedicalQaService) ac.getBean("medicalQaService");
	}

	@Test
	public void testGetBestMedicalQaList() throws Exception {
		String searchQuestion = "风寒感冒发烧吃什么药";
		List<Qa> bestEncyclopediaQaList = medicalQaService.getBestMedicalQaList("wangjiwangji", "test", searchQuestion,
				WordUtils.getSplitWords(searchQuestion), WordUtils.getKeywordWords(searchQuestion));
		if (ListUtils.isNotEmpty(bestEncyclopediaQaList)) {
			for (Qa qa : bestEncyclopediaQaList) {
				System.out.println(qa.toString());
			}
		}
	}

}
