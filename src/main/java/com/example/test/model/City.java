package com.example.test.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class City {
//    User(id,user,pass,fullname,phone,email,avatar
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 3, max = 125,message = "around 3 to 125 characters")
    private String city_name;
    @NotNull
    @Min(0)
    private String acreage;
    @NotNull
    @Min(0)
    private String population;
    @NotNull
    @Min(0)
    private String GDP;
    @NotNull
    private String description;
    @ManyToOne
    private Nation nation;
}
