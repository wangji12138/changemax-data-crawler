package cn.changemax.mas.po;

import java.util.List;

public class Part {
	private Integer partId;

	private String partName;

	private List<Organ> organList;

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName == null ? null : partName.trim();
	}

	public List<Organ> getOrganList() {
		return organList;
	}

	public void setOrganList(List<Organ> organList) {
		this.organList = organList;
	}

}