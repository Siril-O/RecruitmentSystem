package ua.recruitment.system.domain;

import ua.recruitment.system.domain.user.Recruiter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by KIRIL on 06.11.2016.
 */
@NamedQueries({
        @NamedQuery(name = "Company.find", query = "SELECT c FROM Company AS c"),
        @NamedQuery(name = "Company.getTotalCount", query = "SELECT count(c.id) FROM Company AS c"),
})

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "company")
    private List<Recruiter> recruiters;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(final List<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }
}
