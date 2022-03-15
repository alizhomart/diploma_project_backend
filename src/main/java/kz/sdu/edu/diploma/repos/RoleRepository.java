package kz.sdu.edu.diploma.repos;

import kz.sdu.edu.diploma.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(String name);
}
