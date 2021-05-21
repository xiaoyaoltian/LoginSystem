package com.hm.dao;

import com.hm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HM
 * @since 2021-05-20
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
