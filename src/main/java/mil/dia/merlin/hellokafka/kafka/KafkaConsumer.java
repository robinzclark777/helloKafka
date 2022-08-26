package mil.dia.merlin.hellokafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
class KafkaConsumer {
    private Consumer<String> consumeFunction;

    public KafkaConsumer(Consumer<String> consumeFunction) {
        this.consumeFunction = consumeFunction;
    }

    @KafkaListener(id = "merlin", topics = "hello-kafka-input")
    public void listen(String in) {
        consumeFunction.accept(in);
    }
}
