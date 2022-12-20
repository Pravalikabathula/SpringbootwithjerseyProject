
package com.example.demo.securityconfig;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
@Primary
public class SwaggerResourceProvider1 implements SwaggerResourcesProvider {
	@Resource
	private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;

	@Override
	public List<SwaggerResource> get() {

		SwaggerResource Resource = new SwaggerResource();
		Resource.setLocation("/api/swagger.json");
		Resource.setSwaggerVersion("2.0");

		return Stream.concat(Stream.of(Resource), inMemorySwaggerResourcesProvider.get().stream())
				.collect(Collectors.toList());
	}

}
