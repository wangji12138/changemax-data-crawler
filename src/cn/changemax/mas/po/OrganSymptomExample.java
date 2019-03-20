package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class OrganSymptomExample {
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
	
    public OrganSymptomExample() {
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

        public Criteria andOrganSymptomIdIsNull() {
            addCriterion("organ_symptom_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdIsNotNull() {
            addCriterion("organ_symptom_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdEqualTo(Integer value) {
            addCriterion("organ_symptom_id =", value, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdNotEqualTo(Integer value) {
            addCriterion("organ_symptom_id <>", value, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdGreaterThan(Integer value) {
            addCriterion("organ_symptom_id >", value, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("organ_symptom_id >=", value, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdLessThan(Integer value) {
            addCriterion("organ_symptom_id <", value, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdLessThanOrEqualTo(Integer value) {
            addCriterion("organ_symptom_id <=", value, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdIn(List<Integer> values) {
            addCriterion("organ_symptom_id in", values, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdNotIn(List<Integer> values) {
            addCriterion("organ_symptom_id not in", values, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdBetween(Integer value1, Integer value2) {
            addCriterion("organ_symptom_id between", value1, value2, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andOrganSymptomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("organ_symptom_id not between", value1, value2, "organSymptomId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdIsNull() {
            addCriterion("t_organ_id is null");
            return (Criteria) this;
        }

        public Criteria andTOrganIdIsNotNull() {
            addCriterion("t_organ_id is not null");
            return (Criteria) this;
        }

        public Criteria andTOrganIdEqualTo(Integer value) {
            addCriterion("t_organ_id =", value, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdNotEqualTo(Integer value) {
            addCriterion("t_organ_id <>", value, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdGreaterThan(Integer value) {
            addCriterion("t_organ_id >", value, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_organ_id >=", value, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdLessThan(Integer value) {
            addCriterion("t_organ_id <", value, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_organ_id <=", value, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdIn(List<Integer> values) {
            addCriterion("t_organ_id in", values, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdNotIn(List<Integer> values) {
            addCriterion("t_organ_id not in", values, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdBetween(Integer value1, Integer value2) {
            addCriterion("t_organ_id between", value1, value2, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_organ_id not between", value1, value2, "tOrganId");
            return (Criteria) this;
        }

        public Criteria andTOrganNameIsNull() {
            addCriterion("t_organ_name is null");
            return (Criteria) this;
        }

        public Criteria andTOrganNameIsNotNull() {
            addCriterion("t_organ_name is not null");
            return (Criteria) this;
        }

        public Criteria andTOrganNameEqualTo(String value) {
            addCriterion("t_organ_name =", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameNotEqualTo(String value) {
            addCriterion("t_organ_name <>", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameGreaterThan(String value) {
            addCriterion("t_organ_name >", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_organ_name >=", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameLessThan(String value) {
            addCriterion("t_organ_name <", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameLessThanOrEqualTo(String value) {
            addCriterion("t_organ_name <=", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameLike(String value) {
            addCriterion("t_organ_name like", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameNotLike(String value) {
            addCriterion("t_organ_name not like", value, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameIn(List<String> values) {
            addCriterion("t_organ_name in", values, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameNotIn(List<String> values) {
            addCriterion("t_organ_name not in", values, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameBetween(String value1, String value2) {
            addCriterion("t_organ_name between", value1, value2, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTOrganNameNotBetween(String value1, String value2) {
            addCriterion("t_organ_name not between", value1, value2, "tOrganName");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdIsNull() {
            addCriterion("t_symptom_id is null");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdIsNotNull() {
            addCriterion("t_symptom_id is not null");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdEqualTo(String value) {
            addCriterion("t_symptom_id =", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdNotEqualTo(String value) {
            addCriterion("t_symptom_id <>", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdGreaterThan(String value) {
            addCriterion("t_symptom_id >", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdGreaterThanOrEqualTo(String value) {
            addCriterion("t_symptom_id >=", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdLessThan(String value) {
            addCriterion("t_symptom_id <", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdLessThanOrEqualTo(String value) {
            addCriterion("t_symptom_id <=", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdLike(String value) {
            addCriterion("t_symptom_id like", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdNotLike(String value) {
            addCriterion("t_symptom_id not like", value, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdIn(List<String> values) {
            addCriterion("t_symptom_id in", values, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdNotIn(List<String> values) {
            addCriterion("t_symptom_id not in", values, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdBetween(String value1, String value2) {
            addCriterion("t_symptom_id between", value1, value2, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomIdNotBetween(String value1, String value2) {
            addCriterion("t_symptom_id not between", value1, value2, "tSymptomId");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameIsNull() {
            addCriterion("t_symptom_name is null");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameIsNotNull() {
            addCriterion("t_symptom_name is not null");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameEqualTo(String value) {
            addCriterion("t_symptom_name =", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameNotEqualTo(String value) {
            addCriterion("t_symptom_name <>", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameGreaterThan(String value) {
            addCriterion("t_symptom_name >", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_symptom_name >=", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameLessThan(String value) {
            addCriterion("t_symptom_name <", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameLessThanOrEqualTo(String value) {
            addCriterion("t_symptom_name <=", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameLike(String value) {
            addCriterion("t_symptom_name like", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameNotLike(String value) {
            addCriterion("t_symptom_name not like", value, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameIn(List<String> values) {
            addCriterion("t_symptom_name in", values, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameNotIn(List<String> values) {
            addCriterion("t_symptom_name not in", values, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameBetween(String value1, String value2) {
            addCriterion("t_symptom_name between", value1, value2, "tSymptomName");
            return (Criteria) this;
        }

        public Criteria andTSymptomNameNotBetween(String value1, String value2) {
            addCriterion("t_symptom_name not between", value1, value2, "tSymptomName");
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