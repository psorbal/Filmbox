package pl.filmbox.repositories;

import pl.filmbox.models.Credit;

import java.util.List;

public interface CreditRepository {
    void addCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit getCredit(Long creditId);
    List<Credit> getAllCredits();
    void deleteCredit(Long creditId);
}
