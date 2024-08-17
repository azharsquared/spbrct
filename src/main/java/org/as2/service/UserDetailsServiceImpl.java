package org.as2.service;

import org.as2.domain.AppUser;
import org.as2.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Both of the following implementations are correct
        //        AppUser appUser = appUserRepository.findByUsername(username);
        //        if (appUser == null) {
        //            throw new UsernameNotFoundException("User not found");
        //        }
        //        return User.builder().username(appUser.getUsername())
        //                .password(appUser.getPassword())
        //                .roles(appUser.getRole()).build();

        Optional<AppUser> user = appUserRepository.findByUsername(username);
        User.UserBuilder builder = null;
        if (user.isPresent()) {
            AppUser currentUser = user.get();
            builder = User.withUsername(username);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
