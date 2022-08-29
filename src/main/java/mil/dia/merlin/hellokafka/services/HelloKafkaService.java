package mil.dia.merlin.hellokafka.services;

import java.util.Locale;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloKafkaService {
	
	public String transformMessage(String message) {
		System.out.println("transforming now!");
		return message.toUpperCase(Locale.ENGLISH);
	}

}
