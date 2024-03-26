package microservices.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/circuitBreakerApi")
    //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    //@CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String circuitBreakerApi() {
        logger.info("Sample Api call received");
        //ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummyUrl", String.class);

        //return forEntity.getBody();
        return "circuitBreakerApi";
    }

    private String hardcodedResponse(Exception exception) {
        return "fallbackResponse";
    }
}
