package pl.filmbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.filmbox.models.Person;
import pl.filmbox.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ModelAndView getAllPersons() {
        List<Person> people = personService.getAllPersons();
        return new ModelAndView("persons/show-all", "people", people);
    }

    @GetMapping("/{id}")
    public ModelAndView getPerson(@PathVariable Long id) {
        Person person = personService.getPerson(id);
        return new ModelAndView("persons/show-single", "person", person);
    }

    @GetMapping("/create")
    public ModelAndView getCreateRoleForm() {
        return new ModelAndView("persons/create", "Person", new Person());
    }

    @PostMapping("/create")
    public ModelAndView createRole(@ModelAttribute Person person) {
        personService.addPerson(person);
        return new ModelAndView("redirect:/person/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditRoleForm(@PathVariable Long id) {
        Person person = personService.getPerson(id);
        return new ModelAndView("persons/edit", "person", person);
    }

    @PutMapping("/update")
    public ModelAndView updateRole(@ModelAttribute Person person) {
        personService.updatePerson(person);
        return new ModelAndView("redirect:/person/all");
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView deleteRole(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ModelAndView("redirect:/person/all");
    }
}
