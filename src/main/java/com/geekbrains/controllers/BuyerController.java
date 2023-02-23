package com.geekbrains.controllers;

import com.geekbrains.service.BuyerService;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
    private BuyerService buyerService;
    private ProductService productService;

    @Autowired
    public BuyerController(BuyerService buyerService, ProductService productService) {
        this.buyerService = buyerService;
        this.productService = productService;
    }

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute("buyer", buyerService.getAll());
        model.addAttribute("product", productService.getAll());
        return "buyer";
    }

}
