package kaftest;

import javax.inject.Singleton;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Scheduled;

@Singleton
public class Application {

    private final BookProducer bookProducer;

    Application(BookProducer bookProducer) {
        this.bookProducer = bookProducer;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }

    @Scheduled(initialDelay = "30s", fixedDelay = "5s")
    void startup() {
        System.out.println("Sending message");
        bookProducer.send("Hello World");
    }
}