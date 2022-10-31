package com.github.fontoura.mavensamples.publishandsubscribe.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.github.fontoura.mavensamples.publishandsubscribe.model.MessageDTO;
import com.github.fontoura.mavensamples.publishandsubscribe.service.client.PublisherServiceClient;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = PublisherServiceClient.class)
@ComponentScan(basePackageClasses = {SampleClientApplication.class, PublisherServiceClient.class})
public class SampleClientApplication implements ApplicationRunner {

	@Autowired
	PublisherServiceClient publisherServiceClient;

    @Autowired
    private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SampleClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		MessageDTO message = MessageDTO.builder()
				.text("Test message")
				.build();
		publisherServiceClient.send(message);

		context.close();
	}

}
