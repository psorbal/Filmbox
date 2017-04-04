package pl.filmbox.models;

import javax.persistence.*;
import java.time.Year;
import java.util.*;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;
    private String title;
    private Year release;
    private String description;

    @OneToMany(mappedBy = "film")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "film")
    private Set<FilmRating> filmRatings = new HashSet<>();

    @OneToMany(mappedBy = "film")
    private Set<FilmPeople> filmPeople = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "films_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getRelease() {
        return release;
    }

    public void setRelease(Year release) {
        this.release = release;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Comment> getComments() {
        return Collections.unmodifiableSet(this.comments);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Set<FilmRating> getRatings() {
        return Collections.unmodifiableSet(this.filmRatings);
    }

    public void addFilmRating(FilmRating filmRating) {
        filmRating.setFilm(this);
        this.filmRatings.add(filmRating);
    }

    public Set<FilmPeople> getFilmPeople() {
        return Collections.unmodifiableSet(this.filmPeople);
    }

    public void addFilmPeople(FilmPeople filmPeople) {
        filmPeople.setFilm(this);
        this.filmPeople.add(filmPeople);
    }

    public Set<Genre> getGenres() {
        return Collections.unmodifiableSet(this.genres);
    }

    public void addGenres(Genre genre) {
        this.genres.add(genre);
    }
}
