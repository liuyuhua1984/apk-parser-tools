package com.lyh.apk.service;

import com.lyh.apk.model.AgentUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代理数据处理接口
 *
 * @author: root
 * @create: 2018-12-15 10:37
 **/

public interface AgentUserService {
    /**
     *
     *
     * 根据等级与是否创建渠道包对象查询
     *
     * @return  List<AgentUser>
     * **/
    List<AgentUser> findByLevelAndCreatePackage( Integer level,  Integer createPackageFlag);


    /***
     * 找到全部的代理
     * @param level
     * @return
     */
    List<AgentUser> findAllAgentByLevel(Integer level);

    /***
     * 更新全部的已打的渠道包
     * @param agentUser
     */
    void updateByCreatePackageFlag(AgentUser agentUser);
}
