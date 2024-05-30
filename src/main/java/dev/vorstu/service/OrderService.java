package dev.vorstu.service;

import dev.vorstu.enitity.Orders;
import dev.vorstu.enitity.User;
import dev.vorstu.repositories.OrdersRepository;
import dev.vorstu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

//    public  Orders createOrder(Long userId, List<OrderItemDTO> orderItems) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        Orders orders = new Orders();
//        orders.setUser(user);
//        orders.getOrderDate(L
//    }


    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public List<Orders> findByUserId(Long userid) {
        return ordersRepository.findByUserId(userid);

    }

    public Optional<Orders> findById(Long id) {
        return  ordersRepository.findById(id);
    }

    @Transactional
    public  Orders saveOrder(Orders orders, Long userId) {
        double total = orders.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        orders.setTotal(total);
        orders.setUser(userRepository.findById(userId).get());
        return ordersRepository.save(orders);


    }

    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }


}
