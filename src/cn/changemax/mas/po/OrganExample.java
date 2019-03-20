package cn.changemax.mas.po;

import java.util.ArrayList;
import java.util.List;

public class OrganExample {
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

	public OrganExample() {
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

		public Criteria andOrganIdIsNull() {
			addCriterion("organ_id is null");
			return (Criteria) this;
		}

		public Criteria andOrganIdIsNotNull() {
			addCriterion("organ_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrganIdEqualTo(Integer value) {
			addCriterion("organ_id =", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdNotEqualTo(Integer value) {
			addCriterion("organ_id <>", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdGreaterThan(Integer value) {
			addCriterion("organ_id >", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("organ_id >=", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdLessThan(Integer value) {
			addCriterion("organ_id <", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdLessThanOrEqualTo(Integer value) {
			addCriterion("organ_id <=", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdIn(List<Integer> values) {
			addCriterion("organ_id in", values, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdNotIn(List<Integer> values) {
			addCriterion("organ_id not in", values, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdBetween(Integer value1, Integer value2) {
			addCriterion("organ_id between", value1, value2, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdNotBetween(Integer value1, Integer value2) {
			addCriterion("organ_id not between", value1, value2, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganNameIsNull() {
			addCriterion("organ_name is null");
			return (Criteria) this;
		}

		public Criteria andOrganNameIsNotNull() {
			addCriterion("organ_name is not null");
			return (Criteria) this;
		}

		public Criteria andOrganNameEqualTo(String value) {
			addCriterion("organ_name =", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotEqualTo(String value) {
			addCriterion("organ_name <>", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameGreaterThan(String value) {
			addCriterion("organ_name >", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameGreaterThanOrEqualTo(String value) {
			addCriterion("organ_name >=", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameLessThan(String value) {
			addCriterion("organ_name <", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameLessThanOrEqualTo(String value) {
			addCriterion("organ_name <=", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameLike(String value) {
			addCriterion("organ_name like", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotLike(String value) {
			addCriterion("organ_name not like", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameIn(List<String> values) {
			addCriterion("organ_name in", values, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotIn(List<String> values) {
			addCriterion("organ_name not in", values, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameBetween(String value1, String value2) {
			addCriterion("organ_name between", value1, value2, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotBetween(String value1, String value2) {
			addCriterion("organ_name not between", value1, value2, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdIsNull() {
			addCriterion("organ_part_id is null");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdIsNotNull() {
			addCriterion("organ_part_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdEqualTo(Integer value) {
			addCriterion("organ_part_id =", value, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdNotEqualTo(Integer value) {
			addCriterion("organ_part_id <>", value, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdGreaterThan(Integer value) {
			addCriterion("organ_part_id >", value, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("organ_part_id >=", value, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdLessThan(Integer value) {
			addCriterion("organ_part_id <", value, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdLessThanOrEqualTo(Integer value) {
			addCriterion("organ_part_id <=", value, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdIn(List<Integer> values) {
			addCriterion("organ_part_id in", values, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdNotIn(List<Integer> values) {
			addCriterion("organ_part_id not in", values, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdBetween(Integer value1, Integer value2) {
			addCriterion("organ_part_id between", value1, value2, "organPartId");
			return (Criteria) this;
		}

		public Criteria andOrganPartIdNotBetween(Integer value1, Integer value2) {
			addCriterion("organ_part_id not between", value1, value2, "organPartId");
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