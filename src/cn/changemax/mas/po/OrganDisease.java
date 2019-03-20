package cn.changemax.mas.po;

public class OrganDisease {
    private Integer organDiseaseId;

    private String tDiseaseId;

    private String tDiseaseName;

    private Integer tOrganId;

    private String tOrganName;

    public Integer getOrganDiseaseId() {
        return organDiseaseId;
    }

    public void setOrganDiseaseId(Integer organDiseaseId) {
        this.organDiseaseId = organDiseaseId;
    }

    public String gettDiseaseId() {
        return tDiseaseId;
    }

    public void settDiseaseId(String tDiseaseId) {
        this.tDiseaseId = tDiseaseId == null ? null : tDiseaseId.trim();
    }

    public String gettDiseaseName() {
        return tDiseaseName;
    }

    public void settDiseaseName(String tDiseaseName) {
        this.tDiseaseName = tDiseaseName == null ? null : tDiseaseName.trim();
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
}