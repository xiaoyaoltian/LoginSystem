package com.hm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.entity.User;
import com.hm.dao.UserDao;
import com.hm.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HM
 * @since 2021-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public User selectByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }
}
