package com.cn.ssm.mapping;

import com.cn.ssm.dao.SysTicket;
import com.cn.ssm.dao.SysTicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTicketMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    long countByExample(SysTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int deleteByExample(SysTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer ticketId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int insert(SysTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int insertSelective(SysTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    List<SysTicket> selectByExample(SysTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    SysTicket selectByPrimaryKey(Integer ticketId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysTicket record, @Param("example") SysTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysTicket record, @Param("example") SysTicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysTicket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_ticket
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysTicket record);
}