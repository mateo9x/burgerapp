package com.mateo9x.favburgerapp.controllers;

import com.mateo9x.favburgerapp.model.Burger;
import com.mateo9x.favburgerapp.model.Ingredient;
import com.mateo9x.favburgerapp.model.Order;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class HamburgerDesignController {

    @ModelAttribute
    public void addIngredients(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("WOL", "Beaf", Ingredient.Type.PROTEIN),
                new Ingredient("KUR", "Chicken", Ingredient.Type.PROTEIN),
                new Ingredient("SAL", "Salad", Ingredient.Type.VEGGIES),
                new Ingredient("POM", "Tomato", Ingredient.Type.VEGGIES),
                new Ingredient("CHE", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("TOP", "Goude", Ingredient.Type.CHEESE),
                new Ingredient("KET", "Ketchup", Ingredient.Type.SAUCE),
                new Ingredient("MAJ", "Mayonnaise", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Burger());
        return "design";
    }


    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(Order order){
        log.info("Przetwarzanie: " + order);
        return "redirect:/orders/current";
    }
}
