package com.zx.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Title: Swagger2
 * Description: TODO
 * Copyright: Copyright (c) 2007
 * Company 北京华宇信息技术有限公司
 *
 * @author zhengxin@thunisoft.com
 * @version 1.0
 * date 2019/11/29 18:23
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * @param
     * @return
     * @author: zhengxin@thunisoft.com
     * date: 19-11-29 18:24
     * @version 1.0
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zx.demo.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    /**
     * @param
     * @return
     * @author: zhengxin@thunisoft.com
     * date: 19-11-29 18:25
     * @version 1.0
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("stunier demo Api 概览")
                .version("1.0")
                .contact(new Contact("stunier", null, "zhengxin-3@thunisoft.com"))
                .description("stunier Api")
                .build();
    }
}
