package pl.filmbox.repositories.implementations;

import org.springframework.stereotype.Repository;
import pl.filmbox.models.Genre;
import pl.filmbox.repositories.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addGenre(Genre genre) {
        entityManager.merge(genre);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return entityManager.merge(genre);
    }

    @Override
    public Genre getGenre(Long genreId) {
        return entityManager.find(Genre.class, genreId);
    }

    @Override
    public List<Genre> getAllGenres() {
        TypedQuery<Genre> typedQuery = entityManager.createQuery(
                "SELECT g FROM " + Genre.class.getSimpleName() + " g",
                Genre.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteGenre(Long genreId) {
        Genre genre = entityManager.find(Genre.class, genreId);
        if (genre != null)
            entityManager.remove(genre);
    }
}
