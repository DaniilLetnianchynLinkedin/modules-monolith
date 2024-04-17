package com.modules.module.shop.modules.user.command.handler

import com.modules.module.shop.core.Handler
import com.modules.module.shop.core.Module
import com.modules.module.shop.modules.user.UserService
import com.modules.module.shop.modules.user.command.payload.GetUserDetailsPayload
import com.modules.module.shop.modules.user.command.result.UserDetailsResult
import org.springframework.stereotype.Component

@Component
class GetUserDetailsHandler<P : GetUserDetailsPayload, R : UserDetailsResult?>(
  private val userService: UserService
) : Handler<GetUserDetailsPayload, UserDetailsResult> {
    override val type: String = "GetUserDetails"
    override val module: Module = Module.USER

    override fun handle(payload: GetUserDetailsPayload?): UserDetailsResult? {
        return userService.getUserDetails(payload!!.id)
    }
}