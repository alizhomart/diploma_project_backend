package kz.sdu.edu.diploma.service.impl;

import kz.sdu.edu.diploma.entities.Categories;
import kz.sdu.edu.diploma.entities.Items;
import kz.sdu.edu.diploma.repos.CategoryRepository;
import kz.sdu.edu.diploma.repos.ItemRepository;
import kz.sdu.edu.diploma.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Items getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Items saveItem(Items item) {
        return itemRepository.save(item);
    }

    @Override
    public Items addItem(Items item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Items> findAllByNameLikeOrderByPriceAsc(String name) {
        return itemRepository.findAllByNameLikeOrderByPriceAsc(name);
    }

    @Override
    public List<Items> findAllByNameStartingWith(String name) {
        return itemRepository.findAllByNameStartingWith(name);
    }

    @Override
    public List<Items> findAllByCategoriesStartingWith(String name) {
        return itemRepository.findAllByCategoriesStartingWith(name);
    }

    @Override
    public List<Items> findAllByNameLikeOrderByPriceDesc(String name) {
        return itemRepository.findAllByNameLikeOrderByPriceDesc(name);
    }

    @Override
    public List<Items> findAllByNameStartingWithAndPriceBetweenOrderByPriceAsc(String name, double price1, double price2) {
        return itemRepository.findAllByNameStartingWithAndPriceBetweenOrderByPriceAsc(name, price1, price2);
    }

    @Override
    public List<Items> findAllByNameLikeAndPriceBetweenOrderByPriceDesc(String name, double price1, double price2) {
        return itemRepository.findAllByNameLikeAndPriceBetweenOrderByPriceDesc(name, price1, price2);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Categories getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

}
