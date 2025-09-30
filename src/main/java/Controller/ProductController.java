package Controller;

import java.util.*;

import Entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form(Model model) {
        // Đây là product để binding với form
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        // Sau khi Save, product được binding giá trị người nhập
        model.addAttribute("product", p);
        return "product/form";
    }

    /*?3*/
    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.1),
                new Product("B", 1.2)
        );
    }
}

