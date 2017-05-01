package pl.filmbox.repositories;

import pl.filmbox.models.Rating;

import java.util.List;

public interface RatingRepository {
    void addRating(Rating rating);
    Rating updateRating(Rating rating);
    Rating getRating(Long ratingId);
    List<Rating> getAllRatings();
    void deleteRating(Long ratingId);
}
