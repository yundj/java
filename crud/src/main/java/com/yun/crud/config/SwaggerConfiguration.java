package com.yun.crud.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
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
 * @Auther: Yun
 * @Date: 2020/12/10 13:49
 * @Description: swagger 配置类
 * @ClassName: SwaggerConfiguration
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                //此组名可以通过数据库查出来加载里面，通过模块路径进行扫描不同微服务名的包路径。
                .groupName("crud-demo")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yun.crud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("crud-demo")
                .description("crud-demo")
                .termsOfServiceUrl("http://localhost:8888")
                .contact(new Contact("contact","url","email"))
                .version("1.0")
                .build();
    }
}
