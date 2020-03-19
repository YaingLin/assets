package com.ossjk.asset.system.service.impl;

import com.ossjk.asset.system.entity.Role;
import com.ossjk.asset.system.entity.Role_permission;
import com.ossjk.asset.system.mapper.RoleMapper;
import com.ossjk.asset.system.service.IRoleService;
import com.ossjk.asset.system.service.IRole_permissionService;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author lym
 * @since 2020-01-09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


}
