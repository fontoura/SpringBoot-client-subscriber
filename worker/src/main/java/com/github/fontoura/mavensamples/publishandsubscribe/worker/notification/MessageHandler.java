package  com.github.fontoura.mavensamples.publishandsubscribe.worker.notification;

import org.springframework.stereotype.Component;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class MessageHandler {

    public void handleMessage(MessageDTO message) {
        System.out.println(message.getText());
    }
    
}
