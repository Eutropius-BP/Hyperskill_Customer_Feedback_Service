package feedbackservice.infrastructure.persistence;

import feedbackservice.domain.model.Feedback;
import feedbackservice.domain.repository.FeedbackRepository;
import feedbackservice.infrastructure.persistence.entity.FeedbackDocument;
import feedbackservice.infrastructure.persistence.mapper.FeedbackMapper;
import feedbackservice.infrastructure.persistence.mongo.SpringDataFeedbackRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackRepositoryImpl
        extends MongoRepositoryAdapter<Feedback, FeedbackDocument, String>
        implements FeedbackRepository {

    private final SpringDataFeedbackRepository springDataRepository;
    private final FeedbackMapper mapper;

    public FeedbackRepositoryImpl(
            SpringDataFeedbackRepository springDataRepository,
            FeedbackMapper mapper) {
        super(springDataRepository, mapper::toDocument, mapper::toDomain);
        this.springDataRepository = springDataRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Feedback> findByCustomer(String customer) {
        return springDataRepository.findByCustomer(customer)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Feedback> findByProduct(String product) {
        return springDataRepository.findByProduct(product)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Feedback> findByVendor(String vendor) {
        return springDataRepository.findByVendor(vendor)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Feedback> findByRatingGreaterThanEqual(int rating) {
        return springDataRepository.findByRatingGreaterThanEqual(rating)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }


}
