package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
@Configuration
@EnableWebMvc
public class SpringbootGradleApplication extends WebMvcConfigurerAdapter {
	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setContentType("text/html;charset=utf-8");
		resolver.setSuffix(".ftl");
		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
		freemarkerConfig.setTemplateLoaderPath("classpath:/templates");
		freemarkerConfig.setDefaultEncoding("UTF-8");

		Map<String, Object> freemarkerVariables = new HashMap<>();
		freemarkerConfig.setFreemarkerVariables(freemarkerVariables);
		return freemarkerConfig;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGradleApplication.class, args);
	}
}
