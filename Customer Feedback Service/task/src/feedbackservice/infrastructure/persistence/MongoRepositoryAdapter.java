package feedbackservice.infrastructure.persistence;

import feedbackservice.domain.repository.BaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.function.Function;

public abstract class MongoRepositoryAdapter<D, E, ID> implements BaseRepository<D, ID> {

    protected final MongoRepository<E, ID> mongoRepository;

    protected final Function<D, E> toEntity;

    protected final Function<E, D> toDomain;

    public MongoRepositoryAdapter(
            MongoRepository<E, ID> mongoRepository,
            Function<D, E> toEntity,
            Function<E, D> toDomain) {
        this.mongoRepository = mongoRepository;
        this.toEntity = toEntity;
        this.toDomain = toDomain;
    }

    @Override
    public D save(D domain) {
        E entity = toEntity.apply(domain);
        E saved = mongoRepository.save(entity);
        return toDomain.apply(saved);
    }

    @Override
    public Optional<D> findById(ID id) {
        return mongoRepository.findById(id)
                .map(toDomain);
    }

    @Override
    public Page<D> findAll(Example<D> feedbackRequestExample, Pageable pageable) {
        D probe = feedbackRequestExample.getProbe();
        E entityProbe = toEntity.apply(probe);
        Example<E> example = Example.of(entityProbe, feedbackRequestExample.getMatcher());
        Page<E> page = mongoRepository.findAll(example, pageable);
        return page.map(toDomain);
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        return mongoRepository.findAll(pageable)
                .map(toDomain);
    }

    @Override
    public void deleteById(ID id) {
        mongoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return mongoRepository.existsById(id);
    }

}
