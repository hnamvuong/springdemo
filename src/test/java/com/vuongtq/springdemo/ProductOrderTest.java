package com.vuongtq.springdemo;

import com.vuongtq.springdemo.entity.OrderEntity;
import com.vuongtq.springdemo.entity.ProductEntity;
import com.vuongtq.springdemo.repository.OrderRepository;
import com.vuongtq.springdemo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    void manyToManyTest() {
        ProductEntity p1 = new ProductEntity();
        ProductEntity p2 = new ProductEntity();

        OrderEntity o1 = new OrderEntity();
        OrderEntity o2 = new OrderEntity();
        OrderEntity o3 = new OrderEntity();

        p1.setProductName("p1");
        p1.setProductPrice(new BigDecimal("2.5"));

        p2.setProductName("p2");
        p2.setProductPrice(new BigDecimal("4.5"));

        o1.setUserId(11);
        o2.setUserId(13);
        o3.setUserId(15);

        p1.setOrderList(List.of(o1, o3));
        p2.setOrderList(List.of(o1, o2, o3));

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

        productRepository.save(p1);
        productRepository.save(p2);
    }

    @Test
    @Transactional
    @Rollback(false)
    void selectManyToManyTest() {
        ProductEntity p1 = productRepository.findById(1L).orElseThrow();
        System.out.println(p1);
        System.out.println(p1.getOrderList());
    }
}
