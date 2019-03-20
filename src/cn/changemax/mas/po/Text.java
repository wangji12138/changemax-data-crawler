package cn.changemax.mas.po;

import java.util.Date;
import java.util.List;

public class Text {
	private Integer id;

	private String textId;

	private String textContent;

	private Boolean isChangeMaxSpeak;

	private Date generationTime;

	private String speakerId;

	private String talkingContent;

	private List<String> splitWords;
	private List<String> keywordWords;

	public Text(String textId, String textContent, List<String> splitWords, List<String> keywordWords,
			String talkingContent, boolean isChangeMaxSpeak, String speakerId) {
		this.textId = textId;
		this.textContent = textContent;
		this.splitWords = splitWords;
		this.keywordWords = keywordWords;
		this.talkingContent = talkingContent;
		this.isChangeMaxSpeak = isChangeMaxSpeak;
		this.speakerId = speakerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTextId() {
		return textId;
	}

	public void setTextId(String textId) {
		this.textId = textId == null ? null : textId.trim();
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent == null ? null : textContent.trim();
	}

	public Boolean getIsChangeMaxSpeak() {
		return isChangeMaxSpeak;
	}

	public void setIsChangeMaxSpeak(Boolean isChangeMaxSpeak) {
		this.isChangeMaxSpeak = isChangeMaxSpeak;
	}

	public Date getGenerationTime() {
		return generationTime;
	}

	public void setGenerationTime(Date generationTime) {
		this.generationTime = generationTime;
	}

	public String getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(String speakerId) {
		this.speakerId = speakerId == null ? null : speakerId.trim();
	}

	public String getTalkingContent() {
		return talkingContent;
	}

	public void setTalkingContent(String talkingContent) {
		this.talkingContent = talkingContent == null ? null : talkingContent.trim();
	}

	public List<String> getSplitWords() {
		return splitWords;
	}

	public void setSplitWords(List<String> splitWords) {
		this.splitWords = splitWords;
	}

	public List<String> getKeywordWords() {
		return keywordWords;
	}

	public void setKeywordWords(List<String> keywordWords) {
		this.keywordWords = keywordWords;
	}
	
	
}