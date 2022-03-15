package kz.sdu.edu.diploma.dto;


import kz.sdu.edu.diploma.entities.Categories;
import kz.sdu.edu.diploma.entities.Items;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainDto {
    private List<Items> items;
    private List<Categories> categories;
    private String userName;
}
