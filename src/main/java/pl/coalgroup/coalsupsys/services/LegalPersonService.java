package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.LegalPerson;

public interface LegalPersonService {
    void saveLegalPerson(LegalPerson legalPerson);
    LegalPerson findLegalPersonById(long id);
}
