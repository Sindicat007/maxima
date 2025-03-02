CREATE TABLE products.products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);
CREATE TABLE products.logs (
    id SERIAL PRIMARY KEY,
    message TEXT NOT NULL
);