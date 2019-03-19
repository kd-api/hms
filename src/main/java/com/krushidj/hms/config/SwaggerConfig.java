package com.krushidj.hms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
Created by Anil D. Ingle
@Date 15-03-2019
 Swagger configuration for the application,
  which enables the API end points
  in all instances except production.
 */
@Configuration
@EnableSwagger2
// @Profile("!production")
public class SwaggerConfig {
    private static final String CONTROLLERS_BASE_PACKAGE = "com.krushidj.hms.modules.owner";

    @Value("${api.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLERS_BASE_PACKAGE))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Krushidj HMS API")
                .description("Krushidj HMS API APP API in spring boot..!")
                .version(version)
                .build();
    }
}
