package demo.springboot_ecommerce.dto;

import demo.springboot_ecommerce.entity.Order;
import demo.springboot_ecommerce.entity.Payment;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
