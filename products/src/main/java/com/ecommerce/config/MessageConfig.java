package com.ecommerce.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageConfig {

	   //Load the properties
		@Bean
		public MessageSource messageSource() {
			ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
			messageSource.setBasename("classpath:messages");
			//messageSource.setDefaultEncoding("UTF-8");
			return messageSource;
		}

		//Set a locale by default
		@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver slr = new SessionLocaleResolver();
			slr.setDefaultLocale(Locale.ROOT);
			return slr;
		}

		//To resolve variables in messages
		@Bean
		public LocalValidatorFactoryBean getValidator() {
			LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
			bean.setValidationMessageSource(messageSource());
			return bean;
		}
}
