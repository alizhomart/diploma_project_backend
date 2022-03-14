package kz.sdu.edu.diploma.repos;

import kz.sdu.edu.diploma.entities.Role;
import kz.sdu.edu.diploma.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


public interface RoleRepositoryS extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
