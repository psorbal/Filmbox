package pl.filmbox.services;

import pl.filmbox.models.Rating;

import java.util.List;

public interface RatingService {
    void addRating(Rating rating);
    Rating updateRating(Rating rating);
    Rating getRating(Long ratingId);
    List<Rating> getAllRatings();
    void deleteRating(Long ratingId);
}
