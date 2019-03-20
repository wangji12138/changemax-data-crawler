package cn.changemax.mas.exception;

/**
 * <p>
 * Title: TextSimilarityException.java
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
public class TextSimilarityException extends Exception {
	// 异常信息
	private String message;

	public TextSimilarityException(String message) {
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
