package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.filmbox.models.Rating;
import pl.filmbox.services.RatingService;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/all")
    public ModelAndView getAllRoles() {
        List<Rating> ratings = ratingService.getAllRatings();
        return new ModelAndView("ratings/show-all", "ratings", ratings);
    }

    @GetMapping("/{id}")
    public ModelAndView getSingleRole(@PathVariable Long id) {
        Rating rating = ratingService.getRating(id);
        return new ModelAndView("ratings/show-single", "rating", rating);
    }

    @GetMapping("/create")
    public ModelAndView getCreateRoleForm() {
        return new ModelAndView("ratings/create", "Rating",new Rating());
    }

    @PostMapping("/create")
    public ModelAndView createRole(@ModelAttribute Rating rating) {
        ratingService.addRating(rating);
        return new ModelAndView("redirect:/rating/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditRoleForm(@PathVariable Long id) {
        Rating rating = ratingService.getRating(id);
        return new ModelAndView("ratings/edit", "rating", rating);
    }

    @PutMapping("/update")
    public ModelAndView updateRole(@ModelAttribute Rating rating) {
        ratingService.updateRating(rating);
        return new ModelAndView("redirect:/rating/all");
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteRole(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return new ModelAndView("redirect:/rating/all");
    }
}
