package com.lyh.apk.service.impl;

import com.lyh.apk.mapper.AgentUserMapper;
import com.lyh.apk.model.AgentUser;
import com.lyh.apk.service.AgentUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: root
 * @create: 2018-12-15 10:40
 **/
@Service
public class AgentUserServiceImpl implements AgentUserService {

    @Resource
    private AgentUserMapper mapper;

    @Override
    public List<AgentUser> findByLevelAndCreatePackage(Integer level, Integer createPackageFlag) {
        return mapper.findByLevelAndCreatePackage(level,createPackageFlag);
    }

    @Override
    public List<AgentUser> findAllAgentByLevel(Integer level) {
        return mapper.findAllAgentByLevel(level);
    }

    @Override
    public void updateByCreatePackageFlag(AgentUser agentUser) {
        mapper.updateByCreatePackageFlag(agentUser);
    }
}
