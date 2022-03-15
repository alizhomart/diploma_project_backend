package kz.sdu.edu.diploma.service.impl;

import kz.sdu.edu.diploma.entities.Roles;
import kz.sdu.edu.diploma.entities.Users;
import kz.sdu.edu.diploma.repos.RoleRepository;
import kz.sdu.edu.diploma.repos.UserRepository;
import kz.sdu.edu.diploma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(s).orElse(null);

        if(user != null) return user;
        else throw new UsernameNotFoundException("User not found!!! ");
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUser(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Users addUser(Users user) {
        Users checkUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(checkUser==null){
            Roles role = roleRepository.findByName("ROLE_USER").orElse(null);
            if (checkForNull(user, role)) return userRepository.save(user);
        }
        return null;
    }

    @Override
    public Users addUser(Users user, String r) {
        Users checkUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(checkUser==null){
            Roles role = roleRepository.findByName(r).orElse(null);
            if (checkForNull(user, role)) return userRepository.save(user);
        }
        return null;
    }

    private boolean checkForNull(Users user, Roles role) {
        if(role!=null){
            Set<Roles> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
