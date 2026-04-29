package storage;

import domain.Product;

import java.util.ArrayList;
import java.util.List;

public class MemoryProductStorage implements ProductStorage {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findByUserId(long userId) {
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getUserId() == userId) {
                result.add(product);
            }
        }

        return result;
    }

    @Override
    public boolean delete(long productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
}
