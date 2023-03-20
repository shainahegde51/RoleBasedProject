package com.example.RoleBasedProject.Service;

import com.example.RoleBasedProject.Entity.User;
import com.example.RoleBasedProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //This method is all about loading the user with his/her username ,
    // where we need to include one function called findByUsername in repository
    // which will help this function to load the username
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        //we have to pass data back as UserDetails ,So we have to implement UserDetails as well
        //Inside this UserDetails we can leverage this particular user that we are getting


        return new CustomUserDetails(user);

    }

    public void createUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        user.setRole(user.getRole());
        user.setId(user.getId());
        userRepository.save(user);
    }
}
