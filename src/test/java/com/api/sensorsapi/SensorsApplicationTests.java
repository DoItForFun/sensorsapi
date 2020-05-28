package com.api.sensorsapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class SensorsApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Test
    public void test_send() {
        for (int i = 0; i < 3; i++) {
            kafkaTemplate.send("test-java" , "hello" + i);
        }

    }


}
