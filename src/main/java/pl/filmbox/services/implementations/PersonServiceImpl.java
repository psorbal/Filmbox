package pl.filmbox.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.filmbox.models.Person;
import pl.filmbox.repositories.PersonRepository;
import pl.filmbox.services.PersonService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(Person person) {
        personRepository.addPerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.updatePerson(person);
    }

    @Override
    public Person getPerson(Long personId) {
        return personRepository.getPerson(personId);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deletePerson(personId);
    }
}
