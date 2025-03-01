package ru.maxima.springjdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static ru.maxima.springjdbc.SqlRequest.*;

@RequiredArgsConstructor
@Repository
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;


    public void saveProduct(Product product) {
        jdbcTemplate.update(SAVE_PRODUCT, product.getName(), product.getPrice());
    }

    public void updateProduct(Product product) {
        jdbcTemplate.update(UPDATE_PRODUCT, product.getName(), product.getPrice(), product.getId());
    }

    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_PRODUCT, id);
    }

    public Product findById(int id) {
        return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, productRowMapper(), id);
    }

    public List<Product> getAllProducts() {
        return jdbcTemplate.query(GET_ALL_PRODUCTS, productRowMapper());
    }


    private int saveLogs(Product product, String logMessages) {
        return jdbcTemplate.update(SAVE_LOG, product.getId(), logMessages);
    }

    public List<String> getAllLogs() {
        return jdbcTemplate.query(GET_LOGS, (rs, rowNum) -> rs.getString("message"));
    }

    @Transactional
    public void createProductWithLog(Product product) {
        StringBuilder logMessages = new StringBuilder();
        logMessages.append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()))
                .append(" начало добавления данных")
                .append(System.lineSeparator());
        saveProduct(product);
        logMessages.append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()))
                .append(" данные добавлены");
        saveLogs(product, logMessages.toString());
    }

    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        );
    }
}
