package com.fileStudy.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Slf4j
//@Configuration
public class  WebMvcConfig implements WebMvcConfigurer {

    //@Bean(name = "multipartResolver")
    //public MultipartResolver multipartResolver() {
    //    //log.info("Loading the multipart resolver");
    //    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    //    return multipartResolver;
    //}
}