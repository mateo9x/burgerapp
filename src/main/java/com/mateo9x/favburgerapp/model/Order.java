package com.mateo9x.favburgerapp.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class Order {


    private String name;
    private String surname;
    private String city;
    private String zip;

}
