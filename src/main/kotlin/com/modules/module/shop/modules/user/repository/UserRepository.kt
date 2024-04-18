package com.modules.module.shop.modules.user.repository

import com.modules.module.shop.modules.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserRepository {

    fun getUserInfo(userId: Long): User? {
        return USER_DATA[userId]
    }

    companion object {
        val USER_DATA = mapOf(
            1L to User(1, "user1@example.com", 10000),
            2L to User(2, "user2@example.com", 20000),
            3L to User(3, "user3@example.com", 30000),
            4L to User(4, "user4@example.com", 40000),
            5L to User(5, "user5@example.com", 50000),
            6L to User(6, "user6@example.com", 60000),
            7L to User(7, "user7@example.com", 70000),
            8L to User(8, "user8@example.com", 80000),
            9L to User(9, "user9@example.com", 90000),
            10L to User(10, "user10@example.com", 100000)
        )
    }
}