package com.cn.ssm.dao;

public class SysPrize {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_prize.prize_id
     *
     * @mbg.generated
     */
    private Integer prizeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_prize.prize_name
     *
     * @mbg.generated
     */
    private String prizeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_prize.prize_context
     *
     * @mbg.generated
     */
    private String prizeContext;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_prize.prize_img
     *
     * @mbg.generated
     */
    private String prizeImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_prize.prize_parentId
     *
     * @mbg.generated
     */
    private Integer prizeParentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_prize.prize_id
     *
     * @return the value of sys_prize.prize_id
     *
     * @mbg.generated
     */
    public Integer getPrizeId() {
        return prizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_prize.prize_id
     *
     * @param prizeId the value for sys_prize.prize_id
     *
     * @mbg.generated
     */
    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_prize.prize_name
     *
     * @return the value of sys_prize.prize_name
     *
     * @mbg.generated
     */
    public String getPrizeName() {
        return prizeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_prize.prize_name
     *
     * @param prizeName the value for sys_prize.prize_name
     *
     * @mbg.generated
     */
    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_prize.prize_context
     *
     * @return the value of sys_prize.prize_context
     *
     * @mbg.generated
     */
    public String getPrizeContext() {
        return prizeContext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_prize.prize_context
     *
     * @param prizeContext the value for sys_prize.prize_context
     *
     * @mbg.generated
     */
    public void setPrizeContext(String prizeContext) {
        this.prizeContext = prizeContext == null ? null : prizeContext.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_prize.prize_img
     *
     * @return the value of sys_prize.prize_img
     *
     * @mbg.generated
     */
    public String getPrizeImg() {
        return prizeImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_prize.prize_img
     *
     * @param prizeImg the value for sys_prize.prize_img
     *
     * @mbg.generated
     */
    public void setPrizeImg(String prizeImg) {
        this.prizeImg = prizeImg == null ? null : prizeImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_prize.prize_parentId
     *
     * @return the value of sys_prize.prize_parentId
     *
     * @mbg.generated
     */
    public Integer getPrizeParentid() {
        return prizeParentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_prize.prize_parentId
     *
     * @param prizeParentid the value for sys_prize.prize_parentId
     *
     * @mbg.generated
     */
    public void setPrizeParentid(Integer prizeParentid) {
        this.prizeParentid = prizeParentid;
    }
}