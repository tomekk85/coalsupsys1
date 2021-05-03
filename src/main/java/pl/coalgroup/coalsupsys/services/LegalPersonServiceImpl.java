package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.LegalPerson;
import pl.coalgroup.coalsupsys.repositories.LegalPersonRepository;

public class LegalPersonServiceImpl implements LegalPersonService {
    LegalPersonRepository legalPersonRepository;

    public LegalPersonServiceImpl(LegalPersonRepository legalPersonRepository) {
        this.legalPersonRepository = legalPersonRepository;
    }

    @Override
    public void saveLegalPerson(LegalPerson legalPerson) {
        legalPersonRepository.save(legalPerson);
    }

    @Override
    public LegalPerson findLegalPersonById(long id) {
        return legalPersonRepository.getOne(id);
    }
}
