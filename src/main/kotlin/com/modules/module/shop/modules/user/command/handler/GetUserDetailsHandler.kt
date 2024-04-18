package com.modules.module.shop.modules.user.command.handler

import com.modules.module.shop.contracts.user.GetUserDetailsCommand
import com.modules.module.shop.contracts.user.GetUserDetailsPayload
import com.modules.module.shop.contracts.user.UserDetailsResult
import com.modules.module.shop.core.handler.InternalHandler
import com.modules.module.shop.modules.user.UserService
import org.springframework.stereotype.Component

@Component
class GetUserDetailsHandler<P : GetUserDetailsPayload?, R : UserDetailsResult?>(
  private val userService: UserService
) : InternalHandler<GetUserDetailsPayload, UserDetailsResult>() {
    override val type: String = GetUserDetailsCommand.name

    override fun handle(payload: GetUserDetailsPayload?): UserDetailsResult? {
        return userService.getUserDetails(payload!!.id)
    }
}