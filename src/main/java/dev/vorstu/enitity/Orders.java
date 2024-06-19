package dev.vorstu.enitity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table (name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    private Double total;





}
