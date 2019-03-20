package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerExample {
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

	public AnswerExample() {
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

		public Criteria andAnswerIdIsNull() {
			addCriterion("answer_id is null");
			return (Criteria) this;
		}

		public Criteria andAnswerIdIsNotNull() {
			addCriterion("answer_id is not null");
			return (Criteria) this;
		}

		public Criteria andAnswerIdEqualTo(String value) {
			addCriterion("answer_id =", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdNotEqualTo(String value) {
			addCriterion("answer_id <>", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdGreaterThan(String value) {
			addCriterion("answer_id >", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdGreaterThanOrEqualTo(String value) {
			addCriterion("answer_id >=", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdLessThan(String value) {
			addCriterion("answer_id <", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdLessThanOrEqualTo(String value) {
			addCriterion("answer_id <=", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdLike(String value) {
			addCriterion("answer_id like", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdNotLike(String value) {
			addCriterion("answer_id not like", value, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdIn(List<String> values) {
			addCriterion("answer_id in", values, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdNotIn(List<String> values) {
			addCriterion("answer_id not in", values, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdBetween(String value1, String value2) {
			addCriterion("answer_id between", value1, value2, "answerId");
			return (Criteria) this;
		}

		public Criteria andAnswerIdNotBetween(String value1, String value2) {
			addCriterion("answer_id not between", value1, value2, "answerId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdIsNull() {
			addCriterion("question_id is null");
			return (Criteria) this;
		}

		public Criteria andQuestionIdIsNotNull() {
			addCriterion("question_id is not null");
			return (Criteria) this;
		}

		public Criteria andQuestionIdEqualTo(String value) {
			addCriterion("question_id =", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdNotEqualTo(String value) {
			addCriterion("question_id <>", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdGreaterThan(String value) {
			addCriterion("question_id >", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdGreaterThanOrEqualTo(String value) {
			addCriterion("question_id >=", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdLessThan(String value) {
			addCriterion("question_id <", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdLessThanOrEqualTo(String value) {
			addCriterion("question_id <=", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdLike(String value) {
			addCriterion("question_id like", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdNotLike(String value) {
			addCriterion("question_id not like", value, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdIn(List<String> values) {
			addCriterion("question_id in", values, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdNotIn(List<String> values) {
			addCriterion("question_id not in", values, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdBetween(String value1, String value2) {
			addCriterion("question_id between", value1, value2, "questionId");
			return (Criteria) this;
		}

		public Criteria andQuestionIdNotBetween(String value1, String value2) {
			addCriterion("question_id not between", value1, value2, "questionId");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionIsNull() {
			addCriterion("original_question is null");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionIsNotNull() {
			addCriterion("original_question is not null");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionEqualTo(String value) {
			addCriterion("original_question =", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionNotEqualTo(String value) {
			addCriterion("original_question <>", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionGreaterThan(String value) {
			addCriterion("original_question >", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionGreaterThanOrEqualTo(String value) {
			addCriterion("original_question >=", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionLessThan(String value) {
			addCriterion("original_question <", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionLessThanOrEqualTo(String value) {
			addCriterion("original_question <=", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionLike(String value) {
			addCriterion("original_question like", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionNotLike(String value) {
			addCriterion("original_question not like", value, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionIn(List<String> values) {
			addCriterion("original_question in", values, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionNotIn(List<String> values) {
			addCriterion("original_question not in", values, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionBetween(String value1, String value2) {
			addCriterion("original_question between", value1, value2, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andOriginalQuestionNotBetween(String value1, String value2) {
			addCriterion("original_question not between", value1, value2, "originalQuestion");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityIsNull() {
			addCriterion("question_similarity is null");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityIsNotNull() {
			addCriterion("question_similarity is not null");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityEqualTo(Double value) {
			addCriterion("question_similarity =", value, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityNotEqualTo(Double value) {
			addCriterion("question_similarity <>", value, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityGreaterThan(Double value) {
			addCriterion("question_similarity >", value, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityGreaterThanOrEqualTo(Double value) {
			addCriterion("question_similarity >=", value, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityLessThan(Double value) {
			addCriterion("question_similarity <", value, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityLessThanOrEqualTo(Double value) {
			addCriterion("question_similarity <=", value, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityIn(List<Double> values) {
			addCriterion("question_similarity in", values, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityNotIn(List<Double> values) {
			addCriterion("question_similarity not in", values, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityBetween(Double value1, Double value2) {
			addCriterion("question_similarity between", value1, value2, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andQuestionSimilarityNotBetween(Double value1, Double value2) {
			addCriterion("question_similarity not between", value1, value2, "questionSimilarity");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeIsNull() {
			addCriterion("answer_type is null");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeIsNotNull() {
			addCriterion("answer_type is not null");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeEqualTo(String value) {
			addCriterion("answer_type =", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeNotEqualTo(String value) {
			addCriterion("answer_type <>", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeGreaterThan(String value) {
			addCriterion("answer_type >", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeGreaterThanOrEqualTo(String value) {
			addCriterion("answer_type >=", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeLessThan(String value) {
			addCriterion("answer_type <", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeLessThanOrEqualTo(String value) {
			addCriterion("answer_type <=", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeLike(String value) {
			addCriterion("answer_type like", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeNotLike(String value) {
			addCriterion("answer_type not like", value, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeIn(List<String> values) {
			addCriterion("answer_type in", values, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeNotIn(List<String> values) {
			addCriterion("answer_type not in", values, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeBetween(String value1, String value2) {
			addCriterion("answer_type between", value1, value2, "answerType");
			return (Criteria) this;
		}

		public Criteria andAnswerTypeNotBetween(String value1, String value2) {
			addCriterion("answer_type not between", value1, value2, "answerType");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlIsNull() {
			addCriterion("related_url is null");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlIsNotNull() {
			addCriterion("related_url is not null");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlEqualTo(String value) {
			addCriterion("related_url =", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlNotEqualTo(String value) {
			addCriterion("related_url <>", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlGreaterThan(String value) {
			addCriterion("related_url >", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlGreaterThanOrEqualTo(String value) {
			addCriterion("related_url >=", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlLessThan(String value) {
			addCriterion("related_url <", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlLessThanOrEqualTo(String value) {
			addCriterion("related_url <=", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlLike(String value) {
			addCriterion("related_url like", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlNotLike(String value) {
			addCriterion("related_url not like", value, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlIn(List<String> values) {
			addCriterion("related_url in", values, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlNotIn(List<String> values) {
			addCriterion("related_url not in", values, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlBetween(String value1, String value2) {
			addCriterion("related_url between", value1, value2, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andRelatedUrlNotBetween(String value1, String value2) {
			addCriterion("related_url not between", value1, value2, "relatedUrl");
			return (Criteria) this;
		}

		public Criteria andGenerationDateIsNull() {
			addCriterion("generation_date is null");
			return (Criteria) this;
		}

		public Criteria andGenerationDateIsNotNull() {
			addCriterion("generation_date is not null");
			return (Criteria) this;
		}

		public Criteria andGenerationDateEqualTo(Date value) {
			addCriterion("generation_date =", value, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateNotEqualTo(Date value) {
			addCriterion("generation_date <>", value, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateGreaterThan(Date value) {
			addCriterion("generation_date >", value, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateGreaterThanOrEqualTo(Date value) {
			addCriterion("generation_date >=", value, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateLessThan(Date value) {
			addCriterion("generation_date <", value, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateLessThanOrEqualTo(Date value) {
			addCriterion("generation_date <=", value, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateIn(List<Date> values) {
			addCriterion("generation_date in", values, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateNotIn(List<Date> values) {
			addCriterion("generation_date not in", values, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateBetween(Date value1, Date value2) {
			addCriterion("generation_date between", value1, value2, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGenerationDateNotBetween(Date value1, Date value2) {
			addCriterion("generation_date not between", value1, value2, "generationDate");
			return (Criteria) this;
		}

		public Criteria andGoodNumberIsNull() {
			addCriterion("good_number is null");
			return (Criteria) this;
		}

		public Criteria andGoodNumberIsNotNull() {
			addCriterion("good_number is not null");
			return (Criteria) this;
		}

		public Criteria andGoodNumberEqualTo(Integer value) {
			addCriterion("good_number =", value, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberNotEqualTo(Integer value) {
			addCriterion("good_number <>", value, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberGreaterThan(Integer value) {
			addCriterion("good_number >", value, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("good_number >=", value, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberLessThan(Integer value) {
			addCriterion("good_number <", value, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberLessThanOrEqualTo(Integer value) {
			addCriterion("good_number <=", value, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberIn(List<Integer> values) {
			addCriterion("good_number in", values, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberNotIn(List<Integer> values) {
			addCriterion("good_number not in", values, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberBetween(Integer value1, Integer value2) {
			addCriterion("good_number between", value1, value2, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andGoodNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("good_number not between", value1, value2, "goodNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberIsNull() {
			addCriterion("bad_number is null");
			return (Criteria) this;
		}

		public Criteria andBadNumberIsNotNull() {
			addCriterion("bad_number is not null");
			return (Criteria) this;
		}

		public Criteria andBadNumberEqualTo(Integer value) {
			addCriterion("bad_number =", value, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberNotEqualTo(Integer value) {
			addCriterion("bad_number <>", value, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberGreaterThan(Integer value) {
			addCriterion("bad_number >", value, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("bad_number >=", value, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberLessThan(Integer value) {
			addCriterion("bad_number <", value, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberLessThanOrEqualTo(Integer value) {
			addCriterion("bad_number <=", value, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberIn(List<Integer> values) {
			addCriterion("bad_number in", values, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberNotIn(List<Integer> values) {
			addCriterion("bad_number not in", values, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberBetween(Integer value1, Integer value2) {
			addCriterion("bad_number between", value1, value2, "badNumber");
			return (Criteria) this;
		}

		public Criteria andBadNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("bad_number not between", value1, value2, "badNumber");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionIsNull() {
			addCriterion("is_adoption is null");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionIsNotNull() {
			addCriterion("is_adoption is not null");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionEqualTo(Integer value) {
			addCriterion("is_adoption =", value, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionNotEqualTo(Integer value) {
			addCriterion("is_adoption <>", value, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionGreaterThan(Integer value) {
			addCriterion("is_adoption >", value, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_adoption >=", value, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionLessThan(Integer value) {
			addCriterion("is_adoption <", value, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionLessThanOrEqualTo(Integer value) {
			addCriterion("is_adoption <=", value, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionIn(List<Integer> values) {
			addCriterion("is_adoption in", values, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionNotIn(List<Integer> values) {
			addCriterion("is_adoption not in", values, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionBetween(Integer value1, Integer value2) {
			addCriterion("is_adoption between", value1, value2, "isAdoption");
			return (Criteria) this;
		}

		public Criteria andIsAdoptionNotBetween(Integer value1, Integer value2) {
			addCriterion("is_adoption not between", value1, value2, "isAdoption");
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