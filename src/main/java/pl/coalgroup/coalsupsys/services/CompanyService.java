package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.Company;

public interface CompanyService {
    void saveCompany(Company company);
    Company findCompanyById(Long id);
}
