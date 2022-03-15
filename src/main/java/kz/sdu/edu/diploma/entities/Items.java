package kz.sdu.edu.diploma.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "items")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String desc;
    @Column(name = "stars")
    private double stars;
    @Column(name = "inStock")
    private boolean inStock;
    @Column(name = "addedDate")
    private Date addedDate;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Images> imageURL;
    private boolean inTopPage;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Categories> categories;
}
