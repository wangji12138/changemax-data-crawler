package cn.changemax.mas.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.Disease;
import cn.changemax.mas.po.DiseaseWithBLOBs;
import cn.changemax.mas.service.DiseaseService;

/**
 * <p>
 * Title: DiseaseServiceImplTest.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月11日
 * @version 1.0
 */
public class DiseaseServiceImplTest {

	private DiseaseService diseaseService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		diseaseService = (DiseaseService) ac.getBean("diseaseService");

	}

	@Test
	public void testSelectDiseaseIntroByLikeDiseaseName() throws Exception {
		List<String> keywordList = new ArrayList<String>();
		keywordList.add("毒气");
		keywordList.add("中毒");
		List<DiseaseWithBLOBs> diseaseWithBLOBsList = diseaseService.selectDiseaseIntroByLikeDiseaseName(keywordList);

		for (DiseaseWithBLOBs disease : diseaseWithBLOBsList) {
			System.out.println(disease.getDiseaseIntro());
		}
	}
}
