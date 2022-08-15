package net.idrok.oquvmarkaz.service.dto;

import net.idrok.oquvmarkaz.entity.Lavozim;
import net.idrok.oquvmarkaz.entity.User;

import java.util.Set;

public class UserDTO2 {
    private Long id;
    private String login;
    private String password;
    private Set<Lavozim> lavozim;

    public UserDTO2() {
    }

    public UserDTO2(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.lavozim = user.getLavozimlar();
    }

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

    public Set<Lavozim> getLavozim() {
        return lavozim;
    }

    public void setLavozim(Set<Lavozim> lavozim) {
        this.lavozim = lavozim;
    }
}
