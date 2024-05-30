package dev.vorstu.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "imageUrl")
    private  String imageUrl;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "categories_id", nullable = false)
//    private Categories categories;
//    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Image> images;
}
