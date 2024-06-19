package dev.vorstu.repositories;

import dev.vorstu.enitity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>  {

    List<Goods> findByNameContainingIgnoreCase(String name);


@Query("SELECT p FROM Goods p")
    List<Goods> getAllGoods();

}
