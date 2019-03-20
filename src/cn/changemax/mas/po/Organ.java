package cn.changemax.mas.po;

import java.util.List;

public class Organ {
	private Integer organId;

	private String organName;

	private Integer organPartId;

	private List<Disease> diseaseList;
	private List<Symptom> symptomList;

	public Integer getOrganId() {
		return organId;
	}

	public void setOrganId(Integer organId) {
		this.organId = organId;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName == null ? null : organName.trim();
	}

	public Integer getOrganPartId() {
		return organPartId;
	}

	public void setOrganPartId(Integer organPartId) {
		this.organPartId = organPartId;
	}

	public List<Disease> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(List<Disease> diseaseList) {
		this.diseaseList = diseaseList;
	}

	public List<Symptom> getSymptomList() {
		return symptomList;
	}

	public void setSymptomList(List<Symptom> symptomList) {
		this.symptomList = symptomList;
	}

}