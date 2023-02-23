package com.geekbrains.controllers;

import com.geekbrains.models.Buyer;
import com.geekbrains.service.BuyerService;
import com.geekbrains.service.OrderService;
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
    private OrderService orderService;

    @Autowired
    public BuyerController(BuyerService buyerService, ProductService productService, OrderService orderService) {
        this.buyerService = buyerService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute("buyer", buyerService.getAll());
        model.addAttribute("product", productService.getAll());
        return "buyer";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        model.addAttribute("buyer",buyerService.findById(id));
        model.addAttribute("buyer_product", productService.getAll());
        model.addAttribute("product", productService.getAll());
        return "buyer_show";
    }
}
