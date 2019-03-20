package cn.changemax.mas.po;

public class DiseaseWithBLOBs extends Disease {
    private String diseaseComplicationIntro;

    private String diseaseExaminationGuidanceIntro;

    private String diseaseIntro;

    private String diseaseMedicalTreatmentGuideQuestion;

    private String diseaseSymptomEarly;

    private String diseaseSymptomIntro;

    private String diseaseSymptomLate;

    private String diseaseTreatmentMethodIntro;

    public String getDiseaseComplicationIntro() {
        return diseaseComplicationIntro;
    }

    public void setDiseaseComplicationIntro(String diseaseComplicationIntro) {
        this.diseaseComplicationIntro = diseaseComplicationIntro == null ? null : diseaseComplicationIntro.trim();
    }

    public String getDiseaseExaminationGuidanceIntro() {
        return diseaseExaminationGuidanceIntro;
    }

    public void setDiseaseExaminationGuidanceIntro(String diseaseExaminationGuidanceIntro) {
        this.diseaseExaminationGuidanceIntro = diseaseExaminationGuidanceIntro == null ? null : diseaseExaminationGuidanceIntro.trim();
    }

    public String getDiseaseIntro() {
        return diseaseIntro;
    }

    public void setDiseaseIntro(String diseaseIntro) {
        this.diseaseIntro = diseaseIntro == null ? null : diseaseIntro.trim();
    }

    public String getDiseaseMedicalTreatmentGuideQuestion() {
        return diseaseMedicalTreatmentGuideQuestion;
    }

    public void setDiseaseMedicalTreatmentGuideQuestion(String diseaseMedicalTreatmentGuideQuestion) {
        this.diseaseMedicalTreatmentGuideQuestion = diseaseMedicalTreatmentGuideQuestion == null ? null : diseaseMedicalTreatmentGuideQuestion.trim();
    }

    public String getDiseaseSymptomEarly() {
        return diseaseSymptomEarly;
    }

    public void setDiseaseSymptomEarly(String diseaseSymptomEarly) {
        this.diseaseSymptomEarly = diseaseSymptomEarly == null ? null : diseaseSymptomEarly.trim();
    }

    public String getDiseaseSymptomIntro() {
        return diseaseSymptomIntro;
    }

    public void setDiseaseSymptomIntro(String diseaseSymptomIntro) {
        this.diseaseSymptomIntro = diseaseSymptomIntro == null ? null : diseaseSymptomIntro.trim();
    }

    public String getDiseaseSymptomLate() {
        return diseaseSymptomLate;
    }

    public void setDiseaseSymptomLate(String diseaseSymptomLate) {
        this.diseaseSymptomLate = diseaseSymptomLate == null ? null : diseaseSymptomLate.trim();
    }

    public String getDiseaseTreatmentMethodIntro() {
        return diseaseTreatmentMethodIntro;
    }

    public void setDiseaseTreatmentMethodIntro(String diseaseTreatmentMethodIntro) {
        this.diseaseTreatmentMethodIntro = diseaseTreatmentMethodIntro == null ? null : diseaseTreatmentMethodIntro.trim();
    }
}