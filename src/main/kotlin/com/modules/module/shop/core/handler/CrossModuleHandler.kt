package com.modules.module.shop.core.handler

import com.modules.module.shop.core.CommunicationProtocols
import com.modules.module.shop.core.IPayload
import com.modules.module.shop.core.IResult

class CrossModuleHandler<P: IPayload, R: IResult>(
    override val type: String,
    val address: String
) : Handler<P, R> {
    override val protocol = CommunicationProtocols.HTTP

    override fun handle(payload: P?): R? {
        return null
    }
}