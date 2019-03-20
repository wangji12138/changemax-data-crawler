package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
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

	public QuestionExample() {
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

		public Criteria andQuestionCategoryIdIsNull() {
			addCriterion("question_category_id is null");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdIsNotNull() {
			addCriterion("question_category_id is not null");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdEqualTo(Integer value) {
			addCriterion("question_category_id =", value, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdNotEqualTo(Integer value) {
			addCriterion("question_category_id <>", value, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdGreaterThan(Integer value) {
			addCriterion("question_category_id >", value, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("question_category_id >=", value, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdLessThan(Integer value) {
			addCriterion("question_category_id <", value, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("question_category_id <=", value, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdIn(List<Integer> values) {
			addCriterion("question_category_id in", values, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdNotIn(List<Integer> values) {
			addCriterion("question_category_id not in", values, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdBetween(Integer value1, Integer value2) {
			addCriterion("question_category_id between", value1, value2, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andQuestionCategoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("question_category_id not between", value1, value2, "questionCategoryId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdIsNull() {
			addCriterion("adoption_answer_id is null");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdIsNotNull() {
			addCriterion("adoption_answer_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdEqualTo(String value) {
			addCriterion("adoption_answer_id =", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdNotEqualTo(String value) {
			addCriterion("adoption_answer_id <>", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdGreaterThan(String value) {
			addCriterion("adoption_answer_id >", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdGreaterThanOrEqualTo(String value) {
			addCriterion("adoption_answer_id >=", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdLessThan(String value) {
			addCriterion("adoption_answer_id <", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdLessThanOrEqualTo(String value) {
			addCriterion("adoption_answer_id <=", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdLike(String value) {
			addCriterion("adoption_answer_id like", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdNotLike(String value) {
			addCriterion("adoption_answer_id not like", value, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdIn(List<String> values) {
			addCriterion("adoption_answer_id in", values, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdNotIn(List<String> values) {
			addCriterion("adoption_answer_id not in", values, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdBetween(String value1, String value2) {
			addCriterion("adoption_answer_id between", value1, value2, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andAdoptionAnswerIdNotBetween(String value1, String value2) {
			addCriterion("adoption_answer_id not between", value1, value2, "adoptionAnswerId");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleIsNull() {
			addCriterion("question_title is null");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleIsNotNull() {
			addCriterion("question_title is not null");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleEqualTo(String value) {
			addCriterion("question_title =", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleNotEqualTo(String value) {
			addCriterion("question_title <>", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleGreaterThan(String value) {
			addCriterion("question_title >", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleGreaterThanOrEqualTo(String value) {
			addCriterion("question_title >=", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleLessThan(String value) {
			addCriterion("question_title <", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleLessThanOrEqualTo(String value) {
			addCriterion("question_title <=", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleLike(String value) {
			addCriterion("question_title like", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleNotLike(String value) {
			addCriterion("question_title not like", value, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleIn(List<String> values) {
			addCriterion("question_title in", values, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleNotIn(List<String> values) {
			addCriterion("question_title not in", values, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleBetween(String value1, String value2) {
			addCriterion("question_title between", value1, value2, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionTitleNotBetween(String value1, String value2) {
			addCriterion("question_title not between", value1, value2, "questionTitle");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailIsNull() {
			addCriterion("question_detail is null");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailIsNotNull() {
			addCriterion("question_detail is not null");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailEqualTo(String value) {
			addCriterion("question_detail =", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailNotEqualTo(String value) {
			addCriterion("question_detail <>", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailGreaterThan(String value) {
			addCriterion("question_detail >", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailGreaterThanOrEqualTo(String value) {
			addCriterion("question_detail >=", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailLessThan(String value) {
			addCriterion("question_detail <", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailLessThanOrEqualTo(String value) {
			addCriterion("question_detail <=", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailLike(String value) {
			addCriterion("question_detail like", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailNotLike(String value) {
			addCriterion("question_detail not like", value, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailIn(List<String> values) {
			addCriterion("question_detail in", values, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailNotIn(List<String> values) {
			addCriterion("question_detail not in", values, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailBetween(String value1, String value2) {
			addCriterion("question_detail between", value1, value2, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionDetailNotBetween(String value1, String value2) {
			addCriterion("question_detail not between", value1, value2, "questionDetail");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardIsNull() {
			addCriterion("question_reward is null");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardIsNotNull() {
			addCriterion("question_reward is not null");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardEqualTo(Integer value) {
			addCriterion("question_reward =", value, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardNotEqualTo(Integer value) {
			addCriterion("question_reward <>", value, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardGreaterThan(Integer value) {
			addCriterion("question_reward >", value, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardGreaterThanOrEqualTo(Integer value) {
			addCriterion("question_reward >=", value, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardLessThan(Integer value) {
			addCriterion("question_reward <", value, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardLessThanOrEqualTo(Integer value) {
			addCriterion("question_reward <=", value, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardIn(List<Integer> values) {
			addCriterion("question_reward in", values, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardNotIn(List<Integer> values) {
			addCriterion("question_reward not in", values, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardBetween(Integer value1, Integer value2) {
			addCriterion("question_reward between", value1, value2, "questionReward");
			return (Criteria) this;
		}

		public Criteria andQuestionRewardNotBetween(Integer value1, Integer value2) {
			addCriterion("question_reward not between", value1, value2, "questionReward");
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

		public Criteria andViewsIsNull() {
			addCriterion("views is null");
			return (Criteria) this;
		}

		public Criteria andViewsIsNotNull() {
			addCriterion("views is not null");
			return (Criteria) this;
		}

		public Criteria andViewsEqualTo(Integer value) {
			addCriterion("views =", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsNotEqualTo(Integer value) {
			addCriterion("views <>", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsGreaterThan(Integer value) {
			addCriterion("views >", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
			addCriterion("views >=", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsLessThan(Integer value) {
			addCriterion("views <", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsLessThanOrEqualTo(Integer value) {
			addCriterion("views <=", value, "views");
			return (Criteria) this;
		}

		public Criteria andViewsIn(List<Integer> values) {
			addCriterion("views in", values, "views");
			return (Criteria) this;
		}

		public Criteria andViewsNotIn(List<Integer> values) {
			addCriterion("views not in", values, "views");
			return (Criteria) this;
		}

		public Criteria andViewsBetween(Integer value1, Integer value2) {
			addCriterion("views between", value1, value2, "views");
			return (Criteria) this;
		}

		public Criteria andViewsNotBetween(Integer value1, Integer value2) {
			addCriterion("views not between", value1, value2, "views");
			return (Criteria) this;
		}

		public Criteria andIsFineIsNull() {
			addCriterion("is_fine is null");
			return (Criteria) this;
		}

		public Criteria andIsFineIsNotNull() {
			addCriterion("is_fine is not null");
			return (Criteria) this;
		}

		public Criteria andIsFineEqualTo(Integer value) {
			addCriterion("is_fine =", value, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineNotEqualTo(Integer value) {
			addCriterion("is_fine <>", value, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineGreaterThan(Integer value) {
			addCriterion("is_fine >", value, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_fine >=", value, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineLessThan(Integer value) {
			addCriterion("is_fine <", value, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineLessThanOrEqualTo(Integer value) {
			addCriterion("is_fine <=", value, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineIn(List<Integer> values) {
			addCriterion("is_fine in", values, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineNotIn(List<Integer> values) {
			addCriterion("is_fine not in", values, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineBetween(Integer value1, Integer value2) {
			addCriterion("is_fine between", value1, value2, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsFineNotBetween(Integer value1, Integer value2) {
			addCriterion("is_fine not between", value1, value2, "isFine");
			return (Criteria) this;
		}

		public Criteria andIsTopIsNull() {
			addCriterion("is_top is null");
			return (Criteria) this;
		}

		public Criteria andIsTopIsNotNull() {
			addCriterion("is_top is not null");
			return (Criteria) this;
		}

		public Criteria andIsTopEqualTo(Integer value) {
			addCriterion("is_top =", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotEqualTo(Integer value) {
			addCriterion("is_top <>", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopGreaterThan(Integer value) {
			addCriterion("is_top >", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_top >=", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopLessThan(Integer value) {
			addCriterion("is_top <", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopLessThanOrEqualTo(Integer value) {
			addCriterion("is_top <=", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopIn(List<Integer> values) {
			addCriterion("is_top in", values, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotIn(List<Integer> values) {
			addCriterion("is_top not in", values, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopBetween(Integer value1, Integer value2) {
			addCriterion("is_top between", value1, value2, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotBetween(Integer value1, Integer value2) {
			addCriterion("is_top not between", value1, value2, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousIsNull() {
			addCriterion("is_anonymous is null");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousIsNotNull() {
			addCriterion("is_anonymous is not null");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousEqualTo(Integer value) {
			addCriterion("is_anonymous =", value, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousNotEqualTo(Integer value) {
			addCriterion("is_anonymous <>", value, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousGreaterThan(Integer value) {
			addCriterion("is_anonymous >", value, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_anonymous >=", value, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousLessThan(Integer value) {
			addCriterion("is_anonymous <", value, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousLessThanOrEqualTo(Integer value) {
			addCriterion("is_anonymous <=", value, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousIn(List<Integer> values) {
			addCriterion("is_anonymous in", values, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousNotIn(List<Integer> values) {
			addCriterion("is_anonymous not in", values, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousBetween(Integer value1, Integer value2) {
			addCriterion("is_anonymous between", value1, value2, "isAnonymous");
			return (Criteria) this;
		}

		public Criteria andIsAnonymousNotBetween(Integer value1, Integer value2) {
			addCriterion("is_anonymous not between", value1, value2, "isAnonymous");
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