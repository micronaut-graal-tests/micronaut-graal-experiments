package kaftest;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface BookProducer {

    @Topic("foo")
    void send(String msg);
}