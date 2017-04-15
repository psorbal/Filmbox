package pl.filmbox.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @Column(name = "rating")
    private float rating;

    @Column(name = "in_words")
    private String inWords;

    @OneToMany(mappedBy = "rating")
    private Set<FilmRating> filmRatings = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getInWords() {
        return inWords;
    }

    public void setInWords(String inWords) {
        this.inWords = inWords;
    }

    public Set<FilmRating> getFilmRatings() {
        return Collections.unmodifiableSet(this.filmRatings);
    }

    public void addFilmRating(FilmRating filmRating) {
        filmRating.setRating(this);
        this.filmRatings.add(filmRating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        Rating rating1 = (Rating) o;
        return Float.compare(rating1.rating, rating) == 0 &&
                Objects.equals(id, rating1.id) &&
                Objects.equals(inWords, rating1.inWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, inWords);
    }
}
