package com.mateo9x.favburgerapp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
public class Burger {

    private String name;

    private List<String> ingredients;
}
