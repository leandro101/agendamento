package io.github.leandro101.rest.config;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("io.github.leandro101.rest.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Agendamento API")
                .description("API para agendar atendimentos de servico")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact("Leandro Vieira de Oliveira", "https://github.com/leandro101",
                "leandro3.0@hotmail.com");
    }
}
