package com.modules.module.shop

import com.modules.module.shop.core.Mediator
import com.modules.module.shop.modules.user.command.payload.GetUserDetailsPayload
import com.modules.module.shop.modules.user.command.result.UserDetailsResult
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class Test(
    val mediator: Mediator
) {

    @PostConstruct
    fun init() {
        mediator.getCommandByType("GetUserDetails")?.let {
            val getUserDetailsPayload = GetUserDetailsPayload(
                id = 1
            )
            val result = mediator.send(it, getUserDetailsPayload) as UserDetailsResult
            println(result.userName)
            println(result.email)
        }
    }
}