package cn.changemax.mas.po;

public class QaAiKey {
	private String userText;

	private String text;

	public QaAiKey(String userText, String text) {
		super();
		this.userText = userText;
		this.text = text;
	}

	public QaAiKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText == null ? null : userText.trim();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}
}