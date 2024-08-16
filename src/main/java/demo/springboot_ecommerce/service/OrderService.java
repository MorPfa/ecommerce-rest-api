package demo.springboot_ecommerce.service;

import demo.springboot_ecommerce.dto.OrderRequest;
import demo.springboot_ecommerce.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
