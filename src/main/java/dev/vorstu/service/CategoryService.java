//package dev.vorstu.service;
//
//import dev.vorstu.enitity.Categories;
//import dev.vorstu.enitity.Goods;
//import dev.vorstu.repositories.CategoriesRepository;
//import dev.vorstu.repositories.GoodsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryService {
//
//
//
//    @Autowired
//    private CategoriesRepository categoriesRepository;
//
//    public List<Categories> findAll() {
//        return categoriesRepository.findAll();
//    }
//
//    public Optional<Categories> findById(Long id) {
//        return categoriesRepository.findById(id);
//    }
//
//    public  Categories save(Categories categories) {
//        return categoriesRepository.save(categories);
//    }
//
//    public void deleteById(Long id ) {
//        categoriesRepository.deleteById(id);
//    }
//}
