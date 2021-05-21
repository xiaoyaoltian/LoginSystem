package com.hm.service;

import com.hm.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HM
 * @since 2021-05-20
 */
public interface UserService extends IService<User> {
    User selectByUsername(String username);
}
