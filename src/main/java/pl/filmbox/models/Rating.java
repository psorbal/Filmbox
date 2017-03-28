package pl.filmbox.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "rating_as_string")
    private String ratingAsWord;

    @OneToMany(mappedBy = "rating")
    private Set<FilmRating> filmRatings = new HashSet<FilmRating>();

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getRatingAsWord() {
        return ratingAsWord;
    }

    public void setRatingAsWord(String ratingAsWord) {
        this.ratingAsWord = ratingAsWord;
    }

    public Set<FilmRating> getFilmRatings() {
        return filmRatings;
    }

    public void setFilmRatings(Set<FilmRating> filmRatings) {
        this.filmRatings = filmRatings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating1 = (Rating) o;

        return Objects.equals(ratingId, rating1.ratingId) &&
                Objects.equals(rating, rating1.rating) &&
                Objects.equals(ratingAsWord, rating1.ratingAsWord) &&
                Objects.equals(filmRatings, rating1.filmRatings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, rating, ratingAsWord, filmRatings);
    }
}
