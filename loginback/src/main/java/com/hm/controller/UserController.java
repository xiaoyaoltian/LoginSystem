package com.hm.controller;


import com.hm.config.Result;
import com.hm.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HM
 * @since 2021-05-20
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    @CrossOrigin(origins = "http://127.0.0.1:8080", maxAge = 3600)
    public Result login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        if (username.equals("admin") || password.equals("123")){
            log.info("打印。。。");
            return new Result(200);
        }else {
            return new Result(400);
        }
    }

}

