package com.cn.ssm.mapping;

import com.cn.ssm.dao.SysAccount;
import com.cn.ssm.dao.SysAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int countByExample(SysAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int deleteByExample(SysAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer accountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int insert(SysAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int insertSelective(SysAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    List<SysAccount> selectByExample(SysAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    SysAccount selectByPrimaryKey(Integer accountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysAccount record, @Param("example") SysAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysAccount record);
}