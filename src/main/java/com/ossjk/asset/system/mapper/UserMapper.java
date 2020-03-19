package com.ossjk.asset.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.vo.UserVo;

/**
 * <p>
  * 用户 Mapper 接口
 * </p>
 *
 * @author chair
 * @since 2018-07-09
 */
public interface UserMapper extends BaseMapper<User> {

	List<UserVo> selectUserVo(Page page, @Param("ew") Wrapper wrapper);
}