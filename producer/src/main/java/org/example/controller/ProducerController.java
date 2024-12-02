package org.example.controller;

import org.example.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    private static final String TOPIC = "test2Topic";

    @PostMapping("/send")
    public String sendMessage(@RequestBody UserDto dto) {
        kafkaTemplate.send(TOPIC, dto);
        return "Message sent: " + dto.toString();
    }
}
