package cn.changemax.mas.po;

public class Symptom {
    private String symptomId;

    private String suggestedTreatmentDepartment;

    private String symptomImageUrl;

    private String symptomName;

    private String symptomTrans;

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId == null ? null : symptomId.trim();
    }

    public String getSuggestedTreatmentDepartment() {
        return suggestedTreatmentDepartment;
    }

    public void setSuggestedTreatmentDepartment(String suggestedTreatmentDepartment) {
        this.suggestedTreatmentDepartment = suggestedTreatmentDepartment == null ? null : suggestedTreatmentDepartment.trim();
    }

    public String getSymptomImageUrl() {
        return symptomImageUrl;
    }

    public void setSymptomImageUrl(String symptomImageUrl) {
        this.symptomImageUrl = symptomImageUrl == null ? null : symptomImageUrl.trim();
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName == null ? null : symptomName.trim();
    }

    public String getSymptomTrans() {
        return symptomTrans;
    }

    public void setSymptomTrans(String symptomTrans) {
        this.symptomTrans = symptomTrans == null ? null : symptomTrans.trim();
    }
}