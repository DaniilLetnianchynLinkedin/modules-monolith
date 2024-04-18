package com.modules.module.shop.contracts.user

import com.modules.module.shop.contracts.Command
import org.springframework.stereotype.Component

@Component
class GetUserIncomeCommand<P: GetUserIncomePayload?, R: UserIncomeResult?>(
) : Command<GetUserIncomePayload, UserIncomeResult> {
    override val type: String = name

    override fun resultType() = UserIncomeResult::class.java
    override fun payloadType() = GetUserIncomePayload::class.java

    companion object {
        const val name: String = "GetUserIncome"
    }
}