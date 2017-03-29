package pl.filmbox.repositories.implementations;

import org.springframework.stereotype.Repository;
import pl.filmbox.models.Credit;
import pl.filmbox.repositories.CreditRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CreditRepositoryImpl implements CreditRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCredit(Credit credit) {
        entityManager.merge(credit);
    }

    @Override
    public Credit updateCredit(Credit credit) {
        return entityManager.merge(credit);
    }

    @Override
    public Credit getCredit(Long creditId) {
        return entityManager.find(Credit.class, creditId);
    }

    @Override
    public List<Credit> getAllCredits() {
        TypedQuery<Credit> typedQuery = entityManager.createQuery(
                "SELECT a FROM " + Credit.class.getSimpleName() + " a",
                Credit.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public void deleteCredit(Long creditId) {
        Credit credit = entityManager.find(Credit.class, creditId);
        if (credit != null) {
            entityManager.remove(credit);
        }
    }
}
