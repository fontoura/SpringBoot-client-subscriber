package com.github.fontoura.mavensamples.publishandsubscribe.service.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;

public interface PublisherService {

    @PostMapping(path="send", consumes="application/json")
    public ResponseEntity<Void> send(@RequestBody MessageDTO message);


}
