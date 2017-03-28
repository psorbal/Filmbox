package pl.filmbox.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film_genre")
public class FilmGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_genre_id")
    private Long filmGenreId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Long getFilmGenreId() {
        return filmGenreId;
    }

    public void setFilmGenreId(Long filmGenreId) {
        this.filmGenreId = filmGenreId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmGenre)) return false;
        FilmGenre filmGenre = (FilmGenre) o;

        return Objects.equals(filmGenreId, filmGenre.filmGenreId) &&
                Objects.equals(film, filmGenre.film) &&
                Objects.equals(genre, filmGenre.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmGenreId, film, genre);
    }
}
