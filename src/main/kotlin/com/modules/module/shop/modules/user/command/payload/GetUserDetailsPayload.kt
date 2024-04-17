package com.modules.module.shop.modules.user.command.payload

import com.modules.module.shop.core.Payload

data class GetUserDetailsPayload(
    val id: Long
) : Payload