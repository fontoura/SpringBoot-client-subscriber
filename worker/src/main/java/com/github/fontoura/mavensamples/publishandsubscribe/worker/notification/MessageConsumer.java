package  com.github.fontoura.mavensamples.publishandsubscribe.worker.notification;

import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageEventDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component("event")
@AllArgsConstructor
public class MessageConsumer implements Consumer<MessageEventDTO> {

    @Autowired
    MessageHandler handler;

    @Override
    public void accept(MessageEventDTO messageEvent) {
        handler.handleMessage(messageEvent.getMessage());
    }

}
