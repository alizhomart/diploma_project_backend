package kz.sdu.edu.diploma.service;


import kz.sdu.edu.diploma.entities.Roles;
import kz.sdu.edu.diploma.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    Users updateUser(Users user);
    Users getUser(String email);
    Users addUser(Users user);
    Users addUser(Users user, String role);
    void deleteUser(Long id);
    List<Users> getAllUsers();
    List<Roles> getAllRoles();
}
