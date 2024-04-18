package com.modules.module.shop.contracts.user

import com.modules.module.shop.core.IPayload

data class GetUserDetailsPayload(
    val id: Long
) : IPayload