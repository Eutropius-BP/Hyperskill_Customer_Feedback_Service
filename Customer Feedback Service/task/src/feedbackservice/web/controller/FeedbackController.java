package feedbackservice.web.controller;

import feedbackservice.domain.exception.FeedbackNotFound;
import feedbackservice.domain.model.Feedback;
import feedbackservice.service.FeedbackService;
import feedbackservice.web.dto.request.FeedbackRequest;
import feedbackservice.web.dto.response.CreateFeedbackResponse;
import feedbackservice.web.dto.response.FeedbackPageResponse;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService service) {
        this.feedbackService = service;
    }

    @PostMapping
    public ResponseEntity<Void> createFeedback(@RequestBody FeedbackRequest request) {
        CreateFeedbackResponse response = feedbackService.createFeedback(request);
        System.out.println(response.location());
        URI location = URI.create("/feedback/" + response.location());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public FeedbackPageResponse getFeedback(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int perPage,
            @RequestParam(required = false) Integer rating,
            @RequestParam(required = false) String customer,
            @RequestParam(required = false) String product,
            @RequestParam(required = false) String vendor) {

        if (page < 1) {
            page = 1;
        }

        if (perPage <5 || perPage > 20) {
            perPage = 10;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page - 1, perPage, sort);

        Page<Feedback> response = feedbackService.getFeedback(pageable, rating, customer,product, vendor);

        return new FeedbackPageResponse(
                response.getTotalElements(),
                response.isFirst(),
                response.isLast(),
                response.getContent()
        );
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable String id) {
        return feedbackService.getFeedbackById(id);
    }

}
