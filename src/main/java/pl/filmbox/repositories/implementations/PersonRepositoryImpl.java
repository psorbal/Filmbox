package pl.filmbox.repositories.implementations;

import org.springframework.stereotype.Repository;
import pl.filmbox.models.Person;
import pl.filmbox.repositories.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPerson(Person person) {
        entityManager.merge(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return entityManager.merge(person);
    }

    @Override
    public Person getPerson(Long personId) {
        return entityManager.find(Person.class, personId);
    }

    @Override
    public List<Person> getAllPersons() {
        TypedQuery<Person> typedQuery = entityManager.createQuery(
                "select p from "+ Person.class.getSimpleName() + " p",
                Person.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deletePerson(Long personId) {
        Person person = entityManager.find(Person.class, personId);

        if (person != null)
            entityManager.remove(person);
    }
}
