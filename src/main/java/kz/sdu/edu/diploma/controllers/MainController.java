package kz.sdu.edu.diploma.controllers;


import kz.sdu.edu.diploma.dto.MainDto;
import kz.sdu.edu.diploma.entities.Items;
import kz.sdu.edu.diploma.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";

    @GetMapping(value = "/page")
    public MainDto getAllItems(){
        return MainDto.builder()
                .items(itemService.getAllItems())
                .categories(itemService.getAllCategories())
                .userName("CURRENT_USER")
                .build();
    }

    @GetMapping(value = "/searchByName")
    public List<Items> searchByName(@RequestParam String name){
        return itemService.findAllByNameStartingWith(name);
    }

    @GetMapping(value = "/searchByAuthor")
    public List<Items> searchByAuthor(@RequestParam String author){
        return itemService.findAllByAuthorStartingWith(author);
    }

    @GetMapping(value = "/searchByNameAndOrderStars")
    public List<Items> searchByNameAndOrderStars(@RequestParam String name){
        return itemService.findAllByNameStartingWithOrderByStarsAsc(name);
    }

    @GetMapping(value = "/sortByPriceAsc")
    public List<Items> sortByPriceAsc(@RequestParam String name,
                            @RequestParam(required = false) String priceFrom,
                            @RequestParam(required = false) String priceTo){
        if(priceFrom != null && priceTo != null) return itemService.findAllByNameStartingWithAndPriceBetweenOrderByPriceAsc(name, Double.parseDouble(priceFrom) , Double.parseDouble(priceTo) );
        return itemService.findAllByNameLikeOrderByPriceAsc(name);
    }

    @GetMapping(value = "/sortByPriceDesc")
    public List<Items> sortByPriceDesc(@RequestParam String name,
                                      @RequestParam(required = false) String priceFrom,
                                      @RequestParam(required = false) String priceTo){
        if(priceFrom != null && priceTo != null) return itemService.findAllByNameLikeAndPriceBetweenOrderByPriceDesc(name, Double.parseDouble(priceFrom) , Double.parseDouble(priceTo));
        return itemService.findAllByNameLikeOrderByPriceDesc(name);
    }

    @GetMapping(value = "/sortByCategory")
    public List<Items> sortByCategory(@RequestParam String name){
        return itemService.findAllByCategoriesStartingWith(name);
    }
}
