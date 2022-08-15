package net.idrok.oquvmarkaz.config;

import net.idrok.oquvmarkaz.entity.Lavozim;
import net.idrok.oquvmarkaz.entity.User;
import net.idrok.oquvmarkaz.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
public class InitDB {
    private final UserRepository userRepository;

    public InitDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void DB() {
        if(!userRepository.findByLogin("admin").isPresent()) {
            User u = new User();
            u.setLogin("admin");
            u.setPassword("admin123");
            u.setAktiv(true);
            HashSet<Lavozim> role = new HashSet<>();
            role.add(Lavozim.ADMIN);
            u.setLavozimlar(role);
            userRepository.save(u);
        }

        if(!userRepository.findByLogin("director").isPresent()) {
            User u = new User();
            u.setLogin("director");
            u.setPassword("director123");
            u.setAktiv(true);
            HashSet<Lavozim> role = new HashSet<>();
            role.add(Lavozim.DIRECTOR);
            u.setLavozimlar(role);
            userRepository.save(u);
        }
    }
}
