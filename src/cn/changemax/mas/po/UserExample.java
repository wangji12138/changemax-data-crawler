package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
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

	public UserExample() {
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

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeIsNull() {
			addCriterion("user_registration_time is null");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeIsNotNull() {
			addCriterion("user_registration_time is not null");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeEqualTo(Date value) {
			addCriterion("user_registration_time =", value, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeNotEqualTo(Date value) {
			addCriterion("user_registration_time <>", value, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeGreaterThan(Date value) {
			addCriterion("user_registration_time >", value, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("user_registration_time >=", value, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeLessThan(Date value) {
			addCriterion("user_registration_time <", value, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeLessThanOrEqualTo(Date value) {
			addCriterion("user_registration_time <=", value, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeIn(List<Date> values) {
			addCriterion("user_registration_time in", values, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeNotIn(List<Date> values) {
			addCriterion("user_registration_time not in", values, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeBetween(Date value1, Date value2) {
			addCriterion("user_registration_time between", value1, value2, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserRegistrationTimeNotBetween(Date value1, Date value2) {
			addCriterion("user_registration_time not between", value1, value2, "userRegistrationTime");
			return (Criteria) this;
		}

		public Criteria andUserGenderIsNull() {
			addCriterion("user_gender is null");
			return (Criteria) this;
		}

		public Criteria andUserGenderIsNotNull() {
			addCriterion("user_gender is not null");
			return (Criteria) this;
		}

		public Criteria andUserGenderEqualTo(String value) {
			addCriterion("user_gender =", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderNotEqualTo(String value) {
			addCriterion("user_gender <>", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderGreaterThan(String value) {
			addCriterion("user_gender >", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderGreaterThanOrEqualTo(String value) {
			addCriterion("user_gender >=", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderLessThan(String value) {
			addCriterion("user_gender <", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderLessThanOrEqualTo(String value) {
			addCriterion("user_gender <=", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderLike(String value) {
			addCriterion("user_gender like", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderNotLike(String value) {
			addCriterion("user_gender not like", value, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderIn(List<String> values) {
			addCriterion("user_gender in", values, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderNotIn(List<String> values) {
			addCriterion("user_gender not in", values, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderBetween(String value1, String value2) {
			addCriterion("user_gender between", value1, value2, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserGenderNotBetween(String value1, String value2) {
			addCriterion("user_gender not between", value1, value2, "userGender");
			return (Criteria) this;
		}

		public Criteria andUserPhoneIsNull() {
			addCriterion("user_phone is null");
			return (Criteria) this;
		}

		public Criteria andUserPhoneIsNotNull() {
			addCriterion("user_phone is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhoneEqualTo(String value) {
			addCriterion("user_phone =", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotEqualTo(String value) {
			addCriterion("user_phone <>", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneGreaterThan(String value) {
			addCriterion("user_phone >", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("user_phone >=", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneLessThan(String value) {
			addCriterion("user_phone <", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneLessThanOrEqualTo(String value) {
			addCriterion("user_phone <=", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneLike(String value) {
			addCriterion("user_phone like", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotLike(String value) {
			addCriterion("user_phone not like", value, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneIn(List<String> values) {
			addCriterion("user_phone in", values, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotIn(List<String> values) {
			addCriterion("user_phone not in", values, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneBetween(String value1, String value2) {
			addCriterion("user_phone between", value1, value2, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserPhoneNotBetween(String value1, String value2) {
			addCriterion("user_phone not between", value1, value2, "userPhone");
			return (Criteria) this;
		}

		public Criteria andUserMailboxIsNull() {
			addCriterion("user_mailbox is null");
			return (Criteria) this;
		}

		public Criteria andUserMailboxIsNotNull() {
			addCriterion("user_mailbox is not null");
			return (Criteria) this;
		}

		public Criteria andUserMailboxEqualTo(String value) {
			addCriterion("user_mailbox =", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxNotEqualTo(String value) {
			addCriterion("user_mailbox <>", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxGreaterThan(String value) {
			addCriterion("user_mailbox >", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxGreaterThanOrEqualTo(String value) {
			addCriterion("user_mailbox >=", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxLessThan(String value) {
			addCriterion("user_mailbox <", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxLessThanOrEqualTo(String value) {
			addCriterion("user_mailbox <=", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxLike(String value) {
			addCriterion("user_mailbox like", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxNotLike(String value) {
			addCriterion("user_mailbox not like", value, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxIn(List<String> values) {
			addCriterion("user_mailbox in", values, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxNotIn(List<String> values) {
			addCriterion("user_mailbox not in", values, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxBetween(String value1, String value2) {
			addCriterion("user_mailbox between", value1, value2, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserMailboxNotBetween(String value1, String value2) {
			addCriterion("user_mailbox not between", value1, value2, "userMailbox");
			return (Criteria) this;
		}

		public Criteria andUserAvatarIsNull() {
			addCriterion("user_avatar is null");
			return (Criteria) this;
		}

		public Criteria andUserAvatarIsNotNull() {
			addCriterion("user_avatar is not null");
			return (Criteria) this;
		}

		public Criteria andUserAvatarEqualTo(String value) {
			addCriterion("user_avatar =", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarNotEqualTo(String value) {
			addCriterion("user_avatar <>", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarGreaterThan(String value) {
			addCriterion("user_avatar >", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarGreaterThanOrEqualTo(String value) {
			addCriterion("user_avatar >=", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarLessThan(String value) {
			addCriterion("user_avatar <", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarLessThanOrEqualTo(String value) {
			addCriterion("user_avatar <=", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarLike(String value) {
			addCriterion("user_avatar like", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarNotLike(String value) {
			addCriterion("user_avatar not like", value, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarIn(List<String> values) {
			addCriterion("user_avatar in", values, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarNotIn(List<String> values) {
			addCriterion("user_avatar not in", values, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarBetween(String value1, String value2) {
			addCriterion("user_avatar between", value1, value2, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserAvatarNotBetween(String value1, String value2) {
			addCriterion("user_avatar not between", value1, value2, "userAvatar");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberIsNull() {
			addCriterion("user_question_number is null");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberIsNotNull() {
			addCriterion("user_question_number is not null");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberEqualTo(Integer value) {
			addCriterion("user_question_number =", value, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberNotEqualTo(Integer value) {
			addCriterion("user_question_number <>", value, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberGreaterThan(Integer value) {
			addCriterion("user_question_number >", value, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_question_number >=", value, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberLessThan(Integer value) {
			addCriterion("user_question_number <", value, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberLessThanOrEqualTo(Integer value) {
			addCriterion("user_question_number <=", value, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberIn(List<Integer> values) {
			addCriterion("user_question_number in", values, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberNotIn(List<Integer> values) {
			addCriterion("user_question_number not in", values, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberBetween(Integer value1, Integer value2) {
			addCriterion("user_question_number between", value1, value2, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserQuestionNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("user_question_number not between", value1, value2, "userQuestionNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberIsNull() {
			addCriterion("user_answer_number is null");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberIsNotNull() {
			addCriterion("user_answer_number is not null");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberEqualTo(Integer value) {
			addCriterion("user_answer_number =", value, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberNotEqualTo(Integer value) {
			addCriterion("user_answer_number <>", value, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberGreaterThan(Integer value) {
			addCriterion("user_answer_number >", value, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_answer_number >=", value, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberLessThan(Integer value) {
			addCriterion("user_answer_number <", value, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberLessThanOrEqualTo(Integer value) {
			addCriterion("user_answer_number <=", value, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberIn(List<Integer> values) {
			addCriterion("user_answer_number in", values, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberNotIn(List<Integer> values) {
			addCriterion("user_answer_number not in", values, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberBetween(Integer value1, Integer value2) {
			addCriterion("user_answer_number between", value1, value2, "userAnswerNumber");
			return (Criteria) this;
		}

		public Criteria andUserAnswerNumberNotBetween(Integer value1, Integer value2) {
			addCriterion("user_answer_number not between", value1, value2, "userAnswerNumber");
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