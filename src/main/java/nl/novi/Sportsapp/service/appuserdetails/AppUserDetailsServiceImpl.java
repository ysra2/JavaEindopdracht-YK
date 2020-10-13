package nl.novi.Sportsapp.service.appuserdetails;

import nl.novi.Sportsapp.model.AppUserSport;
import nl.novi.Sportsapp.repository.AppUserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {

    AppUserSportRepository appUserSportRepository;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserSportRepository userRepository) {
        this.appUserSportRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUserSport user = appUserSportRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + email));
        return AppUserDetailsImpl.build(user);
    }
}
