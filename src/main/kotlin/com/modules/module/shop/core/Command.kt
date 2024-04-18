package com.modules.module.shop.core

interface Command<P : IPayload, R : IResult?> {
    val type: String

    fun resultType(): Class<R>
    fun payloadType(): Class<P>
}