package com.modules.module.shop.modules.product

import com.modules.module.shop.contracts.product.ProductDto
import com.modules.module.shop.contracts.product.ProductsSuggestionResposne
import com.modules.module.shop.contracts.user.GetUserIncomeCommand
import com.modules.module.shop.contracts.user.GetUserIncomePayload
import com.modules.module.shop.contracts.user.UserIncomeResult
import com.modules.module.shop.core.Mediator
import com.modules.module.shop.modules.product.domain.Product
import com.modules.module.shop.modules.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val mediator: Mediator
) {

    fun getProductSuggestions(userId: Long): ProductsSuggestionResposne {
        val userIncome = getUserIncomePercentage(userId, SALLARY_PERCENTAGE)
        return productRepository.findAllByPriceIsLessThan(userIncome).let { products ->
            ProductsSuggestionResposne(
                products = products.toDto()
            )
        }
    }

    private fun getUserIncomePercentage(userId: Long, percentage: Double): Double {
        return mediator.getCommandByType(GetUserIncomeCommand.name)?.let { command ->
            val incomeResult = mediator.send(
                command,
                GetUserIncomePayload(userId)
            ) as UserIncomeResult
            incomeResult.sallaryIncome * percentage / 100
        } ?: throw IllegalStateException("User income not found")
    }

    private fun List<Product>.toDto() = map {
        ProductDto(
            id = it.id,
            name = it.name,
            price = it.price
        )
    }

    companion object {
        const val SALLARY_PERCENTAGE = 10.0
    }
}