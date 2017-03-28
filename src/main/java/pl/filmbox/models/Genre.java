package pl.filmbox.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "genre")
    private Set<FilmGenre> filmGenres = new HashSet<FilmGenre>();

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<FilmGenre> getFilmGenres() {
        return filmGenres;
    }

    public void setFilmGenres(Set<FilmGenre> filmGenres) {
        this.filmGenres = filmGenres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre1 = (Genre) o;

        return Objects.equals(genreId, genre1.genreId) &&
                Objects.equals(genre, genre1.genre) &&
                Objects.equals(filmGenres, genre1.filmGenres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genre, filmGenres);
    }
}
