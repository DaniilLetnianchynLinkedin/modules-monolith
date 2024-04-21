package com.modules.module.shop.modules.product.config

import com.modules.module.shop.modules.product.domain.Product
import com.modules.module.shop.modules.product.repository.ProductRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class InitProductData(
    private val productRepository: ProductRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun suptUserData() {
        productRepository.findAll().toList().let { products ->
            if (products.isEmpty()) {
                PRODUCT_DATA.forEach { productRepository.save(it) }
            }
        }
    }

    companion object {
        val PRODUCT_DATA = listOf(
            Product(name = "Product 1", price = 900.0),
            Product(name = "Product 2", price = 1000.0),
            Product(name = "Product 3", price = 2000.0),
            Product(name = "Product 4", price = 3000.0),
            Product(name = "Product 5", price = 4000.0),
            Product(name = "Product 6", price = 5000.0),
            Product(name = "Product 7", price = 6000.0),
            Product(name = "Product 8", price = 7000.0),
            Product(name = "Product 9", price = 8000.0),
            Product(name = "Product 10", price = 9000.0)
        )
    }
}