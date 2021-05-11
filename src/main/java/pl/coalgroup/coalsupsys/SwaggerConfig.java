package pl.coalgroup.coalsupsys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/api/v1/*"))
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("pl.coalgroup.coalsupsys"))
                .build()
                .apiInfo(apiDetails());

        return docket;
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Coal Supplier System API",
                "",
                "1.0",
                "",
                new springfox.documentation.service.Contact("Tomasz Kondej","", "tomasz_kondej@o2.pl"),
                "API License",
                "",
                Collections.emptyList()
        );
    }
}
