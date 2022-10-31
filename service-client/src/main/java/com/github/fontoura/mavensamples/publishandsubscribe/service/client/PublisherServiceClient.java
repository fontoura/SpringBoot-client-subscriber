package com.github.fontoura.mavensamples.publishandsubscribe.service.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.github.fontoura.mavensamples.publishandsubscribe.service.api.PublisherService;

@FeignClient(name="publisherServiceClient", url = "${service.url}", path = "test")
public interface PublisherServiceClient extends PublisherService {
}
