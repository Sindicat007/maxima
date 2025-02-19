package ru.maxima.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveProduct(Product product) {
        String sql = "INSERT INTO products.products (name, price) VALUES(?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    private boolean saveLogs(Product product, String logMessages) {
        String sql = "INSERT INTO products.logs (id, message) VALUES (?, ?)";
        jdbcTemplate.update(sql, product.getId(), logMessages);
        return true;
    }

    public void update(Product product) {
        String sql = "UPDATE products.products SET name = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getId());
    }

    public void deleteById(int id) {
        if (id == 0) return;
        String sql = "DELETE FROM products.products WHERE id =?";
        jdbcTemplate.update(sql, id);
    }

    public Product findById(int id) {
        if (id == 0) return null;
        String sql = "SELECT * FROM products.products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, productRowMapper(), id);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products.products";
        System.out.println(jdbcTemplate.query(sql, productRowMapper()));
        return jdbcTemplate.query(sql, productRowMapper());
    }

    public List<String> getAllLogs() {
        String sql = "SELECT * FROM products.logs";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("message"));
    }

    public void createProductWithLog(Product product) {
        StringBuilder logMessages = new StringBuilder();
        logMessages.append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()))
                .append(" начало добавления данных")
                .append(System.lineSeparator());
        saveProduct(product);
        logMessages.append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()))
                .append(" данные добавлены");
        if (saveLogs(product, logMessages.toString())) {
            System.out.println("Данные в лог добавлены успешно");
        } else {
            deleteById(product.getId());
            System.out.println("Ошибка при сохранении лога, операция отменена");
        }
    }

    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        );
    }
}
