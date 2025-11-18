package feedbackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "feedbackservice.infrastructure.persistence.mongo")
public class FeedbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeedbackApplication.class, args);
    }
}
