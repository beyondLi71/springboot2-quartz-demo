package com.beyondli.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author beyondLi
 * @desc Swagger配置类.
 */

@EnableSwagger2//Swagger的开关，表示我们在项目中启用Swagger
@Configuration//声名这是一个配置类
//@ConfigurationProperties(prefix = "swagger")
@ConditionalOnProperty(prefix = "swagger",value =  {"enable"}, havingValue = "true")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerConfig {

    //controller接口所在的包
    @Value("${swagger.basePackage}")
    private String basePackage;

    //当前文档的标题
    @Value("${swagger.title}")
    private String title;

    //当前文档的详细描述
    @Value("${swagger.description}")
    private String description;

    //当前文档的版本
    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }


}