package storage;

import domain.Product;
import java.util.List;
import domain.Marketplace;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresSQLProductStorage implements ProductStorage {

    private static final String DB_URL =
            System.getenv().getOrDefault(
                    "DB_URL",
                    "jdbc:postgresql://localhost:5432/price_tracker"
            );

    private static final String USER =
            System.getenv().getOrDefault("DB_USER", "user");

    private static final String PASSWORD =
            System.getenv().getOrDefault("DB_PASSWORD", "1234");

    @Override
    public void save(Product product) {
        String sql = """
        INSERT INTO products (
            id,
            user_id,
            title,
            url,
            marketplace,
            target_price,
            last_price
        )
        VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, product.getId());
            statement.setLong(2, product.getUserId());
            statement.setString(3, product.getTitle());
            statement.setString(4, product.getUrl());
            statement.setString(5, product.getMarketplace().name());
            statement.setInt(6, product.getTargetPrice());
            statement.setInt(7, product.getLastPrice());

            statement.executeUpdate();

            System.out.println("Product saved to DataBase");

        } catch (SQLException e) {
            System.out.println("Failed to save product to DataBase");
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findByUserId(long userId) {
        return List.of();
    }

    @Override
    public boolean delete(long productId) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
