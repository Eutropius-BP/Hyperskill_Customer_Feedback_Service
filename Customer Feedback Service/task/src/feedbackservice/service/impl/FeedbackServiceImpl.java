package feedbackservice.service.impl;

import feedbackservice.domain.exception.FeedbackNotFound;
import feedbackservice.domain.model.Feedback;
import feedbackservice.domain.repository.FeedbackRepository;
import feedbackservice.infrastructure.persistence.entity.FeedbackDocument;
import feedbackservice.service.FeedbackService;
import feedbackservice.web.dto.request.FeedbackRequest;
import feedbackservice.web.dto.response.CreateFeedbackResponse;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public CreateFeedbackResponse createFeedback(FeedbackRequest request) {
        Feedback feedback = new Feedback(
                null,
                request.rating(),
                request.feedback(),
                request.customer(),
                request.product(),
                request.vendor()
        );
        Feedback saved = feedbackRepository.save(feedback);
        return CreateFeedbackResponse.of(saved.getId());

    }

    @Override
    public Feedback getFeedbackById(String id) {
        return feedbackRepository.findById(id).orElseThrow(FeedbackNotFound::new);
    }

    @Override
    public Page<Feedback> getFeedback(Pageable pageable, Integer rating, String customer, String product, String vendor) {
        Feedback probe = new Feedback(null, rating, null, customer, product, vendor);

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);

        Example<Feedback> example = Example.of(probe, matcher);


        return feedbackRepository.findAll(example, pageable);
    }
}
