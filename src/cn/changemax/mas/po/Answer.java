package cn.changemax.mas.po;

import java.util.Date;

public class Answer {
	private String answerId;

	private String userId;

	private String questionId;

	private String originalQuestion;

	private Double questionSimilarity;

	private String answerType;

	private String relatedUrl;

	private Date generationDate;

	private Integer goodNumber;

	private Integer badNumber;

	private Integer isAdoption;

	private String answerDetail;

	private User user;

	private String questionTitle;
	
	

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", userId=" + userId + ", questionId=" + questionId
				+ ", originalQuestion=" + originalQuestion + ", questionSimilarity=" + questionSimilarity
				+ ", answerType=" + answerType + ", relatedUrl=" + relatedUrl + ", generationDate=" + generationDate
				+ ", goodNumber=" + goodNumber + ", badNumber=" + badNumber + ", isAdoption=" + isAdoption
				+ ", answerDetail=" + answerDetail + ", user=" + user + ", questionTitle=" + questionTitle + "]";
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId == null ? null : answerId.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId == null ? null : questionId.trim();
	}

	public String getOriginalQuestion() {
		return originalQuestion;
	}

	public void setOriginalQuestion(String originalQuestion) {
		this.originalQuestion = originalQuestion == null ? null : originalQuestion.trim();
	}

	public Double getQuestionSimilarity() {
		return questionSimilarity;
	}

	public void setQuestionSimilarity(Double questionSimilarity) {
		this.questionSimilarity = questionSimilarity;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType == null ? null : answerType.trim();
	}

	public String getRelatedUrl() {
		return relatedUrl;
	}

	public void setRelatedUrl(String relatedUrl) {
		this.relatedUrl = relatedUrl == null ? null : relatedUrl.trim();
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public Integer getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(Integer goodNumber) {
		this.goodNumber = goodNumber;
	}

	public Integer getBadNumber() {
		return badNumber;
	}

	public void setBadNumber(Integer badNumber) {
		this.badNumber = badNumber;
	}

	public Integer getIsAdoption() {
		return isAdoption;
	}

	public void setIsAdoption(Integer isAdoption) {
		this.isAdoption = isAdoption;
	}

	public String getAnswerDetail() {
		return answerDetail;
	}

	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail == null ? null : answerDetail.trim();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

}