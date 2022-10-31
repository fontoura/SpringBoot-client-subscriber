package com.github.fontoura.mavensamples.publishandsubscribe.worker.notification;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;

public class MessageHandlerTests {

    MessageHandler handler;

    @BeforeEach
    public void beforeEach() {
        handler = new MessageHandler();
    }

    @Test
    @DisplayName("Should not throw excepion, then a message is received")
    public void shouldNotCrash_whenMessageReceived() {
        final MessageDTO message = MessageDTO.builder()
                .text("MOCK")
                .build();

        assertDoesNotThrow(() -> {
            handler.handleMessage(message);
        });

    }
}
