package com.microservice.client.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservice.client.beans.OrderBean;
import com.microservice.client.beans.PaymentBean;
import com.microservice.client.beans.ProductBean;
import com.microservice.client.proxies.MicroserviceOrderProxy;
import com.microservice.client.proxies.MicroservicePaymentProxy;
import com.microservice.client.proxies.MicroserviceProduitsProxy;

@Controller
@RequestMapping("/")
public class ClientController {
    private final MicroserviceProduitsProxy microserviceProduitsProxy;
    private final MicroserviceOrderProxy microserviceOrderProxy;
    private final MicroservicePaymentProxy MicroservicePaymentProxy;

    public ClientController(
        MicroserviceProduitsProxy microserviceProduitsProxy,
        MicroserviceOrderProxy microserviceOrderProxy,
        MicroservicePaymentProxy MicroservicePaymentProxy
        ) 
    {
        this.microserviceProduitsProxy = microserviceProduitsProxy;
        this.microserviceOrderProxy = microserviceOrderProxy;
        this.MicroservicePaymentProxy = MicroservicePaymentProxy;
    }

    /**
     * Handles HTTP GET requests to the root URL, displaying the product list page.
     *
     * @param model the Spring Model object used to store data for the view
     * @return the name of the view to be rendered, "Accueil"
     */
    @GetMapping
    public String accueil(Model model) {
        List<ProductBean> products = microserviceProduitsProxy.getProducts();
        model.addAttribute("products", products);
        return "Accueil";
    }

    /**
     * Retrieves the details of a product by its ID and adds it to the model.
     *
     * @param  model  the Spring Model object used to store data for the view
     * @param  id     the ID of the product to retrieve
     * @return        the name of the view to be rendered, "FicheProduit"
     */
    @GetMapping("/details-product/{id}")
    public String getProductDetails(Model model, @PathVariable("id") String id) {
        ProductBean product = microserviceProduitsProxy.getProductByUuid(id);
        model.addAttribute("product", product);
        return "FicheProduit";
    }

    /**
     * Handles HTTP GET requests to order a product by its ID and amount.
     *
     * @param model   the Spring Model object used to store data for the view
     * @param id      the ID of the product to order
     * @param amount  the amount of the product to order
     * @return        the name of the view to be rendered, "CommanderProduit"
     */
    @GetMapping("/details-product/order-product/{id}/{amount}")
    public String orderProduct(Model model, @PathVariable("id") String id, @PathVariable("amount") BigDecimal amount) {

        OrderBean orderBean = new OrderBean();
        orderBean.setProducts(List.of(microserviceProduitsProxy.getProductByUuid(id)));
        orderBean.setQuantity(1);
        orderBean.setOrderDate(Instant.now());
        OrderBean orderCreated = microserviceOrderProxy.createOrder(orderBean);

        model.addAttribute("order", orderCreated);
        model.addAttribute("amount", amount);
        return "CommanderProduit";
    }

    @GetMapping("/details-product/paid-order/{id}/{amount}")
    public String paidOrder(Model model, @PathVariable("id") String orderId, @PathVariable("amount") BigDecimal amount) {
        PaymentBean paymentBean = new PaymentBean();
        paymentBean.setOrderId(microserviceOrderProxy.getOrder(orderId));
        paymentBean.setCost(amount);
        paymentBean.setCardNumber(generateRandomCardNumber());

        ResponseEntity<PaymentBean> paymentCreated = MicroservicePaymentProxy.createPayment(paymentBean);

        if (paymentCreated.getStatusCode() == HttpStatus.CREATED) {
            microserviceOrderProxy.updateOrder(paymentCreated.getBody().getOrderId().getUuid());
        }
        model.addAttribute("payment", paymentCreated);

        return "payé";

    }

    public Long generateRandomCardNumber() {
        return ThreadLocalRandom.current().nextLong(1000000000000000L, 9999999999999999L);
    }
}
