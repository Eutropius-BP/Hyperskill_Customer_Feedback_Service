package feedbackservice.service;

import feedbackservice.domain.model.Feedback;
import feedbackservice.web.dto.request.FeedbackRequest;
import feedbackservice.web.dto.response.CreateFeedbackResponse;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FeedbackService {
    CreateFeedbackResponse createFeedback(FeedbackRequest request);

    Feedback getFeedbackById(String id);

    Page<Feedback> getFeedback(Pageable pageable, Integer rating, String customer, String product, String vendor);

}
