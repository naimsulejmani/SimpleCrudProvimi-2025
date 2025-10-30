package dev.naimsulejmani.detyrprovimi1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
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

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/new")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/new";
    }

    @PostMapping("/new")
    public String saveCategory(@ModelAttribute Category category) {
        categories.add(category);
        return "redirect:/categories";
    }


    @GetMapping("/{id}/edit")
    public String newCategory(@PathVariable int id, Model model) {
        //JAVA Streams
//        var category = categories.stream().filter(c -> c.getId() == id).findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + id));
        Category category = null;
        for(Category c : categories) {
            if(c.getId() == id) {
                category = c;
                break;
            }
        }
        if(category == null) {
            throw new IllegalArgumentException("Invalid category id: " + id);
        }


        model.addAttribute("category", category);
        return "category/new";
    }

}
