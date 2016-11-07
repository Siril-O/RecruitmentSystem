package ua.recruitment.system.domain.user;

import ua.recruitment.system.domain.Company;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Entity
@DiscriminatorValue(value = "RECRUITER")
public class Recruiter extends User {


    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }
}
