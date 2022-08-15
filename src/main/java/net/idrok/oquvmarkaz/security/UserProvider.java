package net.idrok.oquvmarkaz.security;

import net.idrok.oquvmarkaz.entity.User;
import net.idrok.oquvmarkaz.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProvider implements UserDetailsService {

    private final UserRepository userRepository;

    public UserProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if(user.isPresent()){
            return new SecUser(user.get());
        }
        throw new UsernameNotFoundException("not found");
    }
}
