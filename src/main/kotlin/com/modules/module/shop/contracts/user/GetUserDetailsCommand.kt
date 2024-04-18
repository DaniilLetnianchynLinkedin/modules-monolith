package com.modules.module.shop.contracts.user

import com.modules.module.shop.core.Command
import org.springframework.stereotype.Component

@Component
class GetUserDetailsCommand<P: GetUserDetailsPayload?, R: UserDetailsResult?>(
) : Command<GetUserDetailsPayload, UserDetailsResult> {
    override val type: String = name

    override fun resultType() = UserDetailsResult::class.java
    override fun payloadType() = GetUserDetailsPayload::class.java

    companion object {
        const val name: String = "GetUserDetails"
    }
}