package storage;

import domain.Product;
import java.util.List;

public interface    ProductStorage {

    void save(Product product);

    List<Product> findByUserId(long userId);

    boolean delete(long productId);

    List<Product> findAll();
}
