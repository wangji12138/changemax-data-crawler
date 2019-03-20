package cn.changemax.mas.po;

public class BdzdQa {
	private String url;

	private String question;

	private String answerTime;

	private String clickHeat;

	private String answer;
	
	

	public BdzdQa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BdzdQa(String question, String answer, String answerTime, String clickHeat, String url) {
		this.question = question;
		this.answer = answer;
		this.answerTime = answerTime;
		this.clickHeat = clickHeat;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question == null ? null : question.trim();
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime == null ? null : answerTime.trim();
	}

	public String getClickHeat() {
		return clickHeat;
	}

	public void setClickHeat(String clickHeat) {
		this.clickHeat = clickHeat == null ? null : clickHeat.trim();
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer == null ? null : answer.trim();
	}
}