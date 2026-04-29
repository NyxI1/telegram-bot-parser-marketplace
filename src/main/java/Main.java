import domain.Marketplace;
import domain.Product;
import service.ProductService;
import storage.MemoryProductStorage;
import storage.ProductStorage;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductStorage productStorage = new MemoryProductStorage();

        ProductService productService = new ProductService(productStorage);

        productService.addProduct(
                1001,
                "iPhone 15",
                "https://ozon.ru/product/iphone",
                Marketplace.OZON,
                70000
        );

        productService.addProduct(
                1001,
                "AirPods",
                "https://market.yandex.ru/product/airpods",
                Marketplace.YANDEX_MARKET,
                12000
        );

        List<Product> products = productService.getUserProducts(1001);

        for (Product product : products) {
            System.out.println(product);
        }
    }
}