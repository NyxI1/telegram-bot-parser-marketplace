package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSQLDatabaseInitializer {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/price_tracker";
    private static final String USER = "user";
    private static final String PASSWORD = "";

    public void init() {
        String sql = """
                CREATE TABLE IF NOT EXISTS products (
                    id BIGINT PRIMARY KEY,
                    user_id BIGINT NOT NULL,
                    title TEXT NOT NULL,
                    url TEXT NOT NULL,
                    marketplace TEXT NOT NULL,
                    target_price INTEGER NOT NULL,
                    last_price INTEGER NOT NULL
                );
                """;

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS products");
            statement.execute(sql);
            System.out.println("PostgreSQL database initialized");

        } catch (SQLException e) {
            System.out.println("PostgreSQL database initialization failed");
            e.printStackTrace();
        }
    }
}
