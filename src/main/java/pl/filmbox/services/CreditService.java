package pl.filmbox.services;

import pl.filmbox.models.Credit;

import java.util.List;

public interface CreditService {
    void addCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit getCredit(Long creditId);
    List<Credit> getAllCredits();
    void deleteCredit(Long creditId);
}
