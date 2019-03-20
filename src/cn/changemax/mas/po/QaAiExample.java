package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class QaAiExample {
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
	
    public QaAiExample() {
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

        public Criteria andUserTextIsNull() {
            addCriterion("user_text is null");
            return (Criteria) this;
        }

        public Criteria andUserTextIsNotNull() {
            addCriterion("user_text is not null");
            return (Criteria) this;
        }

        public Criteria andUserTextEqualTo(String value) {
            addCriterion("user_text =", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextNotEqualTo(String value) {
            addCriterion("user_text <>", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextGreaterThan(String value) {
            addCriterion("user_text >", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextGreaterThanOrEqualTo(String value) {
            addCriterion("user_text >=", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextLessThan(String value) {
            addCriterion("user_text <", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextLessThanOrEqualTo(String value) {
            addCriterion("user_text <=", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextLike(String value) {
            addCriterion("user_text like", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextNotLike(String value) {
            addCriterion("user_text not like", value, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextIn(List<String> values) {
            addCriterion("user_text in", values, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextNotIn(List<String> values) {
            addCriterion("user_text not in", values, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextBetween(String value1, String value2) {
            addCriterion("user_text between", value1, value2, "userText");
            return (Criteria) this;
        }

        public Criteria andUserTextNotBetween(String value1, String value2) {
            addCriterion("user_text not between", value1, value2, "userText");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andQaIdIsNull() {
            addCriterion("qa_id is null");
            return (Criteria) this;
        }

        public Criteria andQaIdIsNotNull() {
            addCriterion("qa_id is not null");
            return (Criteria) this;
        }

        public Criteria andQaIdEqualTo(String value) {
            addCriterion("qa_id =", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotEqualTo(String value) {
            addCriterion("qa_id <>", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdGreaterThan(String value) {
            addCriterion("qa_id >", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdGreaterThanOrEqualTo(String value) {
            addCriterion("qa_id >=", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdLessThan(String value) {
            addCriterion("qa_id <", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdLessThanOrEqualTo(String value) {
            addCriterion("qa_id <=", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdLike(String value) {
            addCriterion("qa_id like", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotLike(String value) {
            addCriterion("qa_id not like", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdIn(List<String> values) {
            addCriterion("qa_id in", values, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotIn(List<String> values) {
            addCriterion("qa_id not in", values, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdBetween(String value1, String value2) {
            addCriterion("qa_id between", value1, value2, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotBetween(String value1, String value2) {
            addCriterion("qa_id not between", value1, value2, "qaId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
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