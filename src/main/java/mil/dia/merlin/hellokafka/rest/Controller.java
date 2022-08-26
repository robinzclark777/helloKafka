package mil.dia.merlin.hellokafka.rest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controller {
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public Controller(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/hello")
    public String createHelloKafka(@RequestBody String sensor) {
        kafkaTemplate.send("hello-kafka-input", sensor);
        return "hello kafka message successfully processed";
    }

}
