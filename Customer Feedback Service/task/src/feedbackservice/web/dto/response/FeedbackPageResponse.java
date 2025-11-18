package feedbackservice.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import feedbackservice.domain.model.Feedback;

import java.util.List;

public record FeedbackPageResponse(
        @JsonProperty("total_documents")
        long totalDocuments,

        @JsonProperty("is_first_page")
        boolean isFirstPage,

        @JsonProperty("is_last_page")
        boolean isLastPage,

        @JsonProperty("documents")
        List<Feedback> documents
) {
}