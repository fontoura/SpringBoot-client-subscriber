package com.github.fontoura.mavensamples.publishandsubscribe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MessageEventDTO {

    @JsonProperty
    MessageDTO message;

}
