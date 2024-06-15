package com.ecommerce.service.impl;
import com.ecommerce.publisher.Publisher;
import com.ecommerce.service.IRabbitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitServiceImpl implements IRabbitService {

	@Autowired
	private Publisher publisher;

	public void sendToRabbit(String message){
		log.info("Message '{}' will be send ... ", message);
		this.publisher.send(message);
	}

}
