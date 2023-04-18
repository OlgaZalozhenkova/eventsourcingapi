package com.example.api.kafka;

import com.example.api.model.Person;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeopleProducer {

    private final KafkaTemplate<String, Person> kafkaTemplate;

    @Value("${spring.kafka.topics.api-topic}")
    private String apiTopic;

    public void send(String name, Person person) {
        kafkaTemplate.send(apiTopic, name, person);
        System.out.println("person " + person + " send");
    }
}
