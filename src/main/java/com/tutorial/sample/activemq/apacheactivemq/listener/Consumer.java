package com.tutorial.sample.activemq.apacheactivemq.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

        @JmsListener(destination = "app.queue")
        public void Receiver(String message){
            System.out.println("Received message : "+message);
        }

}
