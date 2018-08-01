package com.karthik.webservice.swagger;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Karthik Akinapelli",
			"http://localhost:8596/hello-world-bean", "kart@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Sprig Swagger Api Documentation",
			"Spring Swagger Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0");

	@Bean
	public Docket api() {

		Set<String> consumesAndProduces = new LinkedHashSet<>();
		consumesAndProduces.add("application/json");
		consumesAndProduces.add("application/xml");

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).consumes(consumesAndProduces)
				.produces(consumesAndProduces);
	}

}
