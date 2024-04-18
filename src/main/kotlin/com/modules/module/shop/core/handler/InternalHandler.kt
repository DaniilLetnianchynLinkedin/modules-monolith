package com.modules.module.shop.core.handler

import com.modules.module.shop.core.CommunicationProtocols
import com.modules.module.shop.core.IPayload
import com.modules.module.shop.core.IResult

abstract class InternalHandler<P : IPayload, R : IResult?> : Handler<P, R>{
    override val protocol = CommunicationProtocols.INTERNAL
}