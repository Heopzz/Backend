package dev.vorstu;


import dev.vorstu.enitity.*;


import dev.vorstu.repositories.GoodsRepository;
import dev.vorstu.repositories.OrdersItemRepository;
import dev.vorstu.repositories.OrdersRepository;
import dev.vorstu.repositories.UserRepository;
import javafx.collections.ObservableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Component
public class Initializer {


@Autowired
private OrdersRepository ordersRepository;

@Autowired
private GoodsRepository goodsRepository;

@Autowired
private  UserRepository userRepository;

@Autowired
private OrdersItemRepository ordersItemRepository;






    public void initial() {






//        goodsRepository.save(new Goods(
//                1L,
//                21499L,
//                "Процессор Intel Core i5-12500 имеет 6 ядер, базовую частоту 3 ГГц и максимальную частоту в турборежиме 4,6 ГГц. Процессор оснащён интегрированным видеоядром Intel UHD Graphics 770, поддерживает режимы DDR4 и DDR5 и максимальный объём ОЗУ 128 гигабайт.",
//                "Процессор Intel Core i5-12500",
//                2L,
//                "https://c.dns-shop.ru/thumb/st4/fit/wm/0/0/74bfeae7e1423cd82d25fa578212cd88/64075dd78c1fe415a548d7a250b4599305e0452526eea6e9a745a20c57d88f49.jpg.webp"
//
//
//
//
//
//        ));
//
//        goodsRepository.save(new Goods(
//                2L,
//                1300L,
//                "6-ядерный процессор AMD Ryzen 5 4600G OEM имеет наличие интегрированного графического ядра AMD Radeon Vega 7. Устройство позволяет обойтись без видеокарты, а производительности встроенной графики хватает для игр начального уровня и просмотра видео.",
//                "Процессор AMD Ryzen 5 4600G OEM",
//                1L,
//                "https://c.dns-shop.ru/thumb/st1/fit/wm/0/0/e60fe6c458f3a8cda2b95ddab4c0584b/1edbd2efc63d2a9743d485662dbf9abe2934463b0789ebbafc2bccf103e18dbf.jpg.webp"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                3L,
//                15290L,
//                "Материнская плата ASRock B760 Pro RS/D4 обладает эффективным охлаждением компонентов. Включает четыре слота с поддержкой стандарта DDR4, три слота расширения PCI-E x16, три разъёма M.2 и четыре разъёма SATA для накопителей.",
//                "Материнская плата 1700 ASRock B760 PRO RS/D4",
//                1L,
//                "https://cdn.citilink.ru/A9j54qXwt0ZlryDClfkuf7tNCh2wFHAJfWlyagoB8uY/resizing_type:fit/gravity:sm/width:1200/height:1200/plain/product-images/9625e82d-dc1e-41e1-9121-208b73ba1fb2.jpg"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                4L,
//                9500L,
//                "Материнская плата MSI B450 GAMING PLUS MAX соответствует форм-фактору Standard-ATX и использует процессоры AMD AM4. Технология CrossFire X позволяет использовать до двух видеокарт одновременно.",
//                "Материнская плата AM4 MSI B450 GAMING PLUS MAX",
//                1L,
//                "https://cdn.citilink.ru/2LSL8zoZPMzf0DQ-xkpP0EU1xi_msdhEzemBbwQNQqw/resizing_type:fit/gravity:sm/width:1200/height:1200/plain/product-images/0d810b65-9262-484c-a6d5-1f6b33c1b15f.jpg"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                5L,
//                5990L,
//                "Оперативная память Patriot Viper Steel RGB с подсветкой RGB — надёжное дополнение для игрового компьютера. Обеспечивает быстродействие благодаря частоте 3600 МГц, низким задержкам и эффективным радиаторам.",
//                "Оперативная память Patriot Viper Steel RGB 16GB (2*8Гб)",
//                1L,
//                "https://cdn.citilink.ru/oyva09x6Ec_SdljgXhzIZackRf05UizjZtY_JDODJHI/resizing_type:fit/gravity:sm/width:1200/height:1200/plain/product-images/5d61bfdb-a2a3-4722-8429-d7a2571dcd07.jpg"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                6L,
//                9500L,
//                "Оперативная память Kingston FURY Beast Black RGB разработана для мощных игровых ПК. Она имеет алюминиевый радиатор с оригинальным дизайном и акриловую планку со светодиодной подсветкой RGB. Модуль памяти работает на частоте 3200 МГц.",
//                "Оперативная память Kingston FURY Beast Black RGB 16Гб",
//                1L,
//                "https://avatars.mds.yandex.net/get-goods_pic/12268492/hat365686e11107e1bc991c374be2b653de/600x600"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                7L,
//                29636L,
//                "Видеокарта Palit GeForce RTX 3060 DUAL OC (LHR) оснащена мощным видеопроцессором и 12 ГБ памяти, что позволяет легко решать различные задачи. Видеокарта также поддерживает трассировку лучей для создания реалистичного изображения в играх.",
//                "Видеокарта GeForce RTX3060",
//                1L,
//                "https://avatars.mds.yandex.net/get-goods_pic/6271614/hat2b63f759ad8614c6d37440b0ed1ecf01/600x600"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                8L,
//                9400L,
//                "Видеокарта PowerColor AMD Radeon RX 580 Red Dragon отличный выбор для игровых систем и рабочих станций. Её микроархитектура AMD GCN и 8 ГБ памяти GDDR5 обеспечивают стабильность и плавность игрового процесса, а частота процессора составляет 1257–1350 МГц.",
//                "Видеокарта Radeon RX580",
//                1L,
//                "https://c.dns-shop.ru/thumb/st1/fit/wm/0/0/ad9e6fe3973f41fb843e7264127d622a/3f571f81fefcdd1c88244af9804e99189589f563ee5e0c30f3b0c6c437ad980c.jpg.webp"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                9L,
//                20799L,
//                "4 ТБ жёсткий диск WD Gold предназначен для ЦОД, RAID-массивов и NAS. Он выдерживает нагрузку (до 550 ТБ в год) и оснащён кэшем 128 МБ для быстрой записи и копирования. Диск защищён от вибраций, весит 715 г. Подключается через интерфейс SATA III.",
//                "Жесткий диск 3.5 SATA 4Tb WD Gold WD4002FYYZ",
//                1L,
//                "https://c.dns-shop.ru/thumb/st1/fit/wm/0/0/b91506fa205dcd25af7477efc8b802af/4c8721f4bb20a6eb2ec60ef48c194a492a5014ed6366c7c3d79fdff90acedc5a.jpg.webp"
//
//
//        ));
//        goodsRepository.save(new Goods(
//                10L,
//                3999L,
//                "SSD M.2 накопитель ADATA LEGEND 700 объёмом 512 ГБ совместим с различными компьютерами. Он использует интерфейс PCI-E 3.x x4 и обеспечивает высокую скорость чтения и записи: до 2000 и 1600 МБ/с соответственно. Комплектный радиатор защищает от перегрева.",
//                "512 ГБ SSD M.2 накопитель ADATA LEGEND 700",
//                1L,
//                "https://c.dns-shop.ru/thumb/st4/fit/wm/0/0/afe077224f699717e3a549900a4dc8e9/11dbbacbc4f3742ab5390bbde6a1f878811ff0c8318bf3dd86366d396d15140e.jpg.webp"
//
//
//        ));
//
//
//
//
//        userRepository.save(new User(
//                1L,
//                "name",
//                Role.USER,
//                new Password("1234"),
//                true
//        ));
//        userRepository.save((new User(
//                2L,
//                "admin",
//                Role.ADMIN,
//                new Password("admin"),
//                true
//        )));
//        userRepository.save((new User(
//                3L,
//                "adrei",
//                Role.USER,
//                new Password("123"),
//                true
//        )));
    }
}
