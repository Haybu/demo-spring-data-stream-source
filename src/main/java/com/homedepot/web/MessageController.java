package com.homedepot.web;

import com.homedepot.producer.FilesProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxm3459 on 2/26/17.
 */
@RestController
public class MessageController {

    FilesProducer producer;

    public MessageController(FilesProducer _producer) {
        producer = _producer;
    }

    @GetMapping("/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        producer.sendMessage(message);
    }

}
