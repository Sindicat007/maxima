package ru.maxima.springjdbc;

public class SqlRequest {
    //Запросы к БД для работы с Product
    public static final String SAVE_PRODUCT = "INSERT INTO products.products (name, price) VALUES(?, ?)";
    public static final String UPDATE_PRODUCT = "UPDATE products.products SET name = ?, price = ? WHERE id = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM products.products WHERE id =?";
    public static final String GET_PRODUCT_BY_ID = "SELECT * FROM products.products WHERE id = ?";
    public static final String GET_ALL_PRODUCTS = "SELECT * FROM products.products";

    //Запросы к БД для работы с Logs
    public static final String SAVE_LOG = "INSERT INTO products.logs (id, message) VALUES (?, ?)";
    public static final String GET_LOGS = "SELECT * FROM products.logs";


}
