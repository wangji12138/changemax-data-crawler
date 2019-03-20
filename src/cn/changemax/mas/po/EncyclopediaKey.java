package cn.changemax.mas.po;

public class EncyclopediaKey {
    private String name;

    private String url;
    
    

    public EncyclopediaKey(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public EncyclopediaKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}