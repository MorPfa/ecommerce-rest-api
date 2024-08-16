package demo.springboot_ecommerce.repository;

import demo.springboot_ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {

}
