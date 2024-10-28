package com.exam.cloud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi PayApi() {
        return GroupedOpenApi.builder()
                .group("支付微服务模块")
                .pathsToMatch("/pay/**")
                .build();
    }
    @Bean
    public GroupedOpenApi OtherApi() {
        return GroupedOpenApi.builder()
                .group("其它微服务模块")
                .pathsToMatch("/other/**","/others/**")
                .build();
    }

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info().title("cloud2024").version("v1.0").description("通用设计rest"))
                .externalDocs(new ExternalDocumentation().description("其他资料").url("资料链接"));
    }
}
