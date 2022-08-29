package mil.dia.merlin.hellokafka.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
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
    public void createHelloKafka(@RequestBody String sensor) {
    	ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send("hello-kafka-input", sensor);
    	future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println("Sent message=[" + sensor + 
                  "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" 
                  + sensor + "] due to : " + ex.getMessage());
            }
        });
    }

}
