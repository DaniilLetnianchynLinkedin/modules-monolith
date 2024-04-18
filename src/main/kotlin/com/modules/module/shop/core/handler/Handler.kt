package com.modules.module.shop.core.handler

import com.modules.module.shop.core.CommunicationProtocols
import com.modules.module.shop.core.IPayload
import com.modules.module.shop.core.IResult

interface Handler<P : IPayload, R : IResult?> {
    val protocol: CommunicationProtocols
    val type: String
    fun handle(payload: P?): R?
}