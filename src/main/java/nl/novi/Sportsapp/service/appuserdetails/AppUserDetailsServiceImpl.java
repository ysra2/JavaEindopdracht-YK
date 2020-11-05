package nl.novi.Sportsapp.service.appuserdetails;

import nl.novi.Sportsapp.model.UserSports;
import nl.novi.Sportsapp.repository.UserSportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {

    UserSportsRepository userSportsRepository;

    @Autowired
    public AppUserDetailsServiceImpl(UserSportsRepository userRepository) {
        this.userSportsRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserSports user = userSportsRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + email));
        return AppUserDetailsImpl.build(user);
    }
}

