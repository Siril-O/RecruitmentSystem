package ua.recruitment.system.domain.user;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * Created by KIRIL on 06.11.2016.
 */

@NamedQueries({
        @NamedQuery(name = "User.find", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.getTotalCount", query = "SELECT count(u.id) FROM User AS u"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User AS u WHERE u.email = :email"),
        @NamedQuery(name = "User.countByEmail", query = "SELECT COUNT(u.id) FROM User AS u WHERE u.email = :email"),
})
@Entity
@Table(name = "puser", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String passwordHash;
    @Embedded
    private PersonInfo personInfo;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(final PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }
}

