package  com.github.fontoura.mavensamples.publishandsubscribe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;
import com.github.fontoura.mavensamples.publishandsubscribe.service.api.PublisherService;
import  com.github.fontoura.mavensamples.publishandsubscribe.service.notification.MessagePublisher;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("test")
@AllArgsConstructor
public class PublisherController implements PublisherService {

    @Autowired
    MessagePublisher publisher;

    public ResponseEntity<Void> send(MessageDTO message) {
        if (message == null) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        publisher.send(message);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
