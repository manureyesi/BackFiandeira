package es.fiandeira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@ComponentScan({ "es.fiandeira" })
@EnableJpaRepositories
@Import(SwaggerConfiguration.class)
public class BackFiandeiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackFiandeiraApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
 
    }

}
