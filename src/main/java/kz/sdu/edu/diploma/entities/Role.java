package kz.sdu.edu.diploma.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles_test")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;
}
