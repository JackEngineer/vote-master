package com.cn.ssm.dao;

import java.util.Date;

public class SysAccount {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_id
     *
     * @mbggenerated
     */
    private Integer accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_usercode
     *
     * @mbggenerated
     */
    private String accountUsercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_type
     *
     * @mbggenerated
     */
    private Integer accountType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_amt
     *
     * @mbggenerated
     */
    private Integer accountAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_numb
     *
     * @mbggenerated
     */
    private Integer accountNumb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_time
     *
     * @mbggenerated
     */
    private Date accountTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_giftId
     *
     * @mbggenerated
     */
    private Integer accountGiftid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_account.account_studentId
     *
     * @mbggenerated
     */
    private Integer accountStudentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_id
     *
     * @return the value of sys_account.account_id
     *
     * @mbggenerated
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_id
     *
     * @param accountId the value for sys_account.account_id
     *
     * @mbggenerated
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_usercode
     *
     * @return the value of sys_account.account_usercode
     *
     * @mbggenerated
     */
    public String getAccountUsercode() {
        return accountUsercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_usercode
     *
     * @param accountUsercode the value for sys_account.account_usercode
     *
     * @mbggenerated
     */
    public void setAccountUsercode(String accountUsercode) {
        this.accountUsercode = accountUsercode == null ? null : accountUsercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_type
     *
     * @return the value of sys_account.account_type
     *
     * @mbggenerated
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_type
     *
     * @param accountType the value for sys_account.account_type
     *
     * @mbggenerated
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_amt
     *
     * @return the value of sys_account.account_amt
     *
     * @mbggenerated
     */
    public Integer getAccountAmt() {
        return accountAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_amt
     *
     * @param accountAmt the value for sys_account.account_amt
     *
     * @mbggenerated
     */
    public void setAccountAmt(Integer accountAmt) {
        this.accountAmt = accountAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_numb
     *
     * @return the value of sys_account.account_numb
     *
     * @mbggenerated
     */
    public Integer getAccountNumb() {
        return accountNumb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_numb
     *
     * @param accountNumb the value for sys_account.account_numb
     *
     * @mbggenerated
     */
    public void setAccountNumb(Integer accountNumb) {
        this.accountNumb = accountNumb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_time
     *
     * @return the value of sys_account.account_time
     *
     * @mbggenerated
     */
    public Date getAccountTime() {
        return accountTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_time
     *
     * @param accountTime the value for sys_account.account_time
     *
     * @mbggenerated
     */
    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_giftId
     *
     * @return the value of sys_account.account_giftId
     *
     * @mbggenerated
     */
    public Integer getAccountGiftid() {
        return accountGiftid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_giftId
     *
     * @param accountGiftid the value for sys_account.account_giftId
     *
     * @mbggenerated
     */
    public void setAccountGiftid(Integer accountGiftid) {
        this.accountGiftid = accountGiftid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_account.account_studentId
     *
     * @return the value of sys_account.account_studentId
     *
     * @mbggenerated
     */
    public Integer getAccountStudentid() {
        return accountStudentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_account.account_studentId
     *
     * @param accountStudentid the value for sys_account.account_studentId
     *
     * @mbggenerated
     */
    public void setAccountStudentid(Integer accountStudentid) {
        this.accountStudentid = accountStudentid;
    }
}