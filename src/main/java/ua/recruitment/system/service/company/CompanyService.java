package ua.recruitment.system.service.company;

import ua.recruitment.system.domain.Company;

import java.util.List;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
public interface CompanyService {

    void registerCompany(String name, String description);

    List<Company> getCompanies();
}
