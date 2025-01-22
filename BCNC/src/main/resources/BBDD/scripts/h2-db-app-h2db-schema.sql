-- Crear tabla BRANDS
CREATE TABLE BRANDS (
    BRAND_ID INT NOT NULL PRIMARY KEY,  -- Identificador único de la cadena
    BRAND_NAME VARCHAR(100) NOT NULL   -- Nombre de la cadena (e.g., ZARA)
);

-- Crear tabla PRICES
CREATE TABLE PRICES (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Identificador único para la tabla
    BRAND_ID INT NOT NULL,              -- Identificador de la cadena del grupo (e.g., 1 = ZARA)
    START_DATE DATETIME NOT NULL,       -- Fecha de inicio de la aplicación del precio
    END_DATE DATETIME NOT NULL,         -- Fecha de fin de la aplicación del precio
    PRICE_LIST INT NOT NULL,            -- Identificador de la tarifa de precios
    PRODUCT_ID INT NOT NULL,            -- Identificador del producto
    PRIORITY INT NOT NULL,              -- Prioridad de la tarifa
    PRICE DECIMAL(10, 2) NOT NULL,      -- Precio final de venta
    CURRENCY CHAR(3) NOT NULL,              -- Moneda en formato ISO (e.g., EUR, USD)

    -- Claves foráneas
    FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(BRAND_ID)
);