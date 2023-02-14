package com.geekbrains.controllers;

import com.geekbrains.dao.ProductRepository;
import com.geekbrains.models.Product;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductRepository productRepository;
    private ProductService productService;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts(Model model){
        model.addAttribute("product",productService.getAllProducts());
//        Получим все продукты из DAO и передадим на отображение в представление
        return "index";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        model.addAttribute("product",productService.findById(id));
//        Получим один продукт по его id из DAO и передадим на отображение в представление
        return "show";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }


    @PostMapping
    public String createNewProduct(@ModelAttribute ("product") Product product){
        productService.createNewProduct(product);
        return "redirect:/product";
//        переход на другую страницу(которая указана после двоеточия)
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        productRepository.delete(id);
        return "redirect:/product";
    }
}


