package com.mateo9x.favburgerapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor

public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        PROTEIN,VEGGIES,CHEESE,SAUCE
    }
}
