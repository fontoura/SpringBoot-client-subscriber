package  com.github.fontoura.mavensamples.publishandsubscribe.service.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;
import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageEventDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MessagePublisher {

    @Autowired
    StreamBridge streamBridge;

    public void send(MessageDTO message) {
        streamBridge.send("event-out-0", MessageEventDTO.builder().message(message).build());
    }

}
