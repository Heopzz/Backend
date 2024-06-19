package dev.vorstu.service;

import dev.vorstu.enitity.Goods;
import dev.vorstu.repositories.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;


    public List<Goods> searchGoods(String query) {
        return goodsRepository.findByNameContainingIgnoreCase(query);
    }

    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    public Goods getGoodsById(Long id) {
        return goodsRepository.findById(id).orElseThrow(() -> new RuntimeException("Goods not Found"));

    }
    public  Goods createGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public Goods updateGoods(Long id, Goods goodsDetails) {
        Goods goods = getGoodsById(id);
        goods.setName(goodsDetails.getName());
        goods.setPrice(goodsDetails.getPrice());
        goods.setQuantity(goodsDetails.getQuantity());
        goods.setDescription(goodsDetails.getDescription());
        return goodsRepository.save(goods);

    }

    public void deleteGoods(Long id) {
        goodsRepository.deleteById(id);
    }

}
