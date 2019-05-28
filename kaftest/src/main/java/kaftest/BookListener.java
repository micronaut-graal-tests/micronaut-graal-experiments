package kaftest;

import io.micronaut.configuration.kafka.annotation.*;


@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class BookListener {

	@Topic("foo")
	void receiveMessage(String str) {
		System.out.println("GOT " + str);	
	}
}