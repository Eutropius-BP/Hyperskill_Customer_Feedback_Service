package feedbackservice.infrastructure.persistence.mapper;

import feedbackservice.domain.model.Feedback;
import feedbackservice.infrastructure.persistence.entity.FeedbackDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    FeedbackDocument toDocument(Feedback feedback);

    Feedback toDomain(FeedbackDocument document);
}
