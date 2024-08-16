package com.microservice.client.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservice.client.beans.ProductBean;
import com.microservice.client.proxies.MicroserviceProduitsProxy;

@Controller
@RequestMapping("/")
public class ClientController {
    private final MicroserviceProduitsProxy microserviceProduitsProxy;

    public ClientController(
        MicroserviceProduitsProxy microserviceProduitsProxy
        ) 
    {
        this.microserviceProduitsProxy = microserviceProduitsProxy;
    }

    @GetMapping
    public String accueil(Model model) {
        List<ProductBean> products = microserviceProduitsProxy.getProducts();
        model.addAttribute("products", products);
        return "Accueil";
    }
}
