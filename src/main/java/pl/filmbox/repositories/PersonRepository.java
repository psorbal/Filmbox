package pl.filmbox.repositories;

import pl.filmbox.models.Person;

import java.util.List;

public interface PersonRepository {
    void addPerson(Person person);
    Person updatePerson(Person person);
    Person getPerson(Long personId);
    List<Person> getAllPersons();
    void deletePerson(Long personId);
}
