package cn.changemax.mas.po;

public class OrganSymptom {
    private Integer organSymptomId;

    private Integer tOrganId;

    private String tOrganName;

    private String tSymptomId;

    private String tSymptomName;

    public Integer getOrganSymptomId() {
        return organSymptomId;
    }

    public void setOrganSymptomId(Integer organSymptomId) {
        this.organSymptomId = organSymptomId;
    }

    public Integer gettOrganId() {
        return tOrganId;
    }

    public void settOrganId(Integer tOrganId) {
        this.tOrganId = tOrganId;
    }

    public String gettOrganName() {
        return tOrganName;
    }

    public void settOrganName(String tOrganName) {
        this.tOrganName = tOrganName == null ? null : tOrganName.trim();
    }

    public String gettSymptomId() {
        return tSymptomId;
    }

    public void settSymptomId(String tSymptomId) {
        this.tSymptomId = tSymptomId == null ? null : tSymptomId.trim();
    }

    public String gettSymptomName() {
        return tSymptomName;
    }

    public void settSymptomName(String tSymptomName) {
        this.tSymptomName = tSymptomName == null ? null : tSymptomName.trim();
    }
}