package seleznov.demo.rest.model;

import seleznov.demo.rest.model.enums.UserRoleEnum;

import javax.persistence.*;

/**
 * Created by illcko
 */
@Entity
public class Person {

    public final static String DEFAULT_PASSWORD = "qwerty";

    @Id
    @Column(name = "person_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String login;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
