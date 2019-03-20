package cn.changemax.mas.po;

public class Encyclopedia extends EncyclopediaKey {
	private Integer id;

	private String introduction;

	public Encyclopedia(String title, String hrefUrl) {
		super.setName(title);
		super.setUrl(hrefUrl);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}
}