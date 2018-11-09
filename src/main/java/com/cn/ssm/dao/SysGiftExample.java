package com.cn.ssm.dao;

import java.util.ArrayList;
import java.util.List;

public class SysGiftExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public SysGiftExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
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
     * This method corresponds to the database table sys_gift
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
     * This method corresponds to the database table sys_gift
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_gift
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
     * This class corresponds to the database table sys_gift
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

        public Criteria andGiftIdIsNull() {
            addCriterion("gift_id is null");
            return (Criteria) this;
        }

        public Criteria andGiftIdIsNotNull() {
            addCriterion("gift_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiftIdEqualTo(Integer value) {
            addCriterion("gift_id =", value, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdNotEqualTo(Integer value) {
            addCriterion("gift_id <>", value, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdGreaterThan(Integer value) {
            addCriterion("gift_id >", value, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_id >=", value, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdLessThan(Integer value) {
            addCriterion("gift_id <", value, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdLessThanOrEqualTo(Integer value) {
            addCriterion("gift_id <=", value, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdIn(List<Integer> values) {
            addCriterion("gift_id in", values, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdNotIn(List<Integer> values) {
            addCriterion("gift_id not in", values, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdBetween(Integer value1, Integer value2) {
            addCriterion("gift_id between", value1, value2, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_id not between", value1, value2, "giftId");
            return (Criteria) this;
        }

        public Criteria andGiftNameIsNull() {
            addCriterion("gift_name is null");
            return (Criteria) this;
        }

        public Criteria andGiftNameIsNotNull() {
            addCriterion("gift_name is not null");
            return (Criteria) this;
        }

        public Criteria andGiftNameEqualTo(String value) {
            addCriterion("gift_name =", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotEqualTo(String value) {
            addCriterion("gift_name <>", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameGreaterThan(String value) {
            addCriterion("gift_name >", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameGreaterThanOrEqualTo(String value) {
            addCriterion("gift_name >=", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameLessThan(String value) {
            addCriterion("gift_name <", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameLessThanOrEqualTo(String value) {
            addCriterion("gift_name <=", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameLike(String value) {
            addCriterion("gift_name like", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotLike(String value) {
            addCriterion("gift_name not like", value, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameIn(List<String> values) {
            addCriterion("gift_name in", values, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotIn(List<String> values) {
            addCriterion("gift_name not in", values, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameBetween(String value1, String value2) {
            addCriterion("gift_name between", value1, value2, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftNameNotBetween(String value1, String value2) {
            addCriterion("gift_name not between", value1, value2, "giftName");
            return (Criteria) this;
        }

        public Criteria andGiftPriceIsNull() {
            addCriterion("gift_price is null");
            return (Criteria) this;
        }

        public Criteria andGiftPriceIsNotNull() {
            addCriterion("gift_price is not null");
            return (Criteria) this;
        }

        public Criteria andGiftPriceEqualTo(Integer value) {
            addCriterion("gift_price =", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceNotEqualTo(Integer value) {
            addCriterion("gift_price <>", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceGreaterThan(Integer value) {
            addCriterion("gift_price >", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_price >=", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceLessThan(Integer value) {
            addCriterion("gift_price <", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceLessThanOrEqualTo(Integer value) {
            addCriterion("gift_price <=", value, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceIn(List<Integer> values) {
            addCriterion("gift_price in", values, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceNotIn(List<Integer> values) {
            addCriterion("gift_price not in", values, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceBetween(Integer value1, Integer value2) {
            addCriterion("gift_price between", value1, value2, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_price not between", value1, value2, "giftPrice");
            return (Criteria) this;
        }

        public Criteria andGiftTicketIsNull() {
            addCriterion("gift_ticket is null");
            return (Criteria) this;
        }

        public Criteria andGiftTicketIsNotNull() {
            addCriterion("gift_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andGiftTicketEqualTo(Integer value) {
            addCriterion("gift_ticket =", value, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketNotEqualTo(Integer value) {
            addCriterion("gift_ticket <>", value, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketGreaterThan(Integer value) {
            addCriterion("gift_ticket >", value, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("gift_ticket >=", value, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketLessThan(Integer value) {
            addCriterion("gift_ticket <", value, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketLessThanOrEqualTo(Integer value) {
            addCriterion("gift_ticket <=", value, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketIn(List<Integer> values) {
            addCriterion("gift_ticket in", values, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketNotIn(List<Integer> values) {
            addCriterion("gift_ticket not in", values, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketBetween(Integer value1, Integer value2) {
            addCriterion("gift_ticket between", value1, value2, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("gift_ticket not between", value1, value2, "giftTicket");
            return (Criteria) this;
        }

        public Criteria andGiftImgIsNull() {
            addCriterion("gift_img is null");
            return (Criteria) this;
        }

        public Criteria andGiftImgIsNotNull() {
            addCriterion("gift_img is not null");
            return (Criteria) this;
        }

        public Criteria andGiftImgEqualTo(String value) {
            addCriterion("gift_img =", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgNotEqualTo(String value) {
            addCriterion("gift_img <>", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgGreaterThan(String value) {
            addCriterion("gift_img >", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgGreaterThanOrEqualTo(String value) {
            addCriterion("gift_img >=", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgLessThan(String value) {
            addCriterion("gift_img <", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgLessThanOrEqualTo(String value) {
            addCriterion("gift_img <=", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgLike(String value) {
            addCriterion("gift_img like", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgNotLike(String value) {
            addCriterion("gift_img not like", value, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgIn(List<String> values) {
            addCriterion("gift_img in", values, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgNotIn(List<String> values) {
            addCriterion("gift_img not in", values, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgBetween(String value1, String value2) {
            addCriterion("gift_img between", value1, value2, "giftImg");
            return (Criteria) this;
        }

        public Criteria andGiftImgNotBetween(String value1, String value2) {
            addCriterion("gift_img not between", value1, value2, "giftImg");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_gift
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
     * This class corresponds to the database table sys_gift
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