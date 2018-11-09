package com.cn.ssm.dao;

import java.util.ArrayList;
import java.util.List;

public class SysActiveExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public SysActiveExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
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
     * This method corresponds to the database table sys_active
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
     * This method corresponds to the database table sys_active
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_active
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
     * This class corresponds to the database table sys_active
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

        public Criteria andActiveIdIsNull() {
            addCriterion("active_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNotNull() {
            addCriterion("active_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIdEqualTo(Integer value) {
            addCriterion("active_id =", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotEqualTo(Integer value) {
            addCriterion("active_id <>", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThan(Integer value) {
            addCriterion("active_id >", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_id >=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThan(Integer value) {
            addCriterion("active_id <", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("active_id <=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIn(List<Integer> values) {
            addCriterion("active_id in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotIn(List<Integer> values) {
            addCriterion("active_id not in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("active_id between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("active_id not between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveNameIsNull() {
            addCriterion("active_name is null");
            return (Criteria) this;
        }

        public Criteria andActiveNameIsNotNull() {
            addCriterion("active_name is not null");
            return (Criteria) this;
        }

        public Criteria andActiveNameEqualTo(String value) {
            addCriterion("active_name =", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotEqualTo(String value) {
            addCriterion("active_name <>", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameGreaterThan(String value) {
            addCriterion("active_name >", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("active_name >=", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLessThan(String value) {
            addCriterion("active_name <", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLessThanOrEqualTo(String value) {
            addCriterion("active_name <=", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLike(String value) {
            addCriterion("active_name like", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotLike(String value) {
            addCriterion("active_name not like", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameIn(List<String> values) {
            addCriterion("active_name in", values, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotIn(List<String> values) {
            addCriterion("active_name not in", values, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameBetween(String value1, String value2) {
            addCriterion("active_name between", value1, value2, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotBetween(String value1, String value2) {
            addCriterion("active_name not between", value1, value2, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveContextIsNull() {
            addCriterion("active_context is null");
            return (Criteria) this;
        }

        public Criteria andActiveContextIsNotNull() {
            addCriterion("active_context is not null");
            return (Criteria) this;
        }

        public Criteria andActiveContextEqualTo(String value) {
            addCriterion("active_context =", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotEqualTo(String value) {
            addCriterion("active_context <>", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextGreaterThan(String value) {
            addCriterion("active_context >", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextGreaterThanOrEqualTo(String value) {
            addCriterion("active_context >=", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextLessThan(String value) {
            addCriterion("active_context <", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextLessThanOrEqualTo(String value) {
            addCriterion("active_context <=", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextLike(String value) {
            addCriterion("active_context like", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotLike(String value) {
            addCriterion("active_context not like", value, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextIn(List<String> values) {
            addCriterion("active_context in", values, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotIn(List<String> values) {
            addCriterion("active_context not in", values, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextBetween(String value1, String value2) {
            addCriterion("active_context between", value1, value2, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveContextNotBetween(String value1, String value2) {
            addCriterion("active_context not between", value1, value2, "activeContext");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidIsNull() {
            addCriterion("active_companyId is null");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidIsNotNull() {
            addCriterion("active_companyId is not null");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidEqualTo(String value) {
            addCriterion("active_companyId =", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidNotEqualTo(String value) {
            addCriterion("active_companyId <>", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidGreaterThan(String value) {
            addCriterion("active_companyId >", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidGreaterThanOrEqualTo(String value) {
            addCriterion("active_companyId >=", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidLessThan(String value) {
            addCriterion("active_companyId <", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidLessThanOrEqualTo(String value) {
            addCriterion("active_companyId <=", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidLike(String value) {
            addCriterion("active_companyId like", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidNotLike(String value) {
            addCriterion("active_companyId not like", value, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidIn(List<String> values) {
            addCriterion("active_companyId in", values, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidNotIn(List<String> values) {
            addCriterion("active_companyId not in", values, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidBetween(String value1, String value2) {
            addCriterion("active_companyId between", value1, value2, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveCompanyidNotBetween(String value1, String value2) {
            addCriterion("active_companyId not between", value1, value2, "activeCompanyid");
            return (Criteria) this;
        }

        public Criteria andActiveUrlIsNull() {
            addCriterion("active_url is null");
            return (Criteria) this;
        }

        public Criteria andActiveUrlIsNotNull() {
            addCriterion("active_url is not null");
            return (Criteria) this;
        }

        public Criteria andActiveUrlEqualTo(String value) {
            addCriterion("active_url =", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlNotEqualTo(String value) {
            addCriterion("active_url <>", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlGreaterThan(String value) {
            addCriterion("active_url >", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlGreaterThanOrEqualTo(String value) {
            addCriterion("active_url >=", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlLessThan(String value) {
            addCriterion("active_url <", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlLessThanOrEqualTo(String value) {
            addCriterion("active_url <=", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlLike(String value) {
            addCriterion("active_url like", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlNotLike(String value) {
            addCriterion("active_url not like", value, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlIn(List<String> values) {
            addCriterion("active_url in", values, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlNotIn(List<String> values) {
            addCriterion("active_url not in", values, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlBetween(String value1, String value2) {
            addCriterion("active_url between", value1, value2, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUrlNotBetween(String value1, String value2) {
            addCriterion("active_url not between", value1, value2, "activeUrl");
            return (Criteria) this;
        }

        public Criteria andActiveUuidIsNull() {
            addCriterion("active_uuid is null");
            return (Criteria) this;
        }

        public Criteria andActiveUuidIsNotNull() {
            addCriterion("active_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andActiveUuidEqualTo(String value) {
            addCriterion("active_uuid =", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidNotEqualTo(String value) {
            addCriterion("active_uuid <>", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidGreaterThan(String value) {
            addCriterion("active_uuid >", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidGreaterThanOrEqualTo(String value) {
            addCriterion("active_uuid >=", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidLessThan(String value) {
            addCriterion("active_uuid <", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidLessThanOrEqualTo(String value) {
            addCriterion("active_uuid <=", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidLike(String value) {
            addCriterion("active_uuid like", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidNotLike(String value) {
            addCriterion("active_uuid not like", value, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidIn(List<String> values) {
            addCriterion("active_uuid in", values, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidNotIn(List<String> values) {
            addCriterion("active_uuid not in", values, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidBetween(String value1, String value2) {
            addCriterion("active_uuid between", value1, value2, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActiveUuidNotBetween(String value1, String value2) {
            addCriterion("active_uuid not between", value1, value2, "activeUuid");
            return (Criteria) this;
        }

        public Criteria andActivePlaceIsNull() {
            addCriterion("active_place is null");
            return (Criteria) this;
        }

        public Criteria andActivePlaceIsNotNull() {
            addCriterion("active_place is not null");
            return (Criteria) this;
        }

        public Criteria andActivePlaceEqualTo(String value) {
            addCriterion("active_place =", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceNotEqualTo(String value) {
            addCriterion("active_place <>", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceGreaterThan(String value) {
            addCriterion("active_place >", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("active_place >=", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceLessThan(String value) {
            addCriterion("active_place <", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceLessThanOrEqualTo(String value) {
            addCriterion("active_place <=", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceLike(String value) {
            addCriterion("active_place like", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceNotLike(String value) {
            addCriterion("active_place not like", value, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceIn(List<String> values) {
            addCriterion("active_place in", values, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceNotIn(List<String> values) {
            addCriterion("active_place not in", values, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceBetween(String value1, String value2) {
            addCriterion("active_place between", value1, value2, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActivePlaceNotBetween(String value1, String value2) {
            addCriterion("active_place not between", value1, value2, "activePlace");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeIsNull() {
            addCriterion("active_begintime is null");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeIsNotNull() {
            addCriterion("active_begintime is not null");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeEqualTo(String value) {
            addCriterion("active_begintime =", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeNotEqualTo(String value) {
            addCriterion("active_begintime <>", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeGreaterThan(String value) {
            addCriterion("active_begintime >", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeGreaterThanOrEqualTo(String value) {
            addCriterion("active_begintime >=", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeLessThan(String value) {
            addCriterion("active_begintime <", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeLessThanOrEqualTo(String value) {
            addCriterion("active_begintime <=", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeLike(String value) {
            addCriterion("active_begintime like", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeNotLike(String value) {
            addCriterion("active_begintime not like", value, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeIn(List<String> values) {
            addCriterion("active_begintime in", values, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeNotIn(List<String> values) {
            addCriterion("active_begintime not in", values, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeBetween(String value1, String value2) {
            addCriterion("active_begintime between", value1, value2, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveBegintimeNotBetween(String value1, String value2) {
            addCriterion("active_begintime not between", value1, value2, "activeBegintime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeIsNull() {
            addCriterion("active_endtime is null");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeIsNotNull() {
            addCriterion("active_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeEqualTo(String value) {
            addCriterion("active_endtime =", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeNotEqualTo(String value) {
            addCriterion("active_endtime <>", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeGreaterThan(String value) {
            addCriterion("active_endtime >", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("active_endtime >=", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeLessThan(String value) {
            addCriterion("active_endtime <", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeLessThanOrEqualTo(String value) {
            addCriterion("active_endtime <=", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeLike(String value) {
            addCriterion("active_endtime like", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeNotLike(String value) {
            addCriterion("active_endtime not like", value, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeIn(List<String> values) {
            addCriterion("active_endtime in", values, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeNotIn(List<String> values) {
            addCriterion("active_endtime not in", values, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeBetween(String value1, String value2) {
            addCriterion("active_endtime between", value1, value2, "activeEndtime");
            return (Criteria) this;
        }

        public Criteria andActiveEndtimeNotBetween(String value1, String value2) {
            addCriterion("active_endtime not between", value1, value2, "activeEndtime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_active
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
     * This class corresponds to the database table sys_active
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