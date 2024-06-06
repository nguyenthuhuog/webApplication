package com.controller;

import com.model.OrderDetail;
import com.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrderDetail getOrderDetailById(@PathVariable int id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @PostMapping
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @PutMapping("/{id}")
    public OrderDetail updateOrderDetail(@PathVariable int id, @RequestBody OrderDetail orderDetail) {
        if (orderDetailRepository.existsById(id)) {
            orderDetail.setOrderDetailID(id);
            return orderDetailRepository.save(orderDetail);
        } else {
            return null; // Or handle as needed
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable int id) {
        orderDetailRepository.deleteById(id);
    }
}
