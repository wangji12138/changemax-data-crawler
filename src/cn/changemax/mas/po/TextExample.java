package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextExample {
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
	
    public TextExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andTextContentIsNull() {
            addCriterion("text_content is null");
            return (Criteria) this;
        }

        public Criteria andTextContentIsNotNull() {
            addCriterion("text_content is not null");
            return (Criteria) this;
        }

        public Criteria andTextContentEqualTo(String value) {
            addCriterion("text_content =", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotEqualTo(String value) {
            addCriterion("text_content <>", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentGreaterThan(String value) {
            addCriterion("text_content >", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentGreaterThanOrEqualTo(String value) {
            addCriterion("text_content >=", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLessThan(String value) {
            addCriterion("text_content <", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLessThanOrEqualTo(String value) {
            addCriterion("text_content <=", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLike(String value) {
            addCriterion("text_content like", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotLike(String value) {
            addCriterion("text_content not like", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentIn(List<String> values) {
            addCriterion("text_content in", values, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotIn(List<String> values) {
            addCriterion("text_content not in", values, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentBetween(String value1, String value2) {
            addCriterion("text_content between", value1, value2, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotBetween(String value1, String value2) {
            addCriterion("text_content not between", value1, value2, "textContent");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakIsNull() {
            addCriterion("is_change_max_speak is null");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakIsNotNull() {
            addCriterion("is_change_max_speak is not null");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakEqualTo(Boolean value) {
            addCriterion("is_change_max_speak =", value, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakNotEqualTo(Boolean value) {
            addCriterion("is_change_max_speak <>", value, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakGreaterThan(Boolean value) {
            addCriterion("is_change_max_speak >", value, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_change_max_speak >=", value, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakLessThan(Boolean value) {
            addCriterion("is_change_max_speak <", value, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakLessThanOrEqualTo(Boolean value) {
            addCriterion("is_change_max_speak <=", value, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakIn(List<Boolean> values) {
            addCriterion("is_change_max_speak in", values, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakNotIn(List<Boolean> values) {
            addCriterion("is_change_max_speak not in", values, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakBetween(Boolean value1, Boolean value2) {
            addCriterion("is_change_max_speak between", value1, value2, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andIsChangeMaxSpeakNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_change_max_speak not between", value1, value2, "isChangeMaxSpeak");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeIsNull() {
            addCriterion("generation_time is null");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeIsNotNull() {
            addCriterion("generation_time is not null");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeEqualTo(Date value) {
            addCriterion("generation_time =", value, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeNotEqualTo(Date value) {
            addCriterion("generation_time <>", value, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeGreaterThan(Date value) {
            addCriterion("generation_time >", value, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("generation_time >=", value, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeLessThan(Date value) {
            addCriterion("generation_time <", value, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeLessThanOrEqualTo(Date value) {
            addCriterion("generation_time <=", value, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeIn(List<Date> values) {
            addCriterion("generation_time in", values, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeNotIn(List<Date> values) {
            addCriterion("generation_time not in", values, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeBetween(Date value1, Date value2) {
            addCriterion("generation_time between", value1, value2, "generationTime");
            return (Criteria) this;
        }

        public Criteria andGenerationTimeNotBetween(Date value1, Date value2) {
            addCriterion("generation_time not between", value1, value2, "generationTime");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdIsNull() {
            addCriterion("speaker_id is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdIsNotNull() {
            addCriterion("speaker_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdEqualTo(String value) {
            addCriterion("speaker_id =", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotEqualTo(String value) {
            addCriterion("speaker_id <>", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdGreaterThan(String value) {
            addCriterion("speaker_id >", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_id >=", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdLessThan(String value) {
            addCriterion("speaker_id <", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdLessThanOrEqualTo(String value) {
            addCriterion("speaker_id <=", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdLike(String value) {
            addCriterion("speaker_id like", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotLike(String value) {
            addCriterion("speaker_id not like", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdIn(List<String> values) {
            addCriterion("speaker_id in", values, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotIn(List<String> values) {
            addCriterion("speaker_id not in", values, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdBetween(String value1, String value2) {
            addCriterion("speaker_id between", value1, value2, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotBetween(String value1, String value2) {
            addCriterion("speaker_id not between", value1, value2, "speakerId");
            return (Criteria) this;
        }

        public Criteria andTalkingContentIsNull() {
            addCriterion("talking_content is null");
            return (Criteria) this;
        }

        public Criteria andTalkingContentIsNotNull() {
            addCriterion("talking_content is not null");
            return (Criteria) this;
        }

        public Criteria andTalkingContentEqualTo(String value) {
            addCriterion("talking_content =", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentNotEqualTo(String value) {
            addCriterion("talking_content <>", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentGreaterThan(String value) {
            addCriterion("talking_content >", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentGreaterThanOrEqualTo(String value) {
            addCriterion("talking_content >=", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentLessThan(String value) {
            addCriterion("talking_content <", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentLessThanOrEqualTo(String value) {
            addCriterion("talking_content <=", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentLike(String value) {
            addCriterion("talking_content like", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentNotLike(String value) {
            addCriterion("talking_content not like", value, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentIn(List<String> values) {
            addCriterion("talking_content in", values, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentNotIn(List<String> values) {
            addCriterion("talking_content not in", values, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentBetween(String value1, String value2) {
            addCriterion("talking_content between", value1, value2, "talkingContent");
            return (Criteria) this;
        }

        public Criteria andTalkingContentNotBetween(String value1, String value2) {
            addCriterion("talking_content not between", value1, value2, "talkingContent");
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