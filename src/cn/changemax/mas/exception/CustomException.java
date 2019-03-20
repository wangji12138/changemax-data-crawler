package cn.changemax.mas.exception;

/**
 * <p>
 * Title: CustomException.java
 * </p>
 * <p>
 * Description:系统自定义异常类，针对预期的异常，进行异常处理
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年11月28日
 * @version 1.0
 */
public class CustomException extends Exception {
	// 异常信息
	private String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
