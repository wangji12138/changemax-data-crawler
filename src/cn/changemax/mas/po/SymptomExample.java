package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class SymptomExample {
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
	
    public SymptomExample() {
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

        public Criteria andSymptomIdIsNull() {
            addCriterion("symptom_id is null");
            return (Criteria) this;
        }

        public Criteria andSymptomIdIsNotNull() {
            addCriterion("symptom_id is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomIdEqualTo(String value) {
            addCriterion("symptom_id =", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotEqualTo(String value) {
            addCriterion("symptom_id <>", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdGreaterThan(String value) {
            addCriterion("symptom_id >", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdGreaterThanOrEqualTo(String value) {
            addCriterion("symptom_id >=", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdLessThan(String value) {
            addCriterion("symptom_id <", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdLessThanOrEqualTo(String value) {
            addCriterion("symptom_id <=", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdLike(String value) {
            addCriterion("symptom_id like", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotLike(String value) {
            addCriterion("symptom_id not like", value, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdIn(List<String> values) {
            addCriterion("symptom_id in", values, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotIn(List<String> values) {
            addCriterion("symptom_id not in", values, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdBetween(String value1, String value2) {
            addCriterion("symptom_id between", value1, value2, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSymptomIdNotBetween(String value1, String value2) {
            addCriterion("symptom_id not between", value1, value2, "symptomId");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentIsNull() {
            addCriterion("suggested_treatment_department is null");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentIsNotNull() {
            addCriterion("suggested_treatment_department is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentEqualTo(String value) {
            addCriterion("suggested_treatment_department =", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentNotEqualTo(String value) {
            addCriterion("suggested_treatment_department <>", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentGreaterThan(String value) {
            addCriterion("suggested_treatment_department >", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("suggested_treatment_department >=", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentLessThan(String value) {
            addCriterion("suggested_treatment_department <", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentLessThanOrEqualTo(String value) {
            addCriterion("suggested_treatment_department <=", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentLike(String value) {
            addCriterion("suggested_treatment_department like", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentNotLike(String value) {
            addCriterion("suggested_treatment_department not like", value, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentIn(List<String> values) {
            addCriterion("suggested_treatment_department in", values, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentNotIn(List<String> values) {
            addCriterion("suggested_treatment_department not in", values, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentBetween(String value1, String value2) {
            addCriterion("suggested_treatment_department between", value1, value2, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSuggestedTreatmentDepartmentNotBetween(String value1, String value2) {
            addCriterion("suggested_treatment_department not between", value1, value2, "suggestedTreatmentDepartment");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlIsNull() {
            addCriterion("symptom_image_url is null");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlIsNotNull() {
            addCriterion("symptom_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlEqualTo(String value) {
            addCriterion("symptom_image_url =", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlNotEqualTo(String value) {
            addCriterion("symptom_image_url <>", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlGreaterThan(String value) {
            addCriterion("symptom_image_url >", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("symptom_image_url >=", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlLessThan(String value) {
            addCriterion("symptom_image_url <", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlLessThanOrEqualTo(String value) {
            addCriterion("symptom_image_url <=", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlLike(String value) {
            addCriterion("symptom_image_url like", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlNotLike(String value) {
            addCriterion("symptom_image_url not like", value, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlIn(List<String> values) {
            addCriterion("symptom_image_url in", values, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlNotIn(List<String> values) {
            addCriterion("symptom_image_url not in", values, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlBetween(String value1, String value2) {
            addCriterion("symptom_image_url between", value1, value2, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomImageUrlNotBetween(String value1, String value2) {
            addCriterion("symptom_image_url not between", value1, value2, "symptomImageUrl");
            return (Criteria) this;
        }

        public Criteria andSymptomNameIsNull() {
            addCriterion("symptom_name is null");
            return (Criteria) this;
        }

        public Criteria andSymptomNameIsNotNull() {
            addCriterion("symptom_name is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomNameEqualTo(String value) {
            addCriterion("symptom_name =", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotEqualTo(String value) {
            addCriterion("symptom_name <>", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameGreaterThan(String value) {
            addCriterion("symptom_name >", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameGreaterThanOrEqualTo(String value) {
            addCriterion("symptom_name >=", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameLessThan(String value) {
            addCriterion("symptom_name <", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameLessThanOrEqualTo(String value) {
            addCriterion("symptom_name <=", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameLike(String value) {
            addCriterion("symptom_name like", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotLike(String value) {
            addCriterion("symptom_name not like", value, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameIn(List<String> values) {
            addCriterion("symptom_name in", values, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotIn(List<String> values) {
            addCriterion("symptom_name not in", values, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameBetween(String value1, String value2) {
            addCriterion("symptom_name between", value1, value2, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomNameNotBetween(String value1, String value2) {
            addCriterion("symptom_name not between", value1, value2, "symptomName");
            return (Criteria) this;
        }

        public Criteria andSymptomTransIsNull() {
            addCriterion("symptom_trans is null");
            return (Criteria) this;
        }

        public Criteria andSymptomTransIsNotNull() {
            addCriterion("symptom_trans is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomTransEqualTo(String value) {
            addCriterion("symptom_trans =", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransNotEqualTo(String value) {
            addCriterion("symptom_trans <>", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransGreaterThan(String value) {
            addCriterion("symptom_trans >", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransGreaterThanOrEqualTo(String value) {
            addCriterion("symptom_trans >=", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransLessThan(String value) {
            addCriterion("symptom_trans <", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransLessThanOrEqualTo(String value) {
            addCriterion("symptom_trans <=", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransLike(String value) {
            addCriterion("symptom_trans like", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransNotLike(String value) {
            addCriterion("symptom_trans not like", value, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransIn(List<String> values) {
            addCriterion("symptom_trans in", values, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransNotIn(List<String> values) {
            addCriterion("symptom_trans not in", values, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransBetween(String value1, String value2) {
            addCriterion("symptom_trans between", value1, value2, "symptomTrans");
            return (Criteria) this;
        }

        public Criteria andSymptomTransNotBetween(String value1, String value2) {
            addCriterion("symptom_trans not between", value1, value2, "symptomTrans");
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