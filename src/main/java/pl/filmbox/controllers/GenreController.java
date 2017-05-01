package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.filmbox.models.Genre;
import pl.filmbox.services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public ModelAndView getAllRoles() {
        List<Genre> genres = genreService.getAllGenres();
        return new ModelAndView("genres/show-all", "genres", genres);
    }

    @GetMapping("/{id}")
    public ModelAndView getSingleRole(@PathVariable Long id) {
        Genre genre = genreService.getGenre(id);
        return new ModelAndView("genres/show-single", "genre", genre);
    }

    @GetMapping("/create")
    public ModelAndView getCreateRoleForm() {
        return new ModelAndView("genres/create", "Genre", new Genre());
    }

    @PostMapping("/create")
    public ModelAndView createRole(@ModelAttribute Genre genre) {
        genreService.addGenre(genre);
        return new ModelAndView("redirect:/genre/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditRoleForm(@PathVariable Long id) {
        Genre genre = genreService.getGenre(id);
        return new ModelAndView("genres/edit", "genre", genre);
    }

    @PutMapping("/update")
    public ModelAndView updateRole(@ModelAttribute Genre genre) {
        genreService.updateGenre(genre);
        return new ModelAndView("redirect:/genre/all");
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteRole(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ModelAndView("redirect:/genre/all");
    }
}
