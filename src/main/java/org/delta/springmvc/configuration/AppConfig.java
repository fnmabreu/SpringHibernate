package org.delta.springmvc.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * This Class represent Spring MVC configuration.
 *
 * @Configuration indicates that this class contains one or more bean methods
 *                annotated with @Bean producing beans manageable by spring
 *                container.
 * 
 * @ComponentScan referes to package locations to find the associated beans
 * 
 * @EnableWebMvc is equivalent to mvc:annotation-driven in XML.
 * 
 * Method viewResolver configures a view resolver to identify the real view.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.delta.springmvc")
public class AppConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
