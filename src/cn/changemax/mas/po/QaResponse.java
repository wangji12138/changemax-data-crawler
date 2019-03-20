package cn.changemax.mas.po;

import java.util.List;
import java.util.UUID;

public class QaResponse {
	private String qaResponseId;

	private String qaResponseChangeMaxId;

	private String textId;

	private List<Text> qaResponseTextList;
	private List<String> analysisTypeList;

	public QaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QaResponse(String qaResponseChangeMaxId) {
		this.qaResponseId = UUID.randomUUID().toString().replaceAll("-", "");
		this.qaResponseChangeMaxId = qaResponseChangeMaxId;
	}

	public String getQaResponseId() {
		return qaResponseId;
	}

	public void setQaResponseId(String qaResponseId) {
		this.qaResponseId = qaResponseId == null ? null : qaResponseId.trim();
	}

	public String getQaResponseChangeMaxId() {
		return qaResponseChangeMaxId;
	}

	public void setQaResponseChangeMaxId(String qaResponseChangeMaxId) {
		this.qaResponseChangeMaxId = qaResponseChangeMaxId == null ? null : qaResponseChangeMaxId.trim();
	}

	public String getTextId() {
		return textId;
	}

	public void setTextId(String textId) {
		this.textId = textId == null ? null : textId.trim();
	}

	public List<Text> getQaResponseTextList() {
		return qaResponseTextList;
	}

	public void setQaResponseTextList(List<Text> qaResponseTextList) {
		this.qaResponseTextList = qaResponseTextList;
	}

	public List<String> getAnalysisTypeList() {
		return analysisTypeList;
	}

	public void setAnalysisTypeList(List<String> analysisTypeList) {
		this.analysisTypeList = analysisTypeList;
	}

}