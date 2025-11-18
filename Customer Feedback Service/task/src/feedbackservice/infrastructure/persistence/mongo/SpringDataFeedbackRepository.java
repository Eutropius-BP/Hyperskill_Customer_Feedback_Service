package feedbackservice.infrastructure.persistence.mongo;

import feedbackservice.domain.model.Feedback;
import feedbackservice.infrastructure.persistence.entity.FeedbackDocument;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.nio.channels.FileChannel;
import java.util.List;

public interface SpringDataFeedbackRepository extends MongoRepository<FeedbackDocument, String> {

    List<FeedbackDocument> findByCustomer(String customer);

    List<FeedbackDocument> findByProduct(String product);

    List<FeedbackDocument> findByVendor(String vendor);

    List<FeedbackDocument> findByRatingGreaterThanEqual(int rating);

}
