package feedbackservice.web.dto.response;

public record CreateFeedbackResponse(
        String location
) {
    public static CreateFeedbackResponse of(String location) {
        return new CreateFeedbackResponse(location);
    }
}
