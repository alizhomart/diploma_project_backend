package kz.sdu.edu.diploma.repos;

import kz.sdu.edu.diploma.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Items, Long> {
    List<Items> findAllByNameLikeOrderByPriceAsc(String name);
    List<Items> findAllByNameStartingWith(String name);

    List<Items> findAllByCategoriesStartingWith(String name);

    List<Items> findAllByNameLikeOrderByPriceDesc(String name);
    List<Items> findAllByNameStartingWithAndPriceBetweenOrderByPriceAsc(String name, double price1, double price2);
    List<Items> findAllByNameLikeAndPriceBetweenOrderByPriceDesc(String name, double price1, double price2);
}
