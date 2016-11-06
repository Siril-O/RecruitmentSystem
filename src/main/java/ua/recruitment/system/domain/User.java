package ua.recruitment.system.domain;

import javax.management.relation.Role;
import javax.persistence.*;

/**
 * Created by KIRIL on 06.11.2016.
 */

@NamedQueries({
        @NamedQuery(name = "User.find", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.getTotalCount", query = "SELECT count(u.id) FROM User AS u"),
})
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passwordHash;
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

