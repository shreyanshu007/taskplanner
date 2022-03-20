package com.example.taskplanner.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PKG = "com.example.taskplanner";

    @Value("${project.service.host}")
    private String serviceHost;

    @Bean
    public Docket swaggerUI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PKG))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .host(serviceHost)
                .tags(
                        new Tag(
                                "TaskPlannerController",
                                "Project similar to Jira"));
    }

    private ApiInfo getApiInfo() {

        String appVersion = "1.0.0";
        String activeProfile = "dev";
        String teamEmailId = "shreyanshushekhar7@gamil.com";
        String projectName = "Task Planner";
        return new ApiInfo(
                projectName + " - " + StringUtils.capitalize(activeProfile),
                "Project similar to Jira",
                appVersion,
                null,
                new Contact(teamEmailId, null, teamEmailId),
                null,
                null,
                Collections.emptyList());
    }
}
