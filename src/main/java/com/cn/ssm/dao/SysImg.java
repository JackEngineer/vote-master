package com.cn.ssm.dao;

public class SysImg {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_img.img_id
     *
     * @mbg.generated
     */
    private Integer imgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_img.img_source
     *
     * @mbg.generated
     */
    private String imgSource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_img.img_type
     *
     * @mbg.generated
     */
    private Integer imgType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_img.img_parentid
     *
     * @mbg.generated
     */
    private Integer imgParentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_img.img_id
     *
     * @return the value of sys_img.img_id
     *
     * @mbg.generated
     */
    public Integer getImgId() {
        return imgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_img.img_id
     *
     * @param imgId the value for sys_img.img_id
     *
     * @mbg.generated
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_img.img_source
     *
     * @return the value of sys_img.img_source
     *
     * @mbg.generated
     */
    public String getImgSource() {
        return imgSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_img.img_source
     *
     * @param imgSource the value for sys_img.img_source
     *
     * @mbg.generated
     */
    public void setImgSource(String imgSource) {
        this.imgSource = imgSource == null ? null : imgSource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_img.img_type
     *
     * @return the value of sys_img.img_type
     *
     * @mbg.generated
     */
    public Integer getImgType() {
        return imgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_img.img_type
     *
     * @param imgType the value for sys_img.img_type
     *
     * @mbg.generated
     */
    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_img.img_parentid
     *
     * @return the value of sys_img.img_parentid
     *
     * @mbg.generated
     */
    public Integer getImgParentid() {
        return imgParentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_img.img_parentid
     *
     * @param imgParentid the value for sys_img.img_parentid
     *
     * @mbg.generated
     */
    public void setImgParentid(Integer imgParentid) {
        this.imgParentid = imgParentid;
    }
}