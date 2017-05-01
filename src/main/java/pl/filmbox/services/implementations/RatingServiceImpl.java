package pl.filmbox.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.filmbox.models.Rating;
import pl.filmbox.repositories.RatingRepository;
import pl.filmbox.services.RatingService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.addRating(rating);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.updateRating(rating);
    }

    @Override
    public Rating getRating(Long ratingId) {
        return ratingRepository.getRating(ratingId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.getAllRatings();
    }

    @Override
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteRating(ratingId);
    }
}
