package cn.changemax.mas.exception;

/**
 * <p>
 * Title: UserException.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月4日
 * @version 1.0
 */
public class UserException extends Exception {
	// 异常信息
	private String message;

	public UserException(String message) {
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
