package ru.maxima.in.memory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.maxima.in.memory.entity.Product;
import ru.maxima.in.memory.service.ProductService;

import java.util.List;

/*
 * Контроллер для продуктов
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products-page";
    }

    @PostMapping
    @ResponseBody
    public Product createProduct(@RequestParam("name") String name, @RequestParam("price") Double price) {
        return productService.createProduct(name, price);
    }
}