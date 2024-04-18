package com.modules.module.shop.modules.product

import com.modules.module.shop.contracts.product.ProductsSuggestionResposne
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("/suggestions/{userId}")
    fun getProductSuggestion(
        @PathVariable userId: Long
    ): ProductsSuggestionResposne {
        return productService.getProductSuggestions(userId)
    }
}