package com.hm.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * @author : HM
 * @date : 2021-05-20 15:27
 * @description
 **/
public interface WebMvcConfigurer {
    void addCorsMappings(CorsRegistry registry);
}
