package com.modules.module.shop.modules.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/income/{userId}")
    fun getUserIncome(
        @PathVariable userId: Long
    ) = userService.getUserIncome(userId)
}