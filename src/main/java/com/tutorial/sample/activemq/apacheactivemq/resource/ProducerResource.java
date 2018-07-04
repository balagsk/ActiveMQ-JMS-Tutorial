package com.tutorial.sample.activemq.apacheactivemq.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/jms/sendmsg")
public class ProducerResource {

    @Autowired
    JmsTemplate jmstemplate;

    @Autowired
    Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String messsage  ){
         jmstemplate.convertAndSend(queue,messsage);
         return "Success";
    }
}
