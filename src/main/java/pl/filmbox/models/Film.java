package pl.filmbox.models;

import javax.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "title_pl")
    private String titlePL;

    @Column(name = "title_eng")
    private String titleENG;

    @Column(name = "release_year")
    private Year releaseYear;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "film")
    private Set<FilmPeople> filmPeople = new HashSet<FilmPeople>();

    @OneToMany(mappedBy = "film")
    private Set<FilmGenre> filmGenres = new HashSet<FilmGenre>();

    @OneToMany(mappedBy = "film")
    private Set<FilmRating> filmRatings = new HashSet<FilmRating>();

    @OneToMany(mappedBy = "film")
    private Set<Comment> comments = new HashSet<Comment>();

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitlePL() {
        return titlePL;
    }

    public void setTitlePL(String titlePL) {
        this.titlePL = titlePL;
    }

    public String getTitleENG() {
        return titleENG;
    }

    public void setTitleENG(String titleENG) {
        this.titleENG = titleENG;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<FilmPeople> getFilmPeople() {
        return filmPeople;
    }

    public void setFilmPeople(Set<FilmPeople> filmPeople) {
        this.filmPeople = filmPeople;
    }

    public Set<FilmGenre> getFilmGenres() {
        return filmGenres;
    }

    public void setFilmGenres(Set<FilmGenre> filmGenres) {
        this.filmGenres = filmGenres;
    }

    public Set<FilmRating> getFilmRatings() {
        return filmRatings;
    }

    public void setFilmRatings(Set<FilmRating> filmRatings) {
        this.filmRatings = filmRatings;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;

        return Objects.equals(filmId, film.filmId) &&
                Objects.equals(titlePL, film.titlePL) &&
                Objects.equals(titleENG, film.titleENG) &&
                Objects.equals(releaseYear, film.releaseYear) &&
                Objects.equals(description, film.description) &&
                Objects.equals(filmPeople, film.filmPeople) &&
                Objects.equals(filmGenres, film.filmGenres) &&
                Objects.equals(filmRatings, film.filmRatings) &&
                Objects.equals(comments, film.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                filmId,
                titlePL,
                titleENG,
                releaseYear,
                description,
                filmPeople,
                filmGenres,
                filmRatings,
                comments
        );
    }
}
