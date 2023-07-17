package hackathon.nttdata.coderpath.examenes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void publishMessage(String topicName, String message) {

		kafkaTemplate.send(topicName, "CODER PATH", message);
		System.out.println("Message published -->" + message);
	}

}
