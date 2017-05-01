package pl.filmbox.repositories;

import pl.filmbox.models.Genre;

import java.util.List;

public interface GenreRepository {
    void addGenre(Genre genre);
    Genre updateGenre(Genre genre);
    Genre getGenre(Long genreId);
    List<Genre> getAllGenres();
    void deleteGenre(Long genreId);
}
