package com.modules.module.shop.modules.product.repository

import com.modules.module.shop.modules.product.domain.Product
import org.springframework.stereotype.Component

@Component
class ProductRepository {

    fun getProductsByPriceLower(price: Double): List<Product> {
        return PRODUCT_DATA.filter { it.price < price }
    }

    companion object {
        val PRODUCT_DATA = listOf(
            Product(1, "Product 1", 900.0),
            Product(2, "Product 2", 1000.0),
            Product(3, "Product 3", 2000.0),
            Product(4, "Product 4", 3000.0),
            Product(5, "Product 5", 4000.0),
            Product(6, "Product 6", 5000.0),
            Product(7, "Product 7", 6000.0),
            Product(8, "Product 8", 7000.0),
            Product(9, "Product 9", 8000.0),
            Product(10, "Product 10", 9000.0)
        )
    }
}