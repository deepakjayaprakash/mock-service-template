package com.service.mock;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.service.mock"})
@EnableAsync(proxyTargetClass = true)
@EnableSwagger2
public class MockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(paths()).build().apiInfo(this.apiInfo())
				.pathMapping("/");
	}


	private Predicate<String> paths() {
		return or(
				regex("/mock-service.*")
		);
	}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("Mock Service API")
					.description("Documentation for mock service api")
					.termsOfServiceUrl("http://springfox.io").version("0.1").build();
		}

}
