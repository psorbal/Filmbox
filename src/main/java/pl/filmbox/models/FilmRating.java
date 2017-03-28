package pl.filmbox.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film_rating")
public class FilmRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_rating_id")
    private Long filmRatingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getFilmRatingId() {
        return filmRatingId;
    }

    public void setFilmRatingId(Long filmRatingId) {
        this.filmRatingId = filmRatingId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmRating)) return false;
        FilmRating that = (FilmRating) o;

        return Objects.equals(filmRatingId, that.filmRatingId) &&
                Objects.equals(film, that.film) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmRatingId, film, rating, user);
    }
}
