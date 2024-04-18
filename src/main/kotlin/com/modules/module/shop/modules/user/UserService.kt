package com.modules.module.shop.modules.user

import com.modules.module.shop.contracts.user.UserIncomeResult
import com.modules.module.shop.modules.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUserIncome(id: Long): UserIncomeResult {
        return userRepository.getUserInfo(id)?.let {
            UserIncomeResult(
                id = it.id,
                sallaryIncome = it.sallaryIncome
            )
        } ?: throw IllegalStateException("User not found")
    }
}