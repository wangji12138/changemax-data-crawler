package cn.changemax.mas.po;

public class ChangeMax {
	private Integer changeMaxId;

	private String changeMaxName;

	private String userId;

	
	
	public ChangeMax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChangeMax(String userId) {
		this.changeMaxId = 1;
		this.changeMaxName = "changeMaxName";
		this.userId = userId;
	}

	public Integer getChangeMaxId() {
		return changeMaxId;
	}

	public void setChangeMaxId(Integer changeMaxId) {
		this.changeMaxId = changeMaxId;
	}

	public String getChangeMaxName() {
		return changeMaxName;
	}

	public void setChangeMaxName(String changeMaxName) {
		this.changeMaxName = changeMaxName == null ? null : changeMaxName.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
}