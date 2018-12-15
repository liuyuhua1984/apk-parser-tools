package com.lyh.apk.mapper;


import com.lyh.apk.model.AgentUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentUserMapper {
    //int deleteByPrimaryKey(Integer id);
    //
    //int insert(AgentUser record);
    //
    //int insertSelective(AgentUser record);
    //
    //AgentUser selectByPrimaryKey(Integer id);
    //AgentUser selectAgentEntry(Integer id);
    //
    //int updateByPrimaryKeySelective(AgentUser record);
    //
    //int updateByPrimaryKeyWithBLOBs(AgentUser record);
    //
    //int updateByPrimaryKey(AgentUser record);
    //
    //int updateAgentApplyFor(AgentUser record);
    //
    //int modifyMyMobileQqName(AgentUser record);
    //
    //
    //int generalizeNum(Query query);
    ///**
    // * 代理-列表查询
    // * @param query
    // * @param bounds
    // * @return
    // */
    //List<Map<String,Object>> getAgentList(Query query, RowBounds bounds);
    //
    ///**
    // * 下级列表
    // * @param query
    // * @param
    // * @return
    // */
    //List<Map<String,Object>> getallNextAgentList(Query query, RowBounds bounds);
    ///**
    // * 一级代理-列表查询
    // * @param query
    // * @param bounds
    // * @return
    // */
    //List<AgentUser> getOneAgentList(Query query, RowBounds bounds);
    ///**
    // * 二级级代理-列表查询
    // * @param
    // * @param
    // * @return
    // */
    //List<AgentUser> getTwoAgentList(Integer agentId);
    ///**
    // * 下级-代理列表查询
    // * @param query
    // * @param bounds
    // * @return
    // */
    //List<Map<String,Object>> getNextAgentList(Query query, RowBounds bounds);
    ///**
    // * 下级-代理列表查询
    // * @param query
    // * @param bounds
    // * @return
    // */
    //List<Map<String,Object>> getNextAgentAllList(Query query, RowBounds bounds);
    ///**
    // * 下级-代理列表查询 带审核查询
    // * @param query
    // * @param bounds
    // * @return
    // */
    //List<Map<String,Object>> getNextAuditAgentAllList(Query query, RowBounds bounds);
    ///**
    // * 推广列表
    // * @param query
    // * @param bounds
    // * @return
    // */
    //List<Map<String,Object>> getGeneralizeList(Query query, RowBounds bounds);
    ///**
    // * 判断是否唯一
    // * @param sysUserId
    // * @param gameUserId
    // * @return
    // */
    //int checkAgent(@Param("sysUserId") Integer sysUserId, @Param("gameUserId") Integer gameUserId);
    //
    ///**
    // * 根据系统用户id-查游戏用户id
    // * @param sysUserId
    // * @return
    // */
    //AgentUser getAgentUser(@Param("sysUserId") Integer sysUserId);
    ///**
    // * 根据游戏用户id 查询代理
    // * @param gameUserId
    // * @return
    // */
    //AgentUser getAgentGameUser(@Param("gameUserId") Integer gameUserId);
    //
    ///**
    // * 查询所有
    // * @return
    // */
    //List<AgentUser> getByListAll();
    //
    ///**
    // * 查询代理用户信息
    // * @param accountName 系统账号
    // * @return
    // */
    //AgentUser getAgentUserAccount(@Param("accountName") String accountName);


    /**
     *
     *
     * 根据等级与是否创建渠道包对象查询
     *
     * @return  List<AgentUser>
     * **/
    List<AgentUser>  findByLevelAndCreatePackage(@Param("level") Integer level,@Param("createPackageFlag") Integer createPackageFlag);

    /***
     * 找到全部的代理
     * @param level
     * @return
     */
    List<AgentUser> findAllAgentByLevel(@Param("level") Integer level);
    /***
     * 更新全部的已打的渠道包
     * @param agentUser
     */
    void updateByCreatePackageFlag(AgentUser agentUser);



}