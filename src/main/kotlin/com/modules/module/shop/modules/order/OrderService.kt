package com.modules.module.shop.modules.order

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class OrderService {

    @PostConstruct
    fun setup() {
        println("OrderService setup")
    }
}