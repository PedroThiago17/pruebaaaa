package com.upn.comprademo.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.upn.comprademo.controller")).paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("DEMO API", "API for services REST from DEMO", "1.0", "http://codmind.com/terms",
				new Contact("Develop Team", "https://google.com", "n00279437@upn.pe"), "LICENSE", "LICENSE URL",
				Collections.emptyList());
	}
}
