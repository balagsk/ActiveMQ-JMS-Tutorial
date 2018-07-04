package com.tutorial.sample.activemq.apacheactivemq.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class ActvieMqConfig {

    @Value("${activemq.broker-url}")
    private String brokerURL;

            @Bean
            public Queue queue(){
                return new ActiveMQQueue("app.queue");
            }


            @Bean
            public ActiveMQConnectionFactory activeMQConnectionFactory(){
                ActiveMQConnectionFactory activeMqFactory=new ActiveMQConnectionFactory();
                activeMqFactory.setBrokerURL(brokerURL);
                return activeMqFactory;
            }

            @Bean
            public JmsTemplate jmstemplate(){
                return new JmsTemplate(activeMQConnectionFactory());
            }
}
