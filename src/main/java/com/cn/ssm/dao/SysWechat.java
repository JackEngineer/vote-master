package com.cn.ssm.dao;

public class SysWechat {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_wechat.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_wechat.user_code
     *
     * @mbg.generated
     */
    private String userCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_wechat.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_wechat.user_curramt
     *
     * @mbg.generated
     */
    private Integer userCurramt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_wechat.user_id
     *
     * @return the value of sys_wechat.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_wechat.user_id
     *
     * @param userId the value for sys_wechat.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_wechat.user_code
     *
     * @return the value of sys_wechat.user_code
     *
     * @mbg.generated
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_wechat.user_code
     *
     * @param userCode the value for sys_wechat.user_code
     *
     * @mbg.generated
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_wechat.user_name
     *
     * @return the value of sys_wechat.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_wechat.user_name
     *
     * @param userName the value for sys_wechat.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_wechat.user_curramt
     *
     * @return the value of sys_wechat.user_curramt
     *
     * @mbg.generated
     */
    public Integer getUserCurramt() {
        return userCurramt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_wechat.user_curramt
     *
     * @param userCurramt the value for sys_wechat.user_curramt
     *
     * @mbg.generated
     */
    public void setUserCurramt(Integer userCurramt) {
        this.userCurramt = userCurramt;
    }
}