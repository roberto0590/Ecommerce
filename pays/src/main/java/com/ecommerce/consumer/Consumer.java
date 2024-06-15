package com.ecommerce.consumer;


import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
    //COMENTADO PARA PRUEBAS YA QUE SOLO SE DEBEN ENCOLAR SEGUN EXAMEN
    /*@RabbitListener(queues = { "${sacavix.queue.name}" })
    public void receive(@Payload String message) {

        log.info("Received message {}", message);

        makeSlow();

    }

    private void makeSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
}
