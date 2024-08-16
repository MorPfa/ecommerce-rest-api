package demo.springboot_ecommerce.service.impl;

import demo.springboot_ecommerce.dto.OrderRequest;
import demo.springboot_ecommerce.dto.OrderResponse;
import demo.springboot_ecommerce.entity.Order;
import demo.springboot_ecommerce.entity.Payment;
import demo.springboot_ecommerce.exception.PaymentException;
import demo.springboot_ecommerce.repository.OrderRepository;
import demo.springboot_ecommerce.repository.PaymentRepository;
import demo.springboot_ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("In progress");
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type not supported");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Success");
        return orderResponse;
    }
}
