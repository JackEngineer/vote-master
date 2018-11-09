package com.cn.ssm.mapping;

import com.cn.ssm.dao.SysPrize;
import com.cn.ssm.dao.SysPrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPrizeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    long countByExample(SysPrizeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int deleteByExample(SysPrizeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer prizeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int insert(SysPrize record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int insertSelective(SysPrize record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    List<SysPrize> selectByExample(SysPrizeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    SysPrize selectByPrimaryKey(Integer prizeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysPrize record, @Param("example") SysPrizeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysPrize record, @Param("example") SysPrizeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysPrize record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_prize
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysPrize record);
}