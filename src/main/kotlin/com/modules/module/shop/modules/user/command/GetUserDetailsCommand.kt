package com.modules.module.shop.modules.user.command

import com.modules.module.shop.core.Command
import com.modules.module.shop.modules.user.command.payload.GetUserDetailsPayload
import com.modules.module.shop.modules.user.command.result.UserDetailsResult
import org.springframework.stereotype.Component

@Component
class GetUserDetailsCommand<P: GetUserDetailsPayload, R: UserDetailsResult?>(
) : Command<GetUserDetailsPayload, UserDetailsResult> {
    override val type: String = "GetUserDetails"
}