package seleznov.demo.rest.view;

import seleznov.demo.rest.model.enums.UserRoleEnum;

import java.io.Serializable;

/**
 * Created by illcko
 */
public class PersonView implements Serializable {

    private long id;

    private String login;

    private String name;

    private UserRoleEnum role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
