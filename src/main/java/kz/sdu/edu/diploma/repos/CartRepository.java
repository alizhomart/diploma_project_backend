package kz.sdu.edu.diploma.repos;

import kz.sdu.edu.diploma.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Carts, Long> {
}
