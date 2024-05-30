package dev.vorstu.Controller;


import dev.vorstu.enitity.Orders;
import dev.vorstu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)

public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public List<Orders> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/findByUserId/{userid}")
    public List<Orders> findByUserID(@PathVariable("userid") Long userid) {
        return  orderService.findByUserId(userid);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Long id ) {
        Optional<Orders> orders = orderService.findById(id);
        if (orders.isPresent()) {
            return  ResponseEntity.ok(orders.get());
        }
        else
        {
            return  ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/create")
//    public ResponseEntity<Orders> create(@PathVariable Long id, @RequestBody Orders orders) {
//        Orders savedOrder = orderService.save(orders);
//        return ResponseEntity.status(201).body(savedOrder);
//    }

    @PostMapping("/create/{id}")
    public ResponseEntity<Orders> createOrder(@PathVariable("id") Long userId,  @RequestBody Orders orders) {
        Orders savedOrders = orderService.saveOrder(orders, userId);
        return ResponseEntity.ok(savedOrders);

    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Orders> update(@PathVariable Long id, @RequestBody Orders orders) {
//        if (!orderService.findById(id).isPresent()) {
//            return  ResponseEntity.notFound().build();
//        }
//        orders.setId(id);
//        return ResponseEntity.ok(orderService.saveOrder(orders));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!orderService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
