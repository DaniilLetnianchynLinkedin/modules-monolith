package com.modules.module.shop.contracts

import com.modules.module.shop.core.IPayload
import com.modules.module.shop.core.IResult

interface Command<P : IPayload, R : IResult?> {
    val type: String

    fun resultType(): Class<R>
    fun payloadType(): Class<P>
}