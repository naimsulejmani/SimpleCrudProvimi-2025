package dev.naimsulejmani.detyrprovimi1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category(1, "Food", "FOODS"));
        categories.add(new Category(2, "Drink", "DRINKS"));
        categories.add(new Category(3, "Clothes", "CLOTHES"));
        categories.add(new Category(4, "Electronics", "ELECTRONICS"));
        categories.add(new Category(5, "Jewelry", "JEWELRY"));
        categories.add(new Category(6, "Sports", "SPORTS"));
        categories.add(new Category(7, "Other", "OTHER"));
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("categories", categories);
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false, defaultValue = "1") Integer categoryId,
                         @RequestParam(required = false) String searchText) {

        System.out.println("Id: " + categoryId);
        System.out.println("Search text: " + searchText);
        return "redirect:/";
    }

    @GetMapping("/contact")
    public ModelAndView contact() {
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("name", "Naim");
        modelAndView.addObject("email", "naim.sulejmani@gmail.com");
        return modelAndView;
    }
}


