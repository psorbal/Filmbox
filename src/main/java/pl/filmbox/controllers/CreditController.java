package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.filmbox.models.Credit;
import pl.filmbox.services.CreditService;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/all")
    public ModelAndView getAllCredits() {
        List<Credit> credits = creditService.getAllCredits();
        return new ModelAndView("credits/show-all", "credits", credits);
    }

    @GetMapping("/{id}")
    public ModelAndView getSingleCredit(@PathVariable Long id) {
        Credit credit = creditService.getCredit(id);
        return new ModelAndView("credits/show-single", "credit", credit);
    }

    @GetMapping("/create")
    public ModelAndView getCreateCreditForm() {
        return new ModelAndView("credits/create", "Credit", new Credit());
    }

    @PostMapping("/create")
    public ModelAndView createCredit(@ModelAttribute Credit credit) {
        creditService.addCredit(credit);
        return new ModelAndView("redirect:/credit/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditCreditForm(@PathVariable Long id) {
        Credit credit = creditService.getCredit(id);
        return new ModelAndView("credits/edit", "credit", credit);
    }

    @PutMapping("/update")
    public ModelAndView updateCredit(@ModelAttribute Credit credit) {
        creditService.updateCredit(credit);
        return new ModelAndView("redirect:/credit/all");
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return new ModelAndView("redirect:/credit/all");
    }

}
