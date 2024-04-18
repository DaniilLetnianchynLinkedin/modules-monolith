package com.modules.module.shop.core

import com.modules.module.shop.contracts.user.GetUserDetailsPayload
import com.modules.module.shop.contracts.user.UserDetailsResult
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class Test(
    val mediator: Mediator
) {

    @EventListener(ApplicationReadyEvent::class)
    fun init() {
        logger.info("Test")
        mediator.getCommandByType("GetUserDetails")?.let {
            val getUserDetailsPayload = GetUserDetailsPayload(
                id = 1
            )
            val result = mediator.send(it, getUserDetailsPayload) as UserDetailsResult
            println(result.userName)
            println(result.email)
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger(Test::class.java)
    }
}