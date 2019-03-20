package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class DiseaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

	private int startRow;
	private int pageSize;

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
    public DiseaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(String value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(String value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(String value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(String value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(String value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(String value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLike(String value) {
            addCriterion("disease_id like", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotLike(String value) {
            addCriterion("disease_id not like", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<String> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<String> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(String value1, String value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(String value1, String value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasIsNull() {
            addCriterion("disease_alias is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasIsNotNull() {
            addCriterion("disease_alias is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasEqualTo(String value) {
            addCriterion("disease_alias =", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasNotEqualTo(String value) {
            addCriterion("disease_alias <>", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasGreaterThan(String value) {
            addCriterion("disease_alias >", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasGreaterThanOrEqualTo(String value) {
            addCriterion("disease_alias >=", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasLessThan(String value) {
            addCriterion("disease_alias <", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasLessThanOrEqualTo(String value) {
            addCriterion("disease_alias <=", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasLike(String value) {
            addCriterion("disease_alias like", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasNotLike(String value) {
            addCriterion("disease_alias not like", value, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasIn(List<String> values) {
            addCriterion("disease_alias in", values, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasNotIn(List<String> values) {
            addCriterion("disease_alias not in", values, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasBetween(String value1, String value2) {
            addCriterion("disease_alias between", value1, value2, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseAliasNotBetween(String value1, String value2) {
            addCriterion("disease_alias not between", value1, value2, "diseaseAlias");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationIsNull() {
            addCriterion("disease_complication is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationIsNotNull() {
            addCriterion("disease_complication is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationEqualTo(String value) {
            addCriterion("disease_complication =", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationNotEqualTo(String value) {
            addCriterion("disease_complication <>", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationGreaterThan(String value) {
            addCriterion("disease_complication >", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationGreaterThanOrEqualTo(String value) {
            addCriterion("disease_complication >=", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationLessThan(String value) {
            addCriterion("disease_complication <", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationLessThanOrEqualTo(String value) {
            addCriterion("disease_complication <=", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationLike(String value) {
            addCriterion("disease_complication like", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationNotLike(String value) {
            addCriterion("disease_complication not like", value, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationIn(List<String> values) {
            addCriterion("disease_complication in", values, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationNotIn(List<String> values) {
            addCriterion("disease_complication not in", values, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationBetween(String value1, String value2) {
            addCriterion("disease_complication between", value1, value2, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseComplicationNotBetween(String value1, String value2) {
            addCriterion("disease_complication not between", value1, value2, "diseaseComplication");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousIsNull() {
            addCriterion("disease_contagious is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousIsNotNull() {
            addCriterion("disease_contagious is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousEqualTo(String value) {
            addCriterion("disease_contagious =", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousNotEqualTo(String value) {
            addCriterion("disease_contagious <>", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousGreaterThan(String value) {
            addCriterion("disease_contagious >", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousGreaterThanOrEqualTo(String value) {
            addCriterion("disease_contagious >=", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousLessThan(String value) {
            addCriterion("disease_contagious <", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousLessThanOrEqualTo(String value) {
            addCriterion("disease_contagious <=", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousLike(String value) {
            addCriterion("disease_contagious like", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousNotLike(String value) {
            addCriterion("disease_contagious not like", value, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousIn(List<String> values) {
            addCriterion("disease_contagious in", values, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousNotIn(List<String> values) {
            addCriterion("disease_contagious not in", values, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousBetween(String value1, String value2) {
            addCriterion("disease_contagious between", value1, value2, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseContagiousNotBetween(String value1, String value2) {
            addCriterion("disease_contagious not between", value1, value2, "diseaseContagious");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateIsNull() {
            addCriterion("disease_cure_rate is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateIsNotNull() {
            addCriterion("disease_cure_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateEqualTo(String value) {
            addCriterion("disease_cure_rate =", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateNotEqualTo(String value) {
            addCriterion("disease_cure_rate <>", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateGreaterThan(String value) {
            addCriterion("disease_cure_rate >", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateGreaterThanOrEqualTo(String value) {
            addCriterion("disease_cure_rate >=", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateLessThan(String value) {
            addCriterion("disease_cure_rate <", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateLessThanOrEqualTo(String value) {
            addCriterion("disease_cure_rate <=", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateLike(String value) {
            addCriterion("disease_cure_rate like", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateNotLike(String value) {
            addCriterion("disease_cure_rate not like", value, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateIn(List<String> values) {
            addCriterion("disease_cure_rate in", values, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateNotIn(List<String> values) {
            addCriterion("disease_cure_rate not in", values, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateBetween(String value1, String value2) {
            addCriterion("disease_cure_rate between", value1, value2, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseCureRateNotBetween(String value1, String value2) {
            addCriterion("disease_cure_rate not between", value1, value2, "diseaseCureRate");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlIsNull() {
            addCriterion("disease_image_url is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlIsNotNull() {
            addCriterion("disease_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlEqualTo(String value) {
            addCriterion("disease_image_url =", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlNotEqualTo(String value) {
            addCriterion("disease_image_url <>", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlGreaterThan(String value) {
            addCriterion("disease_image_url >", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("disease_image_url >=", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlLessThan(String value) {
            addCriterion("disease_image_url <", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlLessThanOrEqualTo(String value) {
            addCriterion("disease_image_url <=", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlLike(String value) {
            addCriterion("disease_image_url like", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlNotLike(String value) {
            addCriterion("disease_image_url not like", value, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlIn(List<String> values) {
            addCriterion("disease_image_url in", values, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlNotIn(List<String> values) {
            addCriterion("disease_image_url not in", values, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlBetween(String value1, String value2) {
            addCriterion("disease_image_url between", value1, value2, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseImageUrlNotBetween(String value1, String value2) {
            addCriterion("disease_image_url not between", value1, value2, "diseaseImageUrl");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteIsNull() {
            addCriterion("disease_incidence_site is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteIsNotNull() {
            addCriterion("disease_incidence_site is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteEqualTo(String value) {
            addCriterion("disease_incidence_site =", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteNotEqualTo(String value) {
            addCriterion("disease_incidence_site <>", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteGreaterThan(String value) {
            addCriterion("disease_incidence_site >", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteGreaterThanOrEqualTo(String value) {
            addCriterion("disease_incidence_site >=", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteLessThan(String value) {
            addCriterion("disease_incidence_site <", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteLessThanOrEqualTo(String value) {
            addCriterion("disease_incidence_site <=", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteLike(String value) {
            addCriterion("disease_incidence_site like", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteNotLike(String value) {
            addCriterion("disease_incidence_site not like", value, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteIn(List<String> values) {
            addCriterion("disease_incidence_site in", values, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteNotIn(List<String> values) {
            addCriterion("disease_incidence_site not in", values, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteBetween(String value1, String value2) {
            addCriterion("disease_incidence_site between", value1, value2, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseIncidenceSiteNotBetween(String value1, String value2) {
            addCriterion("disease_incidence_site not between", value1, value2, "diseaseIncidenceSite");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceIsNull() {
            addCriterion("disease_medical_insurance is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceIsNotNull() {
            addCriterion("disease_medical_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceEqualTo(String value) {
            addCriterion("disease_medical_insurance =", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceNotEqualTo(String value) {
            addCriterion("disease_medical_insurance <>", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceGreaterThan(String value) {
            addCriterion("disease_medical_insurance >", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("disease_medical_insurance >=", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceLessThan(String value) {
            addCriterion("disease_medical_insurance <", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceLessThanOrEqualTo(String value) {
            addCriterion("disease_medical_insurance <=", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceLike(String value) {
            addCriterion("disease_medical_insurance like", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceNotLike(String value) {
            addCriterion("disease_medical_insurance not like", value, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceIn(List<String> values) {
            addCriterion("disease_medical_insurance in", values, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceNotIn(List<String> values) {
            addCriterion("disease_medical_insurance not in", values, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceBetween(String value1, String value2) {
            addCriterion("disease_medical_insurance between", value1, value2, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMedicalInsuranceNotBetween(String value1, String value2) {
            addCriterion("disease_medical_insurance not between", value1, value2, "diseaseMedicalInsurance");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleIsNull() {
            addCriterion("disease_multiple_people is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleIsNotNull() {
            addCriterion("disease_multiple_people is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleEqualTo(String value) {
            addCriterion("disease_multiple_people =", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleNotEqualTo(String value) {
            addCriterion("disease_multiple_people <>", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleGreaterThan(String value) {
            addCriterion("disease_multiple_people >", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("disease_multiple_people >=", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleLessThan(String value) {
            addCriterion("disease_multiple_people <", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleLessThanOrEqualTo(String value) {
            addCriterion("disease_multiple_people <=", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleLike(String value) {
            addCriterion("disease_multiple_people like", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleNotLike(String value) {
            addCriterion("disease_multiple_people not like", value, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleIn(List<String> values) {
            addCriterion("disease_multiple_people in", values, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleNotIn(List<String> values) {
            addCriterion("disease_multiple_people not in", values, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleBetween(String value1, String value2) {
            addCriterion("disease_multiple_people between", value1, value2, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseMultiplePeopleNotBetween(String value1, String value2) {
            addCriterion("disease_multiple_people not between", value1, value2, "diseaseMultiplePeople");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameIsNull() {
            addCriterion("disease_name is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameIsNotNull() {
            addCriterion("disease_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameEqualTo(String value) {
            addCriterion("disease_name =", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotEqualTo(String value) {
            addCriterion("disease_name <>", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameGreaterThan(String value) {
            addCriterion("disease_name >", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("disease_name >=", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameLessThan(String value) {
            addCriterion("disease_name <", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameLessThanOrEqualTo(String value) {
            addCriterion("disease_name <=", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameLike(String value) {
            addCriterion("disease_name like", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotLike(String value) {
            addCriterion("disease_name not like", value, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameIn(List<String> values) {
            addCriterion("disease_name in", values, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotIn(List<String> values) {
            addCriterion("disease_name not in", values, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameBetween(String value1, String value2) {
            addCriterion("disease_name between", value1, value2, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseNameNotBetween(String value1, String value2) {
            addCriterion("disease_name not between", value1, value2, "diseaseName");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedIsNull() {
            addCriterion("disease_symptom_related is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedIsNotNull() {
            addCriterion("disease_symptom_related is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedEqualTo(String value) {
            addCriterion("disease_symptom_related =", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedNotEqualTo(String value) {
            addCriterion("disease_symptom_related <>", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedGreaterThan(String value) {
            addCriterion("disease_symptom_related >", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedGreaterThanOrEqualTo(String value) {
            addCriterion("disease_symptom_related >=", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedLessThan(String value) {
            addCriterion("disease_symptom_related <", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedLessThanOrEqualTo(String value) {
            addCriterion("disease_symptom_related <=", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedLike(String value) {
            addCriterion("disease_symptom_related like", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedNotLike(String value) {
            addCriterion("disease_symptom_related not like", value, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedIn(List<String> values) {
            addCriterion("disease_symptom_related in", values, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedNotIn(List<String> values) {
            addCriterion("disease_symptom_related not in", values, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedBetween(String value1, String value2) {
            addCriterion("disease_symptom_related between", value1, value2, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseSymptomRelatedNotBetween(String value1, String value2) {
            addCriterion("disease_symptom_related not between", value1, value2, "diseaseSymptomRelated");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransIsNull() {
            addCriterion("disease_trans is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransIsNotNull() {
            addCriterion("disease_trans is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransEqualTo(String value) {
            addCriterion("disease_trans =", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransNotEqualTo(String value) {
            addCriterion("disease_trans <>", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransGreaterThan(String value) {
            addCriterion("disease_trans >", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransGreaterThanOrEqualTo(String value) {
            addCriterion("disease_trans >=", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransLessThan(String value) {
            addCriterion("disease_trans <", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransLessThanOrEqualTo(String value) {
            addCriterion("disease_trans <=", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransLike(String value) {
            addCriterion("disease_trans like", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransNotLike(String value) {
            addCriterion("disease_trans not like", value, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransIn(List<String> values) {
            addCriterion("disease_trans in", values, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransNotIn(List<String> values) {
            addCriterion("disease_trans not in", values, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransBetween(String value1, String value2) {
            addCriterion("disease_trans between", value1, value2, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTransNotBetween(String value1, String value2) {
            addCriterion("disease_trans not between", value1, value2, "diseaseTrans");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsIsNull() {
            addCriterion("disease_treatment_costs is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsIsNotNull() {
            addCriterion("disease_treatment_costs is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsEqualTo(String value) {
            addCriterion("disease_treatment_costs =", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsNotEqualTo(String value) {
            addCriterion("disease_treatment_costs <>", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsGreaterThan(String value) {
            addCriterion("disease_treatment_costs >", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsGreaterThanOrEqualTo(String value) {
            addCriterion("disease_treatment_costs >=", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsLessThan(String value) {
            addCriterion("disease_treatment_costs <", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsLessThanOrEqualTo(String value) {
            addCriterion("disease_treatment_costs <=", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsLike(String value) {
            addCriterion("disease_treatment_costs like", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsNotLike(String value) {
            addCriterion("disease_treatment_costs not like", value, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsIn(List<String> values) {
            addCriterion("disease_treatment_costs in", values, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsNotIn(List<String> values) {
            addCriterion("disease_treatment_costs not in", values, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsBetween(String value1, String value2) {
            addCriterion("disease_treatment_costs between", value1, value2, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCostsNotBetween(String value1, String value2) {
            addCriterion("disease_treatment_costs not between", value1, value2, "diseaseTreatmentCosts");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleIsNull() {
            addCriterion("disease_treatment_cycle is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleIsNotNull() {
            addCriterion("disease_treatment_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleEqualTo(String value) {
            addCriterion("disease_treatment_cycle =", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleNotEqualTo(String value) {
            addCriterion("disease_treatment_cycle <>", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleGreaterThan(String value) {
            addCriterion("disease_treatment_cycle >", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleGreaterThanOrEqualTo(String value) {
            addCriterion("disease_treatment_cycle >=", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleLessThan(String value) {
            addCriterion("disease_treatment_cycle <", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleLessThanOrEqualTo(String value) {
            addCriterion("disease_treatment_cycle <=", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleLike(String value) {
            addCriterion("disease_treatment_cycle like", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleNotLike(String value) {
            addCriterion("disease_treatment_cycle not like", value, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleIn(List<String> values) {
            addCriterion("disease_treatment_cycle in", values, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleNotIn(List<String> values) {
            addCriterion("disease_treatment_cycle not in", values, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleBetween(String value1, String value2) {
            addCriterion("disease_treatment_cycle between", value1, value2, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentCycleNotBetween(String value1, String value2) {
            addCriterion("disease_treatment_cycle not between", value1, value2, "diseaseTreatmentCycle");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodIsNull() {
            addCriterion("disease_treatment_method is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodIsNotNull() {
            addCriterion("disease_treatment_method is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodEqualTo(String value) {
            addCriterion("disease_treatment_method =", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodNotEqualTo(String value) {
            addCriterion("disease_treatment_method <>", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodGreaterThan(String value) {
            addCriterion("disease_treatment_method >", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodGreaterThanOrEqualTo(String value) {
            addCriterion("disease_treatment_method >=", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodLessThan(String value) {
            addCriterion("disease_treatment_method <", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodLessThanOrEqualTo(String value) {
            addCriterion("disease_treatment_method <=", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodLike(String value) {
            addCriterion("disease_treatment_method like", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodNotLike(String value) {
            addCriterion("disease_treatment_method not like", value, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodIn(List<String> values) {
            addCriterion("disease_treatment_method in", values, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodNotIn(List<String> values) {
            addCriterion("disease_treatment_method not in", values, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodBetween(String value1, String value2) {
            addCriterion("disease_treatment_method between", value1, value2, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseTreatmentMethodNotBetween(String value1, String value2) {
            addCriterion("disease_treatment_method not between", value1, value2, "diseaseTreatmentMethod");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentIsNull() {
            addCriterion("disease_visit_department is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentIsNotNull() {
            addCriterion("disease_visit_department is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentEqualTo(String value) {
            addCriterion("disease_visit_department =", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentNotEqualTo(String value) {
            addCriterion("disease_visit_department <>", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentGreaterThan(String value) {
            addCriterion("disease_visit_department >", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("disease_visit_department >=", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentLessThan(String value) {
            addCriterion("disease_visit_department <", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentLessThanOrEqualTo(String value) {
            addCriterion("disease_visit_department <=", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentLike(String value) {
            addCriterion("disease_visit_department like", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentNotLike(String value) {
            addCriterion("disease_visit_department not like", value, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentIn(List<String> values) {
            addCriterion("disease_visit_department in", values, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentNotIn(List<String> values) {
            addCriterion("disease_visit_department not in", values, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentBetween(String value1, String value2) {
            addCriterion("disease_visit_department between", value1, value2, "diseaseVisitDepartment");
            return (Criteria) this;
        }

        public Criteria andDiseaseVisitDepartmentNotBetween(String value1, String value2) {
            addCriterion("disease_visit_department not between", value1, value2, "diseaseVisitDepartment");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}