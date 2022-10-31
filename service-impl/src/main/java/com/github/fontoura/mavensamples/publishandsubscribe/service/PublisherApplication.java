package  com.github.fontoura.mavensamples.publishandsubscribe.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.NoArgsConstructor;

@SpringBootApplication
@ComponentScan(basePackageClasses={PublisherApplication.class})
@NoArgsConstructor
public class PublisherApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

}
