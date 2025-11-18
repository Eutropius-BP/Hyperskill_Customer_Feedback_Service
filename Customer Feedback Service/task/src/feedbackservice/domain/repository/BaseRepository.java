package feedbackservice.domain.repository;

import feedbackservice.web.dto.request.FeedbackRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseRepository <T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

//    Page<T> findAll(Example<T> feedbackRequestExample, Pageable pageable);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(Example<T>  feedbackRequestExample, Pageable pageable);

    void deleteById(ID id);

    boolean existsById(ID id);

}
