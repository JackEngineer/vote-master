package com.cn.ssm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAccountExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public SysAccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_account
     *
     * @mbggenerated
     */
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeIsNull() {
            addCriterion("account_usercode is null");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeIsNotNull() {
            addCriterion("account_usercode is not null");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeEqualTo(String value) {
            addCriterion("account_usercode =", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeNotEqualTo(String value) {
            addCriterion("account_usercode <>", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeGreaterThan(String value) {
            addCriterion("account_usercode >", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("account_usercode >=", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeLessThan(String value) {
            addCriterion("account_usercode <", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeLessThanOrEqualTo(String value) {
            addCriterion("account_usercode <=", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeLike(String value) {
            addCriterion("account_usercode like", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeNotLike(String value) {
            addCriterion("account_usercode not like", value, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeIn(List<String> values) {
            addCriterion("account_usercode in", values, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeNotIn(List<String> values) {
            addCriterion("account_usercode not in", values, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeBetween(String value1, String value2) {
            addCriterion("account_usercode between", value1, value2, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountUsercodeNotBetween(String value1, String value2) {
            addCriterion("account_usercode not between", value1, value2, "accountUsercode");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountAmtIsNull() {
            addCriterion("account_amt is null");
            return (Criteria) this;
        }

        public Criteria andAccountAmtIsNotNull() {
            addCriterion("account_amt is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAmtEqualTo(Integer value) {
            addCriterion("account_amt =", value, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtNotEqualTo(Integer value) {
            addCriterion("account_amt <>", value, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtGreaterThan(Integer value) {
            addCriterion("account_amt >", value, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_amt >=", value, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtLessThan(Integer value) {
            addCriterion("account_amt <", value, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtLessThanOrEqualTo(Integer value) {
            addCriterion("account_amt <=", value, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtIn(List<Integer> values) {
            addCriterion("account_amt in", values, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtNotIn(List<Integer> values) {
            addCriterion("account_amt not in", values, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtBetween(Integer value1, Integer value2) {
            addCriterion("account_amt between", value1, value2, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("account_amt not between", value1, value2, "accountAmt");
            return (Criteria) this;
        }

        public Criteria andAccountNumbIsNull() {
            addCriterion("account_numb is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumbIsNotNull() {
            addCriterion("account_numb is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumbEqualTo(Integer value) {
            addCriterion("account_numb =", value, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbNotEqualTo(Integer value) {
            addCriterion("account_numb <>", value, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbGreaterThan(Integer value) {
            addCriterion("account_numb >", value, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_numb >=", value, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbLessThan(Integer value) {
            addCriterion("account_numb <", value, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbLessThanOrEqualTo(Integer value) {
            addCriterion("account_numb <=", value, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbIn(List<Integer> values) {
            addCriterion("account_numb in", values, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbNotIn(List<Integer> values) {
            addCriterion("account_numb not in", values, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbBetween(Integer value1, Integer value2) {
            addCriterion("account_numb between", value1, value2, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountNumbNotBetween(Integer value1, Integer value2) {
            addCriterion("account_numb not between", value1, value2, "accountNumb");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNull() {
            addCriterion("account_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNotNull() {
            addCriterion("account_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeEqualTo(Date value) {
            addCriterion("account_time =", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotEqualTo(Date value) {
            addCriterion("account_time <>", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThan(Date value) {
            addCriterion("account_time >", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("account_time >=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThan(Date value) {
            addCriterion("account_time <", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThanOrEqualTo(Date value) {
            addCriterion("account_time <=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIn(List<Date> values) {
            addCriterion("account_time in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotIn(List<Date> values) {
            addCriterion("account_time not in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeBetween(Date value1, Date value2) {
            addCriterion("account_time between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotBetween(Date value1, Date value2) {
            addCriterion("account_time not between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidIsNull() {
            addCriterion("account_giftId is null");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidIsNotNull() {
            addCriterion("account_giftId is not null");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidEqualTo(Integer value) {
            addCriterion("account_giftId =", value, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidNotEqualTo(Integer value) {
            addCriterion("account_giftId <>", value, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidGreaterThan(Integer value) {
            addCriterion("account_giftId >", value, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_giftId >=", value, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidLessThan(Integer value) {
            addCriterion("account_giftId <", value, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidLessThanOrEqualTo(Integer value) {
            addCriterion("account_giftId <=", value, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidIn(List<Integer> values) {
            addCriterion("account_giftId in", values, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidNotIn(List<Integer> values) {
            addCriterion("account_giftId not in", values, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidBetween(Integer value1, Integer value2) {
            addCriterion("account_giftId between", value1, value2, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountGiftidNotBetween(Integer value1, Integer value2) {
            addCriterion("account_giftId not between", value1, value2, "accountGiftid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidIsNull() {
            addCriterion("account_studentId is null");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidIsNotNull() {
            addCriterion("account_studentId is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidEqualTo(Integer value) {
            addCriterion("account_studentId =", value, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidNotEqualTo(Integer value) {
            addCriterion("account_studentId <>", value, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidGreaterThan(Integer value) {
            addCriterion("account_studentId >", value, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_studentId >=", value, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidLessThan(Integer value) {
            addCriterion("account_studentId <", value, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("account_studentId <=", value, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidIn(List<Integer> values) {
            addCriterion("account_studentId in", values, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidNotIn(List<Integer> values) {
            addCriterion("account_studentId not in", values, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidBetween(Integer value1, Integer value2) {
            addCriterion("account_studentId between", value1, value2, "accountStudentid");
            return (Criteria) this;
        }

        public Criteria andAccountStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("account_studentId not between", value1, value2, "accountStudentid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_account
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_account
     *
     * @mbggenerated
     */
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