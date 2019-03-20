package cn.changemax.mas.po;

public class SymptomWithBLOBs extends Symptom {
    private String symptomCause;

    private String symptomCauseDisease;

    private String symptomIntro;

    private String symptomMedicalTreatmentGuide;

    private String symptomSimilarSymptoms;

    private String symptomaticDetailsContent;

    public String getSymptomCause() {
        return symptomCause;
    }

    public void setSymptomCause(String symptomCause) {
        this.symptomCause = symptomCause == null ? null : symptomCause.trim();
    }

    public String getSymptomCauseDisease() {
        return symptomCauseDisease;
    }

    public void setSymptomCauseDisease(String symptomCauseDisease) {
        this.symptomCauseDisease = symptomCauseDisease == null ? null : symptomCauseDisease.trim();
    }

    public String getSymptomIntro() {
        return symptomIntro;
    }

    public void setSymptomIntro(String symptomIntro) {
        this.symptomIntro = symptomIntro == null ? null : symptomIntro.trim();
    }

    public String getSymptomMedicalTreatmentGuide() {
        return symptomMedicalTreatmentGuide;
    }

    public void setSymptomMedicalTreatmentGuide(String symptomMedicalTreatmentGuide) {
        this.symptomMedicalTreatmentGuide = symptomMedicalTreatmentGuide == null ? null : symptomMedicalTreatmentGuide.trim();
    }

    public String getSymptomSimilarSymptoms() {
        return symptomSimilarSymptoms;
    }

    public void setSymptomSimilarSymptoms(String symptomSimilarSymptoms) {
        this.symptomSimilarSymptoms = symptomSimilarSymptoms == null ? null : symptomSimilarSymptoms.trim();
    }

    public String getSymptomaticDetailsContent() {
        return symptomaticDetailsContent;
    }

    public void setSymptomaticDetailsContent(String symptomaticDetailsContent) {
        this.symptomaticDetailsContent = symptomaticDetailsContent == null ? null : symptomaticDetailsContent.trim();
    }
}