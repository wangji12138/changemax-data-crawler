package cn.changemax.mas.po;

import java.util.Date;
import java.util.List;

public class Question {
	private String questionId;

	private String userId;

	private Integer questionCategoryId;

	private String adoptionAnswerId;

	private String questionTitle;

	private String questionDetail;

	private Integer questionReward;

	private Date generationDate;

	private Integer views;

	private Integer isFine;

	private Integer isTop;

	private Integer isAnonymous;// 是否匿名

	private Integer answerNumber;
	private User user;
	private QaCategory qaCategory;
	private Answer adoptionAnswer;

	private List<String> splitWordList;
	private List<String> keywordList;

	private List<Answer> answerList;
	
	

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", userId=" + userId + ", questionCategoryId="
				+ questionCategoryId + ", adoptionAnswerId=" + adoptionAnswerId + ", questionTitle=" + questionTitle
				+ ", questionDetail=" + questionDetail + ", questionReward=" + questionReward + ", generationDate="
				+ generationDate + ", views=" + views + ", isFine=" + isFine + ", isTop=" + isTop + ", isAnonymous="
				+ isAnonymous + ", answerNumber=" + answerNumber + ", user=" + user + ", qaCategory=" + qaCategory
				+ ", adoptionAnswer=" + adoptionAnswer + ", splitWordList=" + splitWordList + ", keywordList="
				+ keywordList + ", answerList=" + answerList + "]";
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId == null ? null : questionId.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Integer getQuestionCategoryId() {
		return questionCategoryId;
	}

	public void setQuestionCategoryId(Integer questionCategoryId) {
		this.questionCategoryId = questionCategoryId;
	}

	public String getAdoptionAnswerId() {
		return adoptionAnswerId;
	}

	public void setAdoptionAnswerId(String adoptionAnswerId) {
		this.adoptionAnswerId = adoptionAnswerId == null ? null : adoptionAnswerId.trim();
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle == null ? null : questionTitle.trim();
	}

	public String getQuestionDetail() {
		return questionDetail;
	}

	public void setQuestionDetail(String questionDetail) {
		this.questionDetail = questionDetail == null ? null : questionDetail.trim();
	}

	public Integer getQuestionReward() {
		return questionReward;
	}

	public void setQuestionReward(Integer questionReward) {
		this.questionReward = questionReward;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getIsFine() {
		return isFine;
	}

	public void setIsFine(Integer isFine) {
		this.isFine = isFine;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public Integer getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(Integer answerNumber) {
		this.answerNumber = answerNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public QaCategory getQaCategory() {
		return qaCategory;
	}

	public void setQaCategory(QaCategory qaCategory) {
		this.qaCategory = qaCategory;
	}

	public Answer getAdoptionAnswer() {
		return adoptionAnswer;
	}

	public void setAdoptionAnswer(Answer adoptionAnswer) {
		this.adoptionAnswer = adoptionAnswer;
	}

	public List<String> getSplitWordList() {
		return splitWordList;
	}

	public void setSplitWordList(List<String> splitWordList) {
		this.splitWordList = splitWordList;
	}

	public List<String> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

}