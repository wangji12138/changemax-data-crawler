package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class QaRequestExample {
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
	
    public QaRequestExample() {
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

        public Criteria andQaRequestIdIsNull() {
            addCriterion("qa_request_id is null");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdIsNotNull() {
            addCriterion("qa_request_id is not null");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdEqualTo(String value) {
            addCriterion("qa_request_id =", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdNotEqualTo(String value) {
            addCriterion("qa_request_id <>", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdGreaterThan(String value) {
            addCriterion("qa_request_id >", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("qa_request_id >=", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdLessThan(String value) {
            addCriterion("qa_request_id <", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdLessThanOrEqualTo(String value) {
            addCriterion("qa_request_id <=", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdLike(String value) {
            addCriterion("qa_request_id like", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdNotLike(String value) {
            addCriterion("qa_request_id not like", value, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdIn(List<String> values) {
            addCriterion("qa_request_id in", values, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdNotIn(List<String> values) {
            addCriterion("qa_request_id not in", values, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdBetween(String value1, String value2) {
            addCriterion("qa_request_id between", value1, value2, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestIdNotBetween(String value1, String value2) {
            addCriterion("qa_request_id not between", value1, value2, "qaRequestId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdIsNull() {
            addCriterion("qa_request_user_id is null");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdIsNotNull() {
            addCriterion("qa_request_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdEqualTo(String value) {
            addCriterion("qa_request_user_id =", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdNotEqualTo(String value) {
            addCriterion("qa_request_user_id <>", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdGreaterThan(String value) {
            addCriterion("qa_request_user_id >", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("qa_request_user_id >=", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdLessThan(String value) {
            addCriterion("qa_request_user_id <", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdLessThanOrEqualTo(String value) {
            addCriterion("qa_request_user_id <=", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdLike(String value) {
            addCriterion("qa_request_user_id like", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdNotLike(String value) {
            addCriterion("qa_request_user_id not like", value, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdIn(List<String> values) {
            addCriterion("qa_request_user_id in", values, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdNotIn(List<String> values) {
            addCriterion("qa_request_user_id not in", values, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdBetween(String value1, String value2) {
            addCriterion("qa_request_user_id between", value1, value2, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andQaRequestUserIdNotBetween(String value1, String value2) {
            addCriterion("qa_request_user_id not between", value1, value2, "qaRequestUserId");
            return (Criteria) this;
        }

        public Criteria andTextIdIsNull() {
            addCriterion("text_id is null");
            return (Criteria) this;
        }

        public Criteria andTextIdIsNotNull() {
            addCriterion("text_id is not null");
            return (Criteria) this;
        }

        public Criteria andTextIdEqualTo(String value) {
            addCriterion("text_id =", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotEqualTo(String value) {
            addCriterion("text_id <>", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdGreaterThan(String value) {
            addCriterion("text_id >", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdGreaterThanOrEqualTo(String value) {
            addCriterion("text_id >=", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdLessThan(String value) {
            addCriterion("text_id <", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdLessThanOrEqualTo(String value) {
            addCriterion("text_id <=", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdLike(String value) {
            addCriterion("text_id like", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotLike(String value) {
            addCriterion("text_id not like", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdIn(List<String> values) {
            addCriterion("text_id in", values, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotIn(List<String> values) {
            addCriterion("text_id not in", values, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdBetween(String value1, String value2) {
            addCriterion("text_id between", value1, value2, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotBetween(String value1, String value2) {
            addCriterion("text_id not between", value1, value2, "textId");
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