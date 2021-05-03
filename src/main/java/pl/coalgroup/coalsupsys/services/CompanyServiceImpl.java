package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.Company;
import pl.coalgroup.coalsupsys.repositories.CompanyRepository;

public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id) {

        return companyRepository.getOne(id);
    }
}
