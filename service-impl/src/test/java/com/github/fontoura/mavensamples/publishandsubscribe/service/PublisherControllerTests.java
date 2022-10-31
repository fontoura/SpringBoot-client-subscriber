package com.github.fontoura.mavensamples.publishandsubscribe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;
import com.github.fontoura.mavensamples.publishandsubscribe.service.notification.MessagePublisher;

public class PublisherControllerTests {
    
    private PublisherController controller;

    private MessagePublisher publisher;

    @BeforeEach
    public void beforeEach() {
        publisher = mock(MessagePublisher.class);
        controller = new PublisherController(publisher);
    }

    @Test
    @DisplayName("Should publish a single message, when there is a provided message")
    public void shouldPublishSingleMessage_whenMessageProvided() {
        final String messageText = "SAMPLE";
        final MessageDTO message = MessageDTO.builder()
                .text(messageText)
                .build();

        ResponseEntity<Void> response = controller.send(message);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        verify(publisher, times(1)).send(any(MessageDTO.class));
        verify(publisher, times(1)).send(message);
    }

    @Test
    @DisplayName("Should not publish a message, when there is no provided message")
    public void shouldNoPublishSingleMessage_whenMessageNotProvided() {
        final MessageDTO message = null;

        ResponseEntity<Void> response = controller.send(message);

        assertNotNull(response);
        assertNotEquals(response.getStatusCode(), HttpStatus.OK);
        verify(publisher, times(0)).send(any(MessageDTO.class));
    }

}
