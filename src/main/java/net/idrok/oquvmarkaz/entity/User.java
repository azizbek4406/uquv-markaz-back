package net.idrok.oquvmarkaz.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false, unique = true)
    private String password;

    private Boolean aktiv = false;

    @ElementCollection(targetClass = Lavozim.class, fetch = FetchType.EAGER)
    @CollectionTable
    @JoinTable(name = "user_lavozimlar", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "lavozim", nullable = false)
    private Set<Lavozim> lavozimlar;

    public User() {
    }

    public User(Long id, String login, String password, Boolean aktiv, Set<Lavozim> lavozimlar) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.aktiv = aktiv;
        this.lavozimlar = lavozimlar;
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

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }

    public Set<Lavozim> getLavozimlar() {
        return lavozimlar;
    }

    public void setLavozimlar(Set<Lavozim> lavozimlar) {
        this.lavozimlar = lavozimlar;
    }
}