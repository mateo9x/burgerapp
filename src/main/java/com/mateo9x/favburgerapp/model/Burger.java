package com.mateo9x.favburgerapp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Burger {

    @NotNull
    private String name;
 //   @Size(min=1, message="You must choose at least 1 ingredient")
    private List<String> ingredients;
}
