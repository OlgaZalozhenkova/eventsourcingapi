package com.example.api.kafka;

import com.example.api.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PeopleConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topics.api-topic}",
            containerFactory = "personKafkaListenerContainerFactory",
            groupId = "DDD"

    )
    public void receive(@Payload Person person) {
        System.out.println("Person "
                + person + " received");
    }

}
