package niuwajun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Application{
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
