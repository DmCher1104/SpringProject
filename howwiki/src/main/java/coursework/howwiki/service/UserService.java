package coursework.howwiki.service;

import coursework.howwiki.model.Privelege;
import coursework.howwiki.model.User;
import coursework.howwiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByLogin(s);
    }


    public boolean registration(User user) {
        User userFromDB = loadUserByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setPriveleges(Collections.singleton(new Privelege(10L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
