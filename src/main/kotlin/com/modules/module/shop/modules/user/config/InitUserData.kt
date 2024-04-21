package com.modules.module.shop.modules.user.config

import com.modules.module.shop.modules.user.domain.User
import com.modules.module.shop.modules.user.repository.UserRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class InitUserData(
    private val userRepository: UserRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun suptUserData() {
        userRepository.findAll().toList().let { users ->
            if (users.isEmpty()) {
                USER_DATA.forEach { userRepository.save(it) }
            }
        }
    }

    companion object {
        val USER_DATA = listOf(
            User(email = "user1@example.com", sallaryIncome = 10000),
            User(email = "user2@example.com", sallaryIncome = 20000),
            User(email = "user3@example.com", sallaryIncome = 30000),
            User(email = "user4@example.com", sallaryIncome = 40000),
            User(email = "user5@example.com", sallaryIncome = 50000),
            User(email = "user6@example.com", sallaryIncome = 60000),
            User(email = "user7@example.com", sallaryIncome = 70000),
            User(email = "user8@example.com", sallaryIncome = 80000),
            User(email = "user9@example.com", sallaryIncome = 90000),
            User(email = "user10@example.com", sallaryIncome = 100000)
        )
    }
}