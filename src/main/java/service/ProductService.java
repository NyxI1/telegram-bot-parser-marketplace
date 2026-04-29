package service;

import domain.Marketplace;
import domain.Product;
import storage.ProductStorage;

import java.util.List;

public class ProductService {

    private final ProductStorage productStorage;
    private long nextId = 1;

    public ProductService(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public Product addProduct(long userId, String title, String url, Marketplace marketplace, int targetPrice) {
        Product product = new Product(
                nextId,
                userId,
                title,
                url,
                marketplace,
                targetPrice,
                0
        );

        productStorage.save(product);
        nextId++;

        return product;
    }

    public List<Product> getUserProducts(long userId) {
        return productStorage.findByUserId(userId);
    }

    public boolean deleteProduct(long productId) {
        return productStorage.delete(productId);
    }
}
