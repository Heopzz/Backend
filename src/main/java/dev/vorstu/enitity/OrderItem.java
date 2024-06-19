package dev.vorstu.enitity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table (name = "ordersItem")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private Double price;

    @ManyToMany
    @JoinTable(
            name = "orders_items_goods",
            joinColumns = @JoinColumn(name = "orders_items_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    private Set<Goods> goodsList = new HashSet<>();

}
