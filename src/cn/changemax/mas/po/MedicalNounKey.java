package cn.changemax.mas.po;

public class MedicalNounKey {
    private Integer nounId;

    private String nounName;

    public Integer getNounId() {
        return nounId;
    }

    public void setNounId(Integer nounId) {
        this.nounId = nounId;
    }

    public String getNounName() {
        return nounName;
    }

    public void setNounName(String nounName) {
        this.nounName = nounName == null ? null : nounName.trim();
    }
}