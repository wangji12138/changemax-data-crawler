package cn.changemax.mas.test;

import static org.junit.Assert.fail;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.MedicalVideo;
import cn.changemax.mas.po.Text;
import cn.changemax.mas.po.User;
import cn.changemax.mas.service.UserService;

/**
 * <p>
 * Title: UserServiceImplTest.java
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
public class UserServiceImplTest {
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		userService = (UserService) ac.getBean("userService");

	}

	@Test
	public void testInsertUser() throws Exception {
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("王际");
		user.setUsername("root123564");
		user.setUserPhone("13479064741");

		user.setPassword("123456");
		user.setUserGender("男");
		Integer i = userService.insertUser(user);
		System.out.println(i);
	}

	@Test
	public void testGetUser() throws Exception {
		User user = userService.getUser("root123564", "123456");
		System.out.println(user.toString());
	}

}
