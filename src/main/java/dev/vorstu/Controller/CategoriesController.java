//package dev.vorstu.Controller;
//
//import dev.vorstu.enitity.Categories;
//import dev.vorstu.enitity.Goods;
//import dev.vorstu.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = "/api/categories/", produces = MediaType.APPLICATION_JSON_VALUE)
//public class CategoriesController {
//
//    @Autowired
//    private CategoryService categoryService;
//
//
//
//    @GetMapping("/findAll/")
//    private List<Categories> findAll() {
//        return categoryService.findAll();
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<Categories> findById(@PathVariable Long id) {
//        Optional<Categories> category = categoryService.findById(id);
//        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/create/")
//    public Categories create(@RequestBody Categories categories) {
//        return  categoryService.save(categories);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Categories> update(@PathVariable Long id, @RequestBody Categories categories) {
//        if (!categoryService.findById(id).isPresent()) {
//            return  ResponseEntity.notFound().build();
//        }
//        categories.setId(id);
//        return ResponseEntity.ok(categoryService.save(categories));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (!categoryService.findById(id).isPresent()) {
//            return ResponseEntity.noContent().build();
//        }
//        categoryService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//}
