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
    @NotNull(message = "around 3 to 125 characters")
    @Min(value = 0,message = "Bigger 0")
    private double acreage;
    @NotNull
    @Min(value = 0,message = "Bigger 0")
    private double population;
    @NotNull
    @Min(value = 0,message = "Bigger 0")
    private double GDP;
    @NotNull
    private String description;
    @ManyToOne
    private Nation nation;
}
