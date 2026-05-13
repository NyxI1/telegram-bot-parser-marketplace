import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import database.PostgresSQLDatabaseInitializer;
import domain.Marketplace;
import service.ProductService;
import storage.PostgresSQLProductStorage;
import storage.ProductStorage;

public class Main {

    public static void main(String[] args) {
        new PostgresSQLDatabaseInitializer().init();
        ProductStorage productStorage = new PostgresSQLProductStorage();
        ProductService productService = new ProductService(productStorage);

        productService.addProduct(
                1001,
                "iPhone 15",
                "https://ozon.ru/product/iphone",
                Marketplace.OZON,
                70000
        );


        String url = "jdbc:postgresql://localhost:5432/price_tracker";
        String user = "user";
        String password = "";



        try (Connection connection =
                     DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to PostgreSQL");

        } catch (SQLException e) {

            System.out.println("Connection failed");
            e.printStackTrace();

        }
    }
}