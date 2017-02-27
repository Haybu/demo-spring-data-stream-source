package com.homedepot.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * Created by hxm3459 on 2/26/17.
 */
@EnableBinding(ConsumerChannels.class)
public class FilesProducer {

    private final MessageChannel consumer;

    // automatic autowiring of ProducerChannels with new spring version
    public FilesProducer(ConsumerChannels channels) {
        consumer = channels.consumer();
    }

    public void sendMessage(String content) {
        Message<String> msg = MessageBuilder.withPayload(content).build();
        consumer.send(msg);
    }
}

interface ConsumerChannels {

    @Output
    MessageChannel consumer();
}