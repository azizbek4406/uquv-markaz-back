package net.idrok.oquvmarkaz.service.dto;

import net.idrok.oquvmarkaz.entity.User;

public class UserDTO {
    private Long id;
    private String login;


    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.login = user.getLogin();
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
}
