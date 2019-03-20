package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class MedicalNounExample {
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
	
    public MedicalNounExample() {
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

        public Criteria andNounIdIsNull() {
            addCriterion("noun_id is null");
            return (Criteria) this;
        }

        public Criteria andNounIdIsNotNull() {
            addCriterion("noun_id is not null");
            return (Criteria) this;
        }

        public Criteria andNounIdEqualTo(Integer value) {
            addCriterion("noun_id =", value, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdNotEqualTo(Integer value) {
            addCriterion("noun_id <>", value, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdGreaterThan(Integer value) {
            addCriterion("noun_id >", value, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("noun_id >=", value, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdLessThan(Integer value) {
            addCriterion("noun_id <", value, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdLessThanOrEqualTo(Integer value) {
            addCriterion("noun_id <=", value, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdIn(List<Integer> values) {
            addCriterion("noun_id in", values, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdNotIn(List<Integer> values) {
            addCriterion("noun_id not in", values, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdBetween(Integer value1, Integer value2) {
            addCriterion("noun_id between", value1, value2, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounIdNotBetween(Integer value1, Integer value2) {
            addCriterion("noun_id not between", value1, value2, "nounId");
            return (Criteria) this;
        }

        public Criteria andNounNameIsNull() {
            addCriterion("noun_name is null");
            return (Criteria) this;
        }

        public Criteria andNounNameIsNotNull() {
            addCriterion("noun_name is not null");
            return (Criteria) this;
        }

        public Criteria andNounNameEqualTo(String value) {
            addCriterion("noun_name =", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameNotEqualTo(String value) {
            addCriterion("noun_name <>", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameGreaterThan(String value) {
            addCriterion("noun_name >", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameGreaterThanOrEqualTo(String value) {
            addCriterion("noun_name >=", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameLessThan(String value) {
            addCriterion("noun_name <", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameLessThanOrEqualTo(String value) {
            addCriterion("noun_name <=", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameLike(String value) {
            addCriterion("noun_name like", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameNotLike(String value) {
            addCriterion("noun_name not like", value, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameIn(List<String> values) {
            addCriterion("noun_name in", values, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameNotIn(List<String> values) {
            addCriterion("noun_name not in", values, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameBetween(String value1, String value2) {
            addCriterion("noun_name between", value1, value2, "nounName");
            return (Criteria) this;
        }

        public Criteria andNounNameNotBetween(String value1, String value2) {
            addCriterion("noun_name not between", value1, value2, "nounName");
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