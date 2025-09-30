package Controller;

import java.util.ArrayList;
import java.util.List;

import Entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class themController {
    // Tạo danh sách 20 sản phẩm mẫu
    private List<Product> buildProducts() {
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new Product("Product " + i, i * 10.0));
        }
        return list;
    }

    @GetMapping("/poly/them")
    public String showPage(
            @RequestParam(name = "pageSize", defaultValue = "5") int pageSize,
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model) {

        List<Product> all = buildProducts();
        int totalItems = all.size();
        if (pageSize <= 0) pageSize = 5;
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        if (totalPages == 0) totalPages = 1;

        // ensure page in [1, totalPages]
        if (page < 1) page = 1;
        if (page > totalPages) page = totalPages;

        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalItems);
        List<Product> pageItems = all.subList(fromIndex, toIndex);

        model.addAttribute("items", pageItems);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        return "them"; // templates/them.html
    }
}
