package com.github.fontoura.mavensamples.publishandsubscribe.worker.notification;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;
import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageEventDTO;

public class MessageConsumerTests {

    MessageConsumer consumer;
    
    MessageHandler handler;

    @BeforeEach
    public void beforeEach() {
        handler = mock(MessageHandler.class);

        consumer = new MessageConsumer(handler);
    }

    @Test
    @DisplayName("Should invoke handler, when a message event is received")
    public void shouldInvokeHandler_whenMessageEventReceived() {
        final MessageDTO message = MessageDTO.builder()
                .text("MOCK")
                .build();
        final MessageEventDTO event = MessageEventDTO.builder()
                .message(message)
                .build();

        consumer.accept(event);

        verify(handler, times(1)).handleMessage(any(MessageDTO.class));
        verify(handler, times(1)).handleMessage(message);
    }
}
