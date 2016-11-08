package ua.recruitment.system.domain;

import ua.recruitment.system.domain.user.Recruiter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by KIRIL on 06.11.2016.
 */
@NamedQueries({
        @NamedQuery(name = "Company.find", query = "SELECT c FROM Company AS c"),
        @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company AS c WHERE c.name=:name"),
        @NamedQuery(name = "Company.getTotalCount", query = "SELECT count(c.id) FROM Company AS c"),
})

@Entity
@Table(name = "company", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST})
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
