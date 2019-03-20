package cn.changemax.mas.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * Title: CustomExceptionResolver.java
 * </p>
 * <p>
 * Description:全局异常处理器
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年11月28日
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * 系统抛出的异常
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		// 解析出异常类型

		// 如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
//		String message = null;
//		if (exception instanceof CustomException) {
//			message = ((CustomException) exception).getMessage();
//		} else {// 如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
//			message = "未知错误";
//		}

		// 上边代码变为
		CustomException customException = null;
		if (exception instanceof CustomException) {
			customException = (CustomException) exception;
		} else {
			customException = new CustomException("未知错误");
		}

		// 错误信息
		String message = customException.getMessage();

		ModelAndView modelAndView = new ModelAndView();

		// 将错误信息传入到页面
		modelAndView.addObject("message", message);

		// 指向错误页面
		modelAndView.setViewName("error");

		return modelAndView;
	}

}
