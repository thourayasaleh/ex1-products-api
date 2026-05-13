package com.thouraya.ex1_products_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thouraya.ex1_products_api.service.ProductService;

@Controller
public class ProductViewController {

    @Autowired
    private ProductService service;

    @GetMapping("/products-view")
    public String viewProducts(Model model) {

        model.addAttribute("products", service.getAllProducts());

        return "products";
    }
}
