package feedbackservice.domain.repository;


import feedbackservice.domain.model.Feedback;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FeedbackRepository extends BaseRepository<Feedback, String>{

    List<Feedback> findByCustomer(String customer);

    List<Feedback> findByProduct(String product);

    List<Feedback> findByVendor(String vendor);

    List<Feedback> findByRatingGreaterThanEqual(int rating);


}
