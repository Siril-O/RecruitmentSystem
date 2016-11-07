package ua.recruitment.system.configuration.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.recruitment.system.domain.user.User;
import ua.recruitment.system.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by KIRIL on 07.11.2016.
 */
@Component("userDetailsService")
public class DBUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DBUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String email) {

        User userFromDatabase = userRepository.findByUserEmail(email);

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userFromDatabase.getRole().toString());
        grantedAuthorities.add(grantedAuthority);

        return new org.springframework.security.core.userdetails.User(email, userFromDatabase.getPasswordHash(),
                true, true, true, true, grantedAuthorities);
    }
}
