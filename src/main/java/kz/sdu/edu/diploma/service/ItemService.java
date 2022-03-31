package kz.sdu.edu.diploma.service;


import kz.sdu.edu.diploma.entities.Categories;
import kz.sdu.edu.diploma.entities.Items;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {

    List<Items> getAllItems();
    Items getItem(Long id);
    void deleteItem(Long id);
    Items saveItem(Items item);
    Items addItem(Items item);

    List<Items> findAllByNameLikeOrderByPriceAsc(String name);
    List<Items> findAllByNameLikeOrderByPriceDesc(String name);
    List<Items> findAllByNameStartingWith(String name);
    List<Items> findAllByNameStartingWithAndPriceBetweenOrderByPriceAsc(String name, double price1, double price2);
    List<Items> findAllByNameLikeAndPriceBetweenOrderByPriceDesc(String name, double price1, double price2);
    List<Items> findAllByAuthorStartingWith(String author);
    List<Items> findAllByCategoriesStartingWith(String name);
    List<Items> findAllByNameStartingWithOrderByStarsAsc(String name);

    List<Categories> getAllCategories();
    Categories getCategory(Long id);
}
