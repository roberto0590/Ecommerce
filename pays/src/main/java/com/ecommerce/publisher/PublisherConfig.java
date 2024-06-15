package com.ecommerce.publisher;

import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class PublisherConfig {

    @Value("${sacavix.queue.name}")
    private String message;

    @Bean
    public Queue queue() {
        return new Queue(message, true);
    }

    @Bean
    public MessageConverter jsonToMapMessageConverter() {
        DefaultClassMapper defaultClassMapper = new DefaultClassMapper();
        defaultClassMapper.setTrustedPackages("com.productos.apirest.dummy"); // trusted packages
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setClassMapper(defaultClassMapper);
        return jackson2JsonMessageConverter;
    }

}
