package pl.filmbox.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.filmbox.models.Credit;
import pl.filmbox.repositories.CreditRepository;
import pl.filmbox.services.CreditService;

import java.util.List;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {

    private CreditRepository creditRepository;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public void addCredit(Credit credit) {
        creditRepository.addCredit(credit);
    }

    @Override
    public Credit updateCredit(Credit credit) {
        return creditRepository.updateCredit(credit);
    }

    @Override
    public Credit getCredit(Long creditId) {
        return creditRepository.getCredit(creditId);
    }

    @Override
    public List<Credit> getAllCredits() {
        return creditRepository.getAllCredits();
    }

    @Override
    public void deleteCredit(Long creditId) {
        creditRepository.deleteCredit(creditId);
    }
}
