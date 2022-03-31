package kz.sdu.edu.diploma.dto;


import kz.sdu.edu.diploma.entities.Categories;
import kz.sdu.edu.diploma.entities.Images;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String name;
    private double price;
    private String author;
    private String desc;
    private double stars;
    private boolean inStock;
    private Date addedDate;
    private List<Images> imageURL;
    private boolean inTopPage;
    private List<Categories> categories;
}
