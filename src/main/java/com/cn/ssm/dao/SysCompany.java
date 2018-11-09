package com.cn.ssm.dao;

public class SysCompany {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_company.company_id
     *
     * @mbggenerated
     */
    private Integer companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_company.company_name
     *
     * @mbggenerated
     */
    private String companyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_company.company_place
     *
     * @mbggenerated
     */
    private String companyPlace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_company.company_createtime
     *
     * @mbggenerated
     */
    private String companyCreatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_company.company_id
     *
     * @return the value of sys_company.company_id
     *
     * @mbggenerated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_company.company_id
     *
     * @param companyId the value for sys_company.company_id
     *
     * @mbggenerated
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_company.company_name
     *
     * @return the value of sys_company.company_name
     *
     * @mbggenerated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_company.company_name
     *
     * @param companyName the value for sys_company.company_name
     *
     * @mbggenerated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_company.company_place
     *
     * @return the value of sys_company.company_place
     *
     * @mbggenerated
     */
    public String getCompanyPlace() {
        return companyPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_company.company_place
     *
     * @param companyPlace the value for sys_company.company_place
     *
     * @mbggenerated
     */
    public void setCompanyPlace(String companyPlace) {
        this.companyPlace = companyPlace == null ? null : companyPlace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_company.company_createtime
     *
     * @return the value of sys_company.company_createtime
     *
     * @mbggenerated
     */
    public String getCompanyCreatetime() {
        return companyCreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_company.company_createtime
     *
     * @param companyCreatetime the value for sys_company.company_createtime
     *
     * @mbggenerated
     */
    public void setCompanyCreatetime(String companyCreatetime) {
        this.companyCreatetime = companyCreatetime == null ? null : companyCreatetime.trim();
    }
}