package com.oss.springbootoss;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: qsy
 * @Description: TODO
 * @Date: Created in 下午 4:40 2018/10/23/023
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootossApplication.class);
    }
}
