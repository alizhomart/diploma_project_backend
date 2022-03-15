package kz.sdu.edu.diploma.controllers;


import kz.sdu.edu.diploma.dto.MainDto;
import kz.sdu.edu.diploma.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
@Slf4j
@RequiredArgsConstructor
public class MainController {
    @Autowired
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
}
