package pl.filmbox.repositories.implementations;

import org.springframework.stereotype.Repository;
import pl.filmbox.models.Rating;
import pl.filmbox.repositories.RatingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRating(Rating rating) {
        entityManager.merge(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return entityManager.merge(rating);
    }

    @Override
    public Rating getRating(Long ratingId) {
        return entityManager.find(Rating.class, ratingId);
    }

    @Override
    public List<Rating> getAllRatings() {
        TypedQuery<Rating> typedQuery = entityManager.createQuery(
                "SELECT r FROM " + Rating.class.getSimpleName() + " r",
                Rating.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteRating(Long ratingId) {
        Rating rating = entityManager.find(Rating.class, ratingId);
        if (rating != null)
            entityManager.remove(rating);
    }
}
