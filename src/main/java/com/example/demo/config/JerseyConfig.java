
package com.example.demo.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Controller.EmployeeResourceController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		this.register(EmployeeResourceController.class);
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void configureSwagger() {
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setTitle(" Spring Boot Jersey Swagger Documenation");
		config.setVersion("v2");
		config.setContact("Bright swagger");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("/api");
		config.setResourcePackage("com.example.demo");
		config.setPrettyPrint(true);
		config.setScan(true);
	}

}
