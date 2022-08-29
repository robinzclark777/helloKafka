package mil.dia.merlin.hellokafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import mil.dia.merlin.hellokafka.services.HelloKafkaService;

import java.util.Locale;
import java.util.function.Consumer;

@Component
class KafkaConsumer {

    private Consumer<String> writeToTopic;
 
    public KafkaConsumer(Consumer<String> writeToTopic) {
        this.writeToTopic = writeToTopic;
    }

    @KafkaListener(id = "merlin", topics = "hello-kafka-input")
    public void listen(String in) {
    	String s = in.toUpperCase(Locale.ENGLISH);
        writeToTopic.accept(s);
    }
}
