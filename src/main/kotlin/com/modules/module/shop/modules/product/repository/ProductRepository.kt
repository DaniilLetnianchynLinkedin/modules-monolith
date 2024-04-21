package com.modules.module.shop.modules.product.repository

import com.modules.module.shop.modules.product.domain.Product
import org.springframework.data.repository.CrudRepository


interface ProductRepository : CrudRepository<Product, Long> {
    fun findAllByPriceIsLessThan(price: Double): List<Product>
}