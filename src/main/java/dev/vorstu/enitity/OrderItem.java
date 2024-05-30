package dev.vorstu.enitity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false)
//    private Orders orders;

//    @ManyToOne
//    @JoinColumn(name = "goods_id", nullable = false)
//    private Goods goods;

    private int quantity;
    private Double price;

}
