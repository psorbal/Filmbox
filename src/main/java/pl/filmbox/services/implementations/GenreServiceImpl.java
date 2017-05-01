package pl.filmbox.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.filmbox.models.Genre;
import pl.filmbox.repositories.GenreRepository;
import pl.filmbox.services.GenreService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void addGenre(Genre genre) {
        genreRepository.addGenre(genre);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return genreRepository.updateGenre(genre);
    }

    @Override
    public Genre getGenre(Long genreId) {
        return genreRepository.getGenre(genreId);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.getAllGenres();
    }

    @Override
    public void deleteGenre(Long genreId) {
        genreRepository.deleteGenre(genreId);
    }
}
