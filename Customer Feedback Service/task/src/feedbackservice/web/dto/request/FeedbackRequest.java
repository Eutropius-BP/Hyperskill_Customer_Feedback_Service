package feedbackservice.web.dto.request;

public record FeedbackRequest(
        int rating,
        String feedback,
        String customer,
        String product,
        String vendor

) {}
