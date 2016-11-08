package ua.recruitment.system.repository;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.repository.util.CrudRepository;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
public interface CompanyRepository extends CrudRepository<Company> {

    Company findByName(String name);
}
