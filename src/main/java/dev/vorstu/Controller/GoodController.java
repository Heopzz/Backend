package dev.vorstu.Controller;


import dev.vorstu.enitity.Goods;
import dev.vorstu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/goods/", produces = MediaType.APPLICATION_JSON_VALUE)


public class GoodController {

    @Autowired
    private GoodsService goodsService;


//    @GetMapping("/categories/{categoriesId}")
//    public ResponseEntity<List<Goods>> getGoodsByCategories(@PathVariable Long categoriesId) {
//        List<Goods> goods = goodsService.findByCategoriesId(categoriesId);
//        if (goods.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        else {
//            return ResponseEntity.ok(goods);
//        }
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Goods>> searchGoods(@RequestParam String query) {
        List<Goods> goods = goodsService.searchGoods(query);
        if (goods.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(goods);
    }



    @GetMapping
    public List<Goods> getAllGoods() {

        return goodsService.getAllGoods();
    }

   @GetMapping("/{id}")
   public Goods getGoodsById(@PathVariable Long id) {
        return goodsService.getGoodsById(id);
   }


    @PostMapping("/add")
    public Goods createGoods(@RequestBody Goods goods) {

        return goodsService.createGoods(goods);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Long id, @RequestBody Goods goodsDetails) {
        Goods updatedGoods = goodsService.updateGoods(id, goodsDetails);
        return ResponseEntity.ok(updatedGoods);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        goodsService.deleteGoods(id);
        return  ResponseEntity.noContent().build();
    }


}
